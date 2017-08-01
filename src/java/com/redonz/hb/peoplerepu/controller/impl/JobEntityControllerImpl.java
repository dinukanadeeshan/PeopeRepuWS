/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redonz.hb.peoplerepu.controller.impl;

import com.redonz.hb.peoplerepu.controller.AbstractEntityController;
import com.redonz.hb.peoplerepu.controller.JobEntityController;
import com.redonz.hb.peoplerepu.entity.Job;
import com.redonz.hb.peoplerepu.entity.Userjobdetail;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author DI_SH
 */
@Stateless
public class JobEntityControllerImpl extends  AbstractEntityController<String, Job> implements JobEntityController{

    public JobEntityControllerImpl() {
        super(String.class, Job.class);
    }

    
    
    @Override
    public List<Userjobdetail> getUsersByJob(String jobId) {
        Query q = getEntityManager().createNamedQuery("Job.findByJobId");
        q.setParameter(1, jobId);
        Job rst = (Job) q.getSingleResult();
        return rst.getUserjobdetailList();
    }
    
}
