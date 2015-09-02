package com.demo.dropwizard.resource;

import com.codahale.metrics.annotation.Timed;
import com.demo.dropwizard.dao.StaffDAO;
import com.demo.dropwizard.model.Staff;
import com.demo.dropwizard.util.Constant;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.math.NumberUtils;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by CongDanh on 8/27/15.
 */
@Path("/staff")
@Produces(MediaType.APPLICATION_JSON)
public class StaffResource {
    private final StaffDAO staffDAO;

    public StaffResource(StaffDAO staffDAO) {
        this.staffDAO = staffDAO;
    }

    @GET
    @Timed
    @Path("/find/{id}")
    public Response findById(@PathParam("id") long id) {
        Staff staff = staffDAO.findById(id);
        if (staff != null) {
            return Response.ok().header(Constant.CONTENT_TYPE, MediaType.APPLICATION_JSON).entity(staff).build();
        }
        return Response.status(HttpServletResponse.SC_BAD_REQUEST).header(Constant.CONTENT_TYPE, MediaType.APPLICATION_JSON).entity("{\"message\":\"Request fail! Staff not found!\"}").build();
    }

    @POST
    @Timed
    @Path("/addJson")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStaffWithJson(Staff staff) {
        System.out.println("Request : " + ToStringBuilder.reflectionToString(staff));
        Staff save = this.handleAddStaff(staff, null);
        return buildResponseForAdd(save);
    }

    @POST
    @Timed
    @Path("/addForm")
    public Response addStaffWithForm(MultivaluedMap<String, String> params) {
        System.out.println("Request : " + params);
        Staff save = this.handleAddStaff(null, params);
        return buildResponseForAdd(save);
    }

    private Response buildResponseForAdd(Staff staff) {
        if (staff != null)
            return Response.ok().header(Constant.CONTENT_TYPE, MediaType.APPLICATION_JSON).entity(staff).build();
        else
            return Response.status(HttpServletResponse.SC_BAD_REQUEST).header(Constant.CONTENT_TYPE, MediaType.APPLICATION_JSON).entity("{\"message\":\"Insert fail!\"}").build();
    }

    private Staff handleAddStaff(Staff staff, MultivaluedMap<String, String> params) {
        if (staff == null && params == null) {
            return null;
        }
        if (staff == null) {
            staff = convertParamsToStaff(params);
        }
        staff.setBirthday(new Timestamp(new Date().getTime()));
        long id = staffDAO.create(staff);
        if (id > 0) {
            staff.setId(id);
            return staff;
        } else {
            return null;
        }
    }

    private Staff convertParamsToStaff(MultivaluedMap<String, String> params) {
        Staff staff = new Staff();
        staff.setFirstName(params.getFirst("firstName"));
        staff.setLastName(params.getFirst("lastName"));
        staff.setMiddleName(params.getFirst("middleName"));
        staff.setAddress(params.getFirst("address"));
        staff.setSalary(NumberUtils.toInt(params.getFirst("salary"), 0));
        staff.setCurrency(params.getFirst("currency"));
        return staff;
    }
}
