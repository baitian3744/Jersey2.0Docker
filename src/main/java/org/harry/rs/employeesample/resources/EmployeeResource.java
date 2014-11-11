package org.harry.rs.employeesample.resources;

import org.harry.rs.employeesample.model.Employee;
import org.harry.rs.employeesample.model.Employees;
import org.harry.rs.employeesample.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by harry on 7/31/14.
 */

@Controller
@Scope("prototype")
public class EmployeeResource {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeResource.class);

    @Autowired
    EmployeeService employeeService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getCustomer(@PathParam("id") String customerId) {
        LOG.debug("CustomerResource id{} ",customerId);
        return Response.ok(employeeService.getEmployeeDetails(customerId)).build();
    }


    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response SaveCustomer(@PathParam("id") String customerId,Employee employee) {
        LOG.debug("CustomerResource id{} ",customerId);
        System.out.println("the Id os "+customerId);
        return Response.status(Response.Status.CREATED).entity(employeeService.saveEmployee(employee)).build();
    }

    @DELETE
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteCustomer(@PathParam("id") String customerId) {
        LOG.debug("CustomerResource id{} ",customerId);
        System.out.println("the Id os "+customerId);
        return Response.ok(employeeService.getEmployeeDetails(customerId)).build();
    }


}
