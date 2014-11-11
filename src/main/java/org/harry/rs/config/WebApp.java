package org.harry.rs.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.harry.rs.employeesample.jersey.MyApplication;
import org.slf4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@Order(1)
public class WebApp implements WebApplicationInitializer {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(WebApp.class);


    //@Override
    public void onStartup(ServletContext servletContext) throws ServletException {


        //these 2 parameters are required, this hack tell Jersey Spring org.glassfish.jersey.server.spring.SpringWebApplicationInitializer not to initialize the spring context;

        servletContext.setInitParameter("contextClass", "org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
        servletContext.setInitParameter("contextConfigLocation", "org.harry.rs.config.AppConfig");


        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);

        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));

        servletContext.addListener("org.springframework.web.context.request.RequestContextListener");

        LOG.debug("Register the Jersey Application Classes with the webapp");
        ResourceConfig resourceConfig = new MyApplication();
        ServletContainer sc = new ServletContainer(resourceConfig);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("JerseyServlet", sc);

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");

    }


}
