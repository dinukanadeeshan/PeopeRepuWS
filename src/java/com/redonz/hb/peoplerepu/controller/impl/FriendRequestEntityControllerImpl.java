/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.hb.peoplerepu.controller.impl;

import com.redonz.hb.peoplerepu.controller.AbstractEntityController;
import com.redonz.hb.peoplerepu.controller.FriendRequestEntityController;
import com.redonz.hb.peoplerepu.entity.Friendrequestdetail;
import com.redonz.hb.peoplerepu.entity.FriendrequestdetailPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author DI_SH
 */
@Stateless
public class FriendRequestEntityControllerImpl extends AbstractEntityController<FriendrequestdetailPK, Friendrequestdetail> implements FriendRequestEntityController {

    public FriendRequestEntityControllerImpl() {
        super(FriendrequestdetailPK.class, Friendrequestdetail.class);
    }

    @Override
    public List<Friendrequestdetail> getFriendrequestdetailsByUser1(String user1) {
        Query q = getEntityManager().createNamedQuery("Friendrequestdetail.findByUser1");
        q.setParameter(1, user1);
        return q.getResultList();
    }

    @Override
    public List<Friendrequestdetail> getFriendrequestdetailsByUser2(String user2) {
        Query q = getEntityManager().createNamedQuery("Friendrequestdetail.findByUser2");
        q.setParameter(1, user2);
        return q.getResultList();
    }

    @Override
    public List<Friendrequestdetail> getFriendrequestdetailsByUser1AndStatus(String user1, int status) {
        Query q
                = getEntityManager().createNamedQuery("Friendrequestdetail.findByUser1AndStatus");
        q.setParameter("user1", user1);
        q.setParameter("status", status);
        return q.getResultList();
    }

    @Override
    public List<Friendrequestdetail> getFriendrequestdetailsByUser2AndStatus(String user2, int status) {
        Query q
                = getEntityManager().createNamedQuery("Friendrequestdetail.findByUser2AndStatus");
        q.setParameter("user2", user2);
        q.setParameter("status", status);
        return  q.getResultList();
    }

}
