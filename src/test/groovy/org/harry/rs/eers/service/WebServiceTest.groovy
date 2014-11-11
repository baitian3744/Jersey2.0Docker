package org.harry.rs.eers.service

import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.client.ClientConfig
import org.glassfish.jersey.client.ClientResponse
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig
import org.harry.rs.config.AppConfig
import org.harry.rs.config.GsonMessageBodyHandler
import org.harry.rs.employeesample.jersey.MyApplication
import org.harry.rs.employeesample.model.Employees
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.test.context.ContextConfiguration
import spock.lang.Shared
import spock.lang.Specification

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.client.WebTarget
import javax.ws.rs.core.MediaType

/**
 * Created by harry on 7/31/14.
 */
@ContextConfiguration(classes = [org.harry.rs.config.AppConfig])
class WebServiceTest extends Specification {
    @Shared
    protected HttpServer server
    @Shared
    protected WebTarget target

    @Shared
    def baseUri = "http://localhost:8090"


    void setupSpec() {
         final ResourceConfig rc  =  new MyApplication().property("contextConfig", new AnnotationConfigApplicationContext(AppConfig.class))
        server = GrizzlyHttpServerFactory.createHttpServer(URI.create("http://localhost:8090"), rc)
        server.start();

        def config = new ClientConfig()
        Client c = ClientBuilder.newClient(config)
        target = c.target(baseUri);
    }

    void cleanupSpec() {
        server?.shutdownNow()
    }

    def "Query all Applicationwadl"() {
        when:
        String responseMsg = target.path("/application.wadl").request().get(String.class)
        then:
        responseMsg != null

    }

    def "Testing all Employees"() {
        when:
        def res = target.path("/employees").request(MediaType.APPLICATION_JSON).get(String.class)
        then:
        assert res != null;
    }
}
