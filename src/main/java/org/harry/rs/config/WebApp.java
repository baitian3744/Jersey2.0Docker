package org.harry.rs.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.harry.rs.employeesample.jersey.MyApplication;
import org.slf4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class WebApp implements WebApplicationInitializer {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(WebApp.class);


    public void onStartup(final ServletContext servletContext) throws ServletException {

        LOG.debug("Load the Spring beans:");

        servletContext.addListener(ContextLoaderListener.class);
        servletContext.setInitParameter(ContextLoader.CONTEXT_CLASS_PARAM,
                AnnotationConfigWebApplicationContext.class.getName());
        servletContext.setInitParameter(ContextLoader.CONFIG_LOCATION_PARAM, AppConfig.class.getName());

        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("JerseyServlet",
                ServletContainer.class.getName());
        servletRegistration.addMapping("/*");
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.setInitParameter("javax.ws.rs.Application", MyApplication.class.getName());
        LOG.debug("Register the Jersey Application Classes with the web app");


    }

}
