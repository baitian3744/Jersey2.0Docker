package org.harry.rs.employeesample.resources;

import org.harry.rs.employeesample.model.Employee;
import org.harry.rs.employeesample.model.Employees;
import org.harry.rs.employeesample.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by harry on 7/31/14.
 */


@Controller
@Scope("prototype")
@Path("/employees")
public class EmployeesResource {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeesResource.class) ;

    @Autowired
    private EmployeeService customerService;

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response getEmployees() {
        LOG.debug("hello boooooo ");
        return Response.ok(customerService.getEmployees()).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response saveEmployees(Employees employees) {
        LOG.debug("hello saving Employees");

        Employees emps = customerService.saveEmployees(employees);
        LOG.debug("Saved {} Employees",emps);
        return Response.status(Response.Status.CREATED).entity(emps).build();
    }

    @Path("/{id}")
    public EmployeeResource getEmployeeDetails(@Context ResourceContext rc) {
        LOG.debug("The Details of Customer  is requested for ");
        return rc.getResource(EmployeeResource.class);
    }


}
