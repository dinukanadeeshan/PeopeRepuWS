/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.hb.peoplerepu.service;

import com.redonz.hb.peoplerepu.controller.FriendRequestEntityController;
import com.redonz.hb.peoplerepu.entity.Friendrequestdetail;
import com.redonz.hb.peoplerepu.entity.FriendrequestdetailPK;
import static com.redonz.hb.peoplerepu.Status.*;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
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
@Path("friendrequest")
@Stateless
public class FriendrequestWebService {

    @Context
    private UriInfo context;

    @Inject
    private FriendRequestEntityController entityController;

    @EJB
    private FriendSuggetionWebService suggetionWebService;
    
    /**
     * Creates a new instance of FriendrequestWebService
     */
    public FriendrequestWebService() {
    }

    /**
     * Retrieves representation of an instance of
     * com.redonz.hb.peoplerepu.service.FriendrequestWebService
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
     * PUT method for updating or creating an instance of
     * FriendrequestWebService
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

    @PUT
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String makeFriendRequest(@QueryParam("from") String fromUserId, @QueryParam("to") String toUserId) {
        

        if (!isFriend(fromUserId, toUserId)) {
            Friendrequestdetail friendrequestdetail = new Friendrequestdetail(new FriendrequestdetailPK(fromUserId, toUserId), PENDING);

            entityController.insert(friendrequestdetail);
            if (suggetionWebService.hasSuggested(fromUserId, toUserId)) {
                /*
                    add point
                
                */
            }
            return "Friend Request Added...";
        } else {
            return "Already Friend or has sent/got request....";
        }

    }

    @PUT
    @Path("/accept")
    @Produces(MediaType.TEXT_PLAIN)

    public String acceptRequest(@QueryParam("user1") String user1, @QueryParam("user2") String user2) {
//        Friendrequestdetail friendrequestdetail = new Friendrequestdetail(new FriendrequestdetailPK(user1, user2), ACCEPTED);
//        entityController.update(friendrequestdetail);
//        return "Accepted";
        Friendrequestdetail friendrequestdetail = entityController.search(new FriendrequestdetailPK(user1, user2));
        if (friendrequestdetail != null) {
            entityController.update(friendrequestdetail);
            return "Accepted";
        } else {
            return "No such request";
        }
    }

    @PUT
    @Path("/reject")
    @Produces(MediaType.TEXT_PLAIN)

    public String rejectRequest(@QueryParam("user1") String user1, @QueryParam("user2") String user2) {
//        Friendrequestdetail friendrequestdetail = new Friendrequestdetail(new FriendrequestdetailPK(user1, user2), REJECTED);
        Friendrequestdetail friendrequestdetail = entityController.search(new FriendrequestdetailPK(user1, user2));
        if (friendrequestdetail != null) {
            entityController.update(friendrequestdetail);
            return "Rejected";
        } else {
            return "No such request";
        }
    }

    @GET
    @Path("/view/pending")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Friendrequestdetail> viewPendingRequestList(@QueryParam("user1") String user1) {

        return entityController.getFriendrequestdetailsByUser1AndStatus(user1, PENDING);

    }

    @GET
    @Path("/view/new")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Friendrequestdetail> viewNewRequestList(@QueryParam("user2") String user2) {

        return entityController.getFriendrequestdetailsByUser2AndStatus(user2, PENDING);

    }

    @GET
    @Path("/view/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Friendrequestdetail> getFriendList(@QueryParam("user") String user) {
        List<Friendrequestdetail> list1 = entityController.getFriendrequestdetailsByUser1AndStatus(user, ACCEPTED);
        List<Friendrequestdetail> list2 = entityController.getFriendrequestdetailsByUser2AndStatus(user, ACCEPTED);
        list1.addAll(list2);
        return list1;
    }

    public boolean isFriend(String user1, String user2){
        final FriendrequestdetailPK friendrequestdetailPK1 = new FriendrequestdetailPK(user1, user2);
        final FriendrequestdetailPK friendrequestdetailPK2 = new FriendrequestdetailPK(user2, user1);
        return entityController.search(friendrequestdetailPK1) != null || entityController.search(friendrequestdetailPK2) != null;
        
    }
}
