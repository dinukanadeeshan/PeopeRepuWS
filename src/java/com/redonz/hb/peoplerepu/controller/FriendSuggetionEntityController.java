/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redonz.hb.peoplerepu.controller;

import com.redonz.hb.peoplerepu.entity.Friendsuggestion;
import com.redonz.hb.peoplerepu.entity.FriendsuggestionPK;
import java.util.List;

/**
 *
 * @author DI_SH
 */
public interface FriendSuggetionEntityController extends EntityController<FriendsuggestionPK, Friendsuggestion> {
    List<Friendsuggestion> getFriendSuggetions(String user);
    Friendsuggestion getFriendSuggetions(String userId, String friendId);
}
