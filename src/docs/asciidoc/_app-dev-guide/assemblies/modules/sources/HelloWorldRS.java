package org.jboss.as.quickstarts.rshelloworld;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")                              //<1>
public class HelloWorld {

    @GET                                //<2>
    @Path("/HelloWorld")                //<3>
    @Produces(MediaType.TEXT_PLAIN)     //<4>
    public String hello() {
        return "Hello World!";
    }
}