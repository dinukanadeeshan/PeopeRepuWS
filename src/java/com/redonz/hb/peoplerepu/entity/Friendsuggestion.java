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
@Table(name = "friendsuggestion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Friendsuggestion.findAll", query = "SELECT f FROM Friendsuggestion f"),
    @NamedQuery(name = "Friendsuggestion.findBySender", query = "SELECT f FROM Friendsuggestion f WHERE f.friendsuggestionPK.sender = :sender"),
    @NamedQuery(name = "Friendsuggestion.findByReciever", query = "SELECT f FROM Friendsuggestion f WHERE f.friendsuggestionPK.reciever = :reciever"),
    @NamedQuery(name = "Friendsuggestion.findByRecieverAndSuggested", query = "SELECT f FROM Friendsuggestion f WHERE f.friendsuggestionPK.reciever = :reciever AND f.friendsuggestionPK.suggestedFriend = :suggestedFriend"),
    @NamedQuery(name = "Friendsuggestion.findBySuggestedFriend", query = "SELECT f FROM Friendsuggestion f WHERE f.friendsuggestionPK.suggestedFriend = :suggestedFriend"),
    @NamedQuery(name = "Friendsuggestion.findByStatus", query = "SELECT f FROM Friendsuggestion f WHERE f.status = :status")})
public class Friendsuggestion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FriendsuggestionPK friendsuggestionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "suggestedFriend", referencedColumnName = "userId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;
    @JoinColumn(name = "sender", referencedColumnName = "userId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user1;
    @JoinColumn(name = "reciever", referencedColumnName = "userId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user2;

    public Friendsuggestion() {
    }

    public Friendsuggestion(FriendsuggestionPK friendsuggestionPK) {
        this.friendsuggestionPK = friendsuggestionPK;
    }

    public Friendsuggestion(FriendsuggestionPK friendsuggestionPK, int status) {
        this.friendsuggestionPK = friendsuggestionPK;
        this.status = status;
    }

    public Friendsuggestion(String sender, String reciever, String suggestedFriend) {
        this.friendsuggestionPK = new FriendsuggestionPK(sender, reciever, suggestedFriend);
    }

    public FriendsuggestionPK getFriendsuggestionPK() {
        return friendsuggestionPK;
    }

    public void setFriendsuggestionPK(FriendsuggestionPK friendsuggestionPK) {
        this.friendsuggestionPK = friendsuggestionPK;
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

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendsuggestionPK != null ? friendsuggestionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Friendsuggestion)) {
            return false;
        }
        Friendsuggestion other = (Friendsuggestion) object;
        if ((this.friendsuggestionPK == null && other.friendsuggestionPK != null) || (this.friendsuggestionPK != null && !this.friendsuggestionPK.equals(other.friendsuggestionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.redonz.hb.peoplerepu.entity.Friendsuggestion[ friendsuggestionPK=" + friendsuggestionPK + " ]";
    }
    
}
