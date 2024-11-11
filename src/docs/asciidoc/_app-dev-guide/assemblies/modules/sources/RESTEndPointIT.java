package org.wildfly.quickstarts.rshelloworld;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RESTEndPointIT {
    private Client client;
    private static final String DEFAULT_SERVER_HOST = "http://localhost:8080/helloworld-rs";

    private static String getServerHost() {
    String serverHost = System.getenv("SERVER_HOST");
        if (serverHost == null) {
            serverHost = System.getProperty("server.host");
        }
        if (serverHost == null) {
            serverHost = DEFAULT_SERVER_HOST;
        }
        return serverHost;
    }

    @Before
    public void before() {
        client = ClientBuilder.newClient();
    }

    @After
    public void after() {
        client.close();
    }

    @Test
    public void testRestEndPoint() {
        WebTarget target = client.target(getServerHost())
                .path("/rest/HelloWorld");
        String responseMessage = target.request(MediaType.TEXT_PLAIN).get(String.class);
        assertEquals("Hello World!", responseMessage);
    }
}