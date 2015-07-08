package com.demo.jersey.server;

import com.demo.jersey.model.Staff;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by CongDanh on 7/8/15.
 */
@Path("/hello")
public class HelloWordServices {

    private static List<Staff> staffs = new ArrayList<Staff>();

    static {
        staffs.add(new Staff("Danh", "Ho", "Tien Giang", new Date(), new Date(), new Date()));
        staffs.add(new Staff("Khanh", "Dang", "Tien Giang", new Date(), new Date(), new Date()));
        staffs.add(new Staff("Ngan", "Ho", "Tien Giang", new Date(), new Date(), new Date()));
        staffs.add(new Staff("Ngoc", "Ho", "Tien Giang", new Date(), new Date(), new Date()));
    }

    @GET
    @Path("/{name}")
    public Response getName(@PathParam("name") String name) {
        System.out.println("Hello : " + name);
        return Response.status(200).entity("Hello : " + name).build();
    }

    @GET
    @Path("/infoJson/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfoJson(@PathParam("name") String name) {
        for (Staff staff : staffs) {
            if (name != null && name.equalsIgnoreCase(staff.getFirstName())) {
                return Response.status(200).entity(staff).build();
            }
        }
        return Response.status(200).entity(null).build();
    }

    @GET
    @Path("/infoXml/{name}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getInfoXml(@PathParam("name") String name) {
        for (Staff staff : staffs) {
            if (name != null && name.equalsIgnoreCase(staff.getFirstName())) {
                return Response.status(200).entity(staff).build();
            }
        }
        return Response.status(200).entity(null).build();
    }
}
