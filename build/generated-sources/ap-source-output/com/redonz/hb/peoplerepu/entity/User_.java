package com.redonz.hb.peoplerepu.entity;

import com.redonz.hb.peoplerepu.entity.Friendrequestdetail;
import com.redonz.hb.peoplerepu.entity.Friendsuggestion;
import com.redonz.hb.peoplerepu.entity.Userjobdetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-04-10T00:43:16")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> lastName;
    public static volatile ListAttribute<User, Friendsuggestion> friendsuggestionList;
    public static volatile ListAttribute<User, Userjobdetail> userjobdetailList;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, String> userId;
    public static volatile ListAttribute<User, Friendrequestdetail> friendrequestdetailList1;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> password;
    public static volatile ListAttribute<User, Friendrequestdetail> friendrequestdetailList;
    public static volatile ListAttribute<User, Friendsuggestion> friendsuggestionList1;
    public static volatile ListAttribute<User, Friendsuggestion> friendsuggestionList2;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> contactNo;

}