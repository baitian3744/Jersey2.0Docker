package org.harry.rs.employeesample.jersey;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.springframework.stereotype.Component;

@Component
public class MyRSExceptionMapper implements ExceptionMapper<IllegalArgumentException> {


    @Override
    public Response toResponse(IllegalArgumentException exception) {
        return Response.serverError().entity(exception).build();
    }
}
