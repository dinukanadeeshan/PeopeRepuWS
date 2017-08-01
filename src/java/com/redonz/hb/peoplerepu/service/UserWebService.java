/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.hb.peoplerepu.service;

import com.redonz.hb.peoplerepu.controller.UserControllerEntity;
import com.redonz.hb.peoplerepu.entity.User;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DI_SH
 */
@Path("/user")
@Stateless
public class UserWebService {

    @Context
    private UriInfo context;

    @Inject
    private UserControllerEntity controllerEntity;

    /**
     * Creates a new instance of UserWebService
     */
    public UserWebService() {
    }

    /**
     * Retrieves representation of an instance of
     * com.redonz.hb.peoplerepu.service.service.UserWebService
     *
     * @param userName
     * @param password
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/authUser")
    @Produces(MediaType.TEXT_PLAIN)
//    public String authUser(User user) {
    public String authUser(@QueryParam("userName") String userName, @QueryParam("password") String password) {
        return controllerEntity.authenticateUser(userName, password);
//        return controllerEntity.authenticateUser(user.getUserName(), user.getPassword());
    }

    /**
     * PUT method for updating or creating an instance of UserWebService
     *
     * @param user
     * @return
     */
    @PUT
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addUser(User user) {
        controllerEntity.insert(user);
        System.out.println("User Saved...=========>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return "User Saved...=========>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>";
    }

    @PUT
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteUser(User user) {
        controllerEntity.delete(user.getUserId());
        return "Deleted...";
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateUser(User user) {
        controllerEntity.update(user);
        return "Updated...";
    }

    
    @GET
    @Path("/test/{id}")
@Produces(MediaType.APPLICATION_JSON)
    public String test(@PathParam("id") String id) {

        return "Hellow... "+id;
    }

}
