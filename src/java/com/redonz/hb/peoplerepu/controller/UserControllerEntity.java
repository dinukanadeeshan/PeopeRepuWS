/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redonz.hb.peoplerepu.controller;

import com.redonz.hb.peoplerepu.entity.User;
import javax.inject.Named;

/**
 *
 * @author DI_SH
 */
public interface UserControllerEntity extends EntityController<String, User>{
    public String authenticateUser(String userName, String password);
//    List<User> getUsersByJob(String jobId);
}
