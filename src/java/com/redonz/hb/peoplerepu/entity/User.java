/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redonz.hb.peoplerepu.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DI_SH
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByContactNo", query = "SELECT u FROM User u WHERE u.contactNo = :contactNo")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "userId")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "lastName")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contactNo")
    private String contactNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Userjobdetail> userjobdetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Friendrequestdetail> friendrequestdetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user3", fetch = FetchType.LAZY)
    private List<Friendrequestdetail> friendrequestdetailList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Friendsuggestion> friendsuggestionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user1", fetch = FetchType.LAZY)
    private List<Friendsuggestion> friendsuggestionList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user2", fetch = FetchType.LAZY)
    private List<Friendsuggestion> friendsuggestionList2;

    public User() {
    }

    public User(String userId) {
        this.userId = userId;
    }

    public User(String userId, String userName, String password, String firstName, String lastName, String email, String contactNo) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNo = contactNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @XmlTransient
    public List<Userjobdetail> getUserjobdetailList() {
        return userjobdetailList;
    }

    public void setUserjobdetailList(List<Userjobdetail> userjobdetailList) {
        this.userjobdetailList = userjobdetailList;
    }

    @XmlTransient
    public List<Friendrequestdetail> getFriendrequestdetailList() {
        return friendrequestdetailList;
    }

    public void setFriendrequestdetailList(List<Friendrequestdetail> friendrequestdetailList) {
        this.friendrequestdetailList = friendrequestdetailList;
    }

    @XmlTransient
    public List<Friendrequestdetail> getFriendrequestdetailList1() {
        return friendrequestdetailList1;
    }

    public void setFriendrequestdetailList1(List<Friendrequestdetail> friendrequestdetailList1) {
        this.friendrequestdetailList1 = friendrequestdetailList1;
    }

    @XmlTransient
    public List<Friendsuggestion> getFriendsuggestionList() {
        return friendsuggestionList;
    }

    public void setFriendsuggestionList(List<Friendsuggestion> friendsuggestionList) {
        this.friendsuggestionList = friendsuggestionList;
    }

    @XmlTransient
    public List<Friendsuggestion> getFriendsuggestionList1() {
        return friendsuggestionList1;
    }

    public void setFriendsuggestionList1(List<Friendsuggestion> friendsuggestionList1) {
        this.friendsuggestionList1 = friendsuggestionList1;
    }

    @XmlTransient
    public List<Friendsuggestion> getFriendsuggestionList2() {
        return friendsuggestionList2;
    }

    public void setFriendsuggestionList2(List<Friendsuggestion> friendsuggestionList2) {
        this.friendsuggestionList2 = friendsuggestionList2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.redonz.hb.peoplerepu.entity.User[ userId=" + userId + " ]";
    }
    
}
