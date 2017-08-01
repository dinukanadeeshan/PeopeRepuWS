/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redonz.hb.peoplerepu.controller;

import com.redonz.hb.peoplerepu.entity.Friendrequestdetail;
import com.redonz.hb.peoplerepu.entity.FriendrequestdetailPK;
import java.util.List;

/**
 *
 * @author DI_SH
 */
public interface FriendRequestEntityController extends EntityController<FriendrequestdetailPK, Friendrequestdetail>{
    List<Friendrequestdetail> getFriendrequestdetailsByUser1(String user1);
    List<Friendrequestdetail> getFriendrequestdetailsByUser2(String user2);
    List<Friendrequestdetail> getFriendrequestdetailsByUser1AndStatus(String user1, int status);
    List<Friendrequestdetail> getFriendrequestdetailsByUser2AndStatus(String user2, int status);
    
}
