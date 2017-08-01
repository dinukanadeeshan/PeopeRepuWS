/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redonz.hb.peoplerepu.controller;

import com.redonz.hb.peoplerepu.entity.Userjobdetail;
import com.redonz.hb.peoplerepu.entity.UserjobdetailPK;
import java.util.List;

/**
 *
 * @author DI_SH
 */
public interface JobDetailEntityController extends EntityController<UserjobdetailPK, Userjobdetail>{
    
    public List<Userjobdetail> getJobDetailByUser(String user);
    public List<Userjobdetail> getJobDetailByJob(String job);
    
}
