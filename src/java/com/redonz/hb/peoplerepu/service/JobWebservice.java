/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redonz.hb.peoplerepu.service;

import com.redonz.hb.peoplerepu.controller.JobEntityController;
import com.redonz.hb.peoplerepu.entity.Job;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DI_SH
 */
@Path("Job")
@Stateless
public class JobWebservice {

    @Context
    private UriInfo context;

    @Inject
    private JobEntityController entityController;
    
    /**
     * Creates a new instance of JobWebservice
     */
    public JobWebservice() {
    }

    /**
     * Retrieves representation of an instance of com.redonz.hb.peoplerepu.service.JobWebservice
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of JobWebservice
     * @param content representation for the resource
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    @PUT
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public String addJob(Job job){
        entityController.insert(job);
        return "Saved";
    }
    
    
    @GET
    @Path("/get/all")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Job> getAllJobs(){
        return entityController.searchAll();
    }
}
