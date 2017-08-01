/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.hb.peoplerepu.service;

import com.redonz.hb.peoplerepu.controller.JobDetailEntityController;
import com.redonz.hb.peoplerepu.entity.Userjobdetail;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import javax.inject.Inject;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DI_SH
 */
@Path("jobdetail")
public class JobDetailWebService {

    @Context
    private UriInfo context;

    @Inject
    private JobDetailEntityController entityController;

    /**
     * Creates a new instance of JobDetailWebService
     */
    public JobDetailWebService() {

    }

    /**
     * Retrieves representation of an instance of
     * com.redonz.hb.peoplerepu.service.JobDetailWebService
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of JobDetailWebService
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

    @GET
    @Path("/get/jobs")
    @Produces(MediaType.APPLICATION_JSON)

    public List<Userjobdetail> getJobsForUser(@QueryParam("user") String user) {
        return entityController.getJobDetailByUser(user);
    }

    @GET
    @Path("/get/user")
    @Produces(MediaType.APPLICATION_JSON)

    public List<Userjobdetail> getUsersForJob(@QueryParam("job") String job) {
        return entityController.getJobDetailByJob(job);
    }

}
