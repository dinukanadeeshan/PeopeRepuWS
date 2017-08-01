/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redonz.hb.peoplerepu.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DI_SH
 */
@Embeddable
public class FriendrequestdetailPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "user1")
    private String user1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "user2")
    private String user2;

    public FriendrequestdetailPK() {
    }

    public FriendrequestdetailPK(String user1, String user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (user1 != null ? user1.hashCode() : 0);
        hash += (user2 != null ? user2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendrequestdetailPK)) {
            return false;
        }
        FriendrequestdetailPK other = (FriendrequestdetailPK) object;
        if ((this.user1 == null && other.user1 != null) || (this.user1 != null && !this.user1.equals(other.user1))) {
            return false;
        }
        if ((this.user2 == null && other.user2 != null) || (this.user2 != null && !this.user2.equals(other.user2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.redonz.hb.peoplerepu.entity.FriendrequestdetailPK[ user1=" + user1 + ", user2=" + user2 + " ]";
    }
    
}
