package com.redonz.hb.peoplerepu.entity;

import com.redonz.hb.peoplerepu.entity.Userjobdetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-04-10T00:43:16")
@StaticMetamodel(Job.class)
public class Job_ { 

    public static volatile SingularAttribute<Job, String> jobId;
    public static volatile ListAttribute<Job, Userjobdetail> userjobdetailList;
    public static volatile SingularAttribute<Job, String> description;

}