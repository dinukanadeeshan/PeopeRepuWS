/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.hb.peoplerepu.controller.impl;

import com.redonz.hb.peoplerepu.controller.AbstractEntityController;
import com.redonz.hb.peoplerepu.controller.JobDetailEntityController;
import com.redonz.hb.peoplerepu.entity.Userjobdetail;
import com.redonz.hb.peoplerepu.entity.UserjobdetailPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author DI_SH
 */
@Stateless
public class JobDetailEntityControllerImpl extends AbstractEntityController<UserjobdetailPK, Userjobdetail> implements JobDetailEntityController {

    public JobDetailEntityControllerImpl() {
        super(UserjobdetailPK.class, Userjobdetail.class);
    }

    @Override
    public List<Userjobdetail> getJobDetailByUser(String user) {
        Query q = getEntityManager().createNamedQuery("Userjobdetail.findByUserId");
        q.setParameter("userId", user);
        return q.getResultList();
    }

    @Override
    public List<Userjobdetail> getJobDetailByJob(String job) {
        Query q = getEntityManager().createNamedQuery("Userjobdetail.findByJobId");
        q.setParameter("jobId", job);
        return q.getResultList();
    }

}
