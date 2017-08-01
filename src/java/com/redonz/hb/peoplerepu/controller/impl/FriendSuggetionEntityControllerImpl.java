/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redonz.hb.peoplerepu.controller.impl;

import com.redonz.hb.peoplerepu.controller.AbstractEntityController;
import com.redonz.hb.peoplerepu.controller.FriendSuggetionEntityController;
import com.redonz.hb.peoplerepu.entity.Friendsuggestion;
import com.redonz.hb.peoplerepu.entity.FriendsuggestionPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author DI_SH
 */
@Stateless
public class FriendSuggetionEntityControllerImpl extends AbstractEntityController<FriendsuggestionPK, Friendsuggestion>
implements FriendSuggetionEntityController{

    public FriendSuggetionEntityControllerImpl() {
        super(FriendsuggestionPK.class, Friendsuggestion.class);
    }

    @Override
    public List<Friendsuggestion> getFriendSuggetions(String user) {
        Query q = getEntityManager().createNamedQuery("Friendsuggestion.findByReciever");
        q.setParameter("reciever", user);
        return q.getResultList();
                
    }

    @Override
    public Friendsuggestion getFriendSuggetions(String userId, String friendId) {
        Query q = getEntityManager().createNamedQuery("Friendsuggestion.findByRecieverAndSuggested");
        q.setParameter("reciever", userId);
        q.setParameter("suggestedFriend", friendId);
        return (Friendsuggestion) q.getSingleResult();
    }
    
    
    
}
