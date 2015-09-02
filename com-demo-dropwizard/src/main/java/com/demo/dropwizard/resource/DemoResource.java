package com.demo.dropwizard.resource;

import com.codahale.metrics.annotation.Timed;
import com.demo.dropwizard.util.Constant;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Danh on 8/27/15.
 */
@Path("/demo")
@Produces(MediaType.APPLICATION_JSON)
public class DemoResource {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public DemoResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    @Path("/text/{text}")
    public Response demoText(@PathParam("text") String text) {
        String demoText = this.template + ", " + this.defaultName + ", " + ToStringBuilder.reflectionToString(counter) + " : " + text;
        return Response.ok().header(Constant.CONTENT_TYPE, MediaType.APPLICATION_JSON).entity(demoText).build();
    }

}
