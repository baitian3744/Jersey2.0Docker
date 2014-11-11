package org.harry.rs.employeesample.resources;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.harry.rs.employeesample.model.Ping;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;



@Path("/ping")
@Controller
@Scope("prototype")
public class PingResource {
	private static final String defaultHostName = "localhost";

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Ping getPing(){
		Ping  ping = new Ping();
		ping.setRequestTime(getCurrentTime());
		ping.setHealthStatus(Ping.HealthStatus.ACTIVE);
		ping.setLocationURI("http://+"+hostname()+":8080/"+"employee-sample-rs");
		ping.setMachineName(hostname());
		ping.setGuid(uuid());
		return ping;
		
	}


    private String hostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException uhe) {
            return defaultHostName;
        }
    }

    private String uuid() {
        return UUID.randomUUID().toString();
    }


	private String getCurrentTime() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(calendar.getTime());
	}

}
