/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.hb.peoplerepu.service;

import com.redonz.hb.peoplerepu.controller.FriendRequestEntityController;
import com.redonz.hb.peoplerepu.controller.FriendSuggetionEntityController;
import com.redonz.hb.peoplerepu.entity.Friendsuggestion;
import com.redonz.hb.peoplerepu.entity.FriendsuggestionPK;
import static com.redonz.hb.peoplerepu.Status.*;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author DI_SH
 */
@Path("friendsuggetion")
@Stateless
public class FriendSuggetionWebService {

    @Context
    private UriInfo context;

    @Inject
    private FriendSuggetionEntityController suggetionEntityController;

    @Inject
    private FriendRequestEntityController requestEntityController;

    @EJB
    private FriendrequestWebService friendrequestWebService;

    /**
     * Creates a new instance of FriendSuggetionWebService
     */
    public FriendSuggetionWebService() {
    }

    /**
     * Retrieves representation of an instance of
     * com.redonz.hb.peoplerepu.service.FriendSuggetionWebService
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson(@Context HttpServletRequest request) {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of
     * FriendSuggetionWebService
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/add")
//    public String suggestFriend(@QueryParam("reciever")String receiveUserId, @QueryParam("sender")String sendUserId, @QueryParam("suggest")String suggestedUserId) {
//        FriendsuggestionPK friendsuggestionPK = new FriendsuggestionPK(sendUserId, receiveUserId, suggestedUserId);
//        Friendsuggestion friendsuggestion = new Friendsuggestion(friendsuggestionPK, PENDING);
//        if (!friendrequestWebService.isFriend(receiveUserId, suggestedUserId)) {
//            suggetionEntityController.insert(friendsuggestion);
//            return "Saved...";
//        } else {
//            throw new IllegalArgumentException("Already Friend....");
//        }
//    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public String suggestFriend(Friendsuggestion friendsuggestion) {
        friendsuggestion.setStatus(PENDING);
        if (!friendrequestWebService.isFriend(friendsuggestion.getFriendsuggestionPK().getReciever(), friendsuggestion.getFriendsuggestionPK().getSuggestedFriend())) {
            suggetionEntityController.insert(friendsuggestion);
            return "Saved...";
        } else {
            throw new IllegalArgumentException("Already Friend....");
        }
    }

    @GET
    @Path("/get/suggest")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Friendsuggestion> getFriendsuggestions(@QueryParam("user") String user) {

        return suggetionEntityController.getFriendSuggetions(user);
    }

    public boolean hasSuggested(String userId, String friendId) {
        Friendsuggestion friendSuggetions = suggetionEntityController.getFriendSuggetions(userId, friendId);
        return friendSuggetions != null;
    }

}
