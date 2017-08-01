/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redonz.hb.peoplerepu.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DI_SH
 */
@Entity
@Table(name = "friendrequestdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Friendrequestdetail.findAll", query = "SELECT f FROM Friendrequestdetail f"),
    @NamedQuery(name = "Friendrequestdetail.findByUser1", query = "SELECT f FROM Friendrequestdetail f WHERE f.friendrequestdetailPK.user1 = :user1"),
    @NamedQuery(name = "Friendrequestdetail.findByUser2", query = "SELECT f FROM Friendrequestdetail f WHERE f.friendrequestdetailPK.user2 = :user2"),
    @NamedQuery(name = "Friendrequestdetail.findByUser1AndStatus", query = "SELECT f FROM Friendrequestdetail f WHERE f.friendrequestdetailPK.user1 = :user1 AND f.status = :status"),
    @NamedQuery(name = "Friendrequestdetail.findByUser2AndStatus", query = "SELECT f FROM Friendrequestdetail f WHERE f.friendrequestdetailPK.user2 = :user2 AND f.status = :status"),
    @NamedQuery(name = "Friendrequestdetail.findByStatus", query = "SELECT f FROM Friendrequestdetail f WHERE f.status = :status")})
public class Friendrequestdetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FriendrequestdetailPK friendrequestdetailPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "user1", referencedColumnName = "userId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;
    @JoinColumn(name = "user2", referencedColumnName = "userId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user3;

    public Friendrequestdetail() {
    }

    public Friendrequestdetail(FriendrequestdetailPK friendrequestdetailPK) {
        this.friendrequestdetailPK = friendrequestdetailPK;
    }

    public Friendrequestdetail(FriendrequestdetailPK friendrequestdetailPK, int status) {
        this.friendrequestdetailPK = friendrequestdetailPK;
        this.status = status;
    }

    public Friendrequestdetail(String user1, String user2) {
        this.friendrequestdetailPK = new FriendrequestdetailPK(user1, user2);
    }

    public FriendrequestdetailPK getFriendrequestdetailPK() {
        return friendrequestdetailPK;
    }

    public void setFriendrequestdetailPK(FriendrequestdetailPK friendrequestdetailPK) {
        this.friendrequestdetailPK = friendrequestdetailPK;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser3() {
        return user3;
    }

    public void setUser3(User user3) {
        this.user3 = user3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendrequestdetailPK != null ? friendrequestdetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Friendrequestdetail)) {
            return false;
        }
        Friendrequestdetail other = (Friendrequestdetail) object;
        if ((this.friendrequestdetailPK == null && other.friendrequestdetailPK != null) || (this.friendrequestdetailPK != null && !this.friendrequestdetailPK.equals(other.friendrequestdetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.redonz.hb.peoplerepu.entity.Friendrequestdetail[ friendrequestdetailPK=" + friendrequestdetailPK + " ]";
    }
    
}
