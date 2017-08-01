package com.redonz.hb.peoplerepu.entity;

import com.redonz.hb.peoplerepu.entity.Job;
import com.redonz.hb.peoplerepu.entity.User;
import com.redonz.hb.peoplerepu.entity.UserjobdetailPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-04-10T00:43:16")
@StaticMetamodel(Userjobdetail.class)
public class Userjobdetail_ { 

    public static volatile SingularAttribute<Userjobdetail, UserjobdetailPK> userjobdetailPK;
    public static volatile SingularAttribute<Userjobdetail, Integer> priority;
    public static volatile SingularAttribute<Userjobdetail, Job> job;
    public static volatile SingularAttribute<Userjobdetail, User> user;

}