package org.harry.rs.employeesample.jersey;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.harry.rs.config.GsonMessageBodyHandler;

import javax.ws.rs.ApplicationPath;

public class MyApplication extends ResourceConfig {

	public MyApplication() {
		register(RequestContextFilter.class);
		register(MyRSExceptionMapper.class);
		register(LoggingFilter.class);
        register(GsonMessageBodyHandler.class);
		packages("org.harry.rs.employeesample.resources");
	}

}
