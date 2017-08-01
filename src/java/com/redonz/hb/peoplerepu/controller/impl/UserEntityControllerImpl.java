/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.hb.peoplerepu.controller.impl;

import com.redonz.hb.peoplerepu.controller.AbstractEntityController;
import com.redonz.hb.peoplerepu.controller.UserControllerEntity;
import com.redonz.hb.peoplerepu.entity.User;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author DI_SH
 */
@Stateless

public class UserEntityControllerImpl extends AbstractEntityController<String, User> implements UserControllerEntity {

    public UserEntityControllerImpl() {
        super(String.class, User.class);
    }

    /**
     *
     * @param userName
     * @param password
     * @return
     */
    @Override
    public String authenticateUser(String userName, String password) {
        Query q = getEntityManager().createQuery("SELECT u FROM User u WHERE u.userName = :userName AND u.password = :password");
        q.setParameter("userName", userName);
        q.setParameter("password", password);
        try {
            Object rst = q.getSingleResult();
            if (rst == null) {
                return "false";
            }
            return "true";
        } catch (NoResultException ex) {
            return "false";
        } catch (NonUniqueResultException ex) {
            return "true";
        }
    }

//    @Override
//    public List<User> getUsersByJob(String jobId) {
//        getEntityManager().createQuery("SELECT u FROM User u, Job j WHERE  j.jobId = u")
//    }
//    
}
