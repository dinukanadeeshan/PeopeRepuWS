/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redonz.hb.peoplerepu.controller;

import com.redonz.hb.peoplerepu.entity.Job;
import com.redonz.hb.peoplerepu.entity.Userjobdetail;
import java.util.List;

/**
 *
 * @author DI_SH
 */
public interface  JobEntityController extends EntityController<String, Job> {
     List<Userjobdetail> getUsersByJob(String jobId);
}
