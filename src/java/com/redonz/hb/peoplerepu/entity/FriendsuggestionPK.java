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
public class FriendsuggestionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sender")
    private String sender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "reciever")
    private String reciever;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "suggestedFriend")
    private String suggestedFriend;

    public FriendsuggestionPK() {
    }

    public FriendsuggestionPK(String sender, String reciever, String suggestedFriend) {
        this.sender = sender;
        this.reciever = reciever;
        this.suggestedFriend = suggestedFriend;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getSuggestedFriend() {
        return suggestedFriend;
    }

    public void setSuggestedFriend(String suggestedFriend) {
        this.suggestedFriend = suggestedFriend;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sender != null ? sender.hashCode() : 0);
        hash += (reciever != null ? reciever.hashCode() : 0);
        hash += (suggestedFriend != null ? suggestedFriend.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendsuggestionPK)) {
            return false;
        }
        FriendsuggestionPK other = (FriendsuggestionPK) object;
        if ((this.sender == null && other.sender != null) || (this.sender != null && !this.sender.equals(other.sender))) {
            return false;
        }
        if ((this.reciever == null && other.reciever != null) || (this.reciever != null && !this.reciever.equals(other.reciever))) {
            return false;
        }
        if ((this.suggestedFriend == null && other.suggestedFriend != null) || (this.suggestedFriend != null && !this.suggestedFriend.equals(other.suggestedFriend))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.redonz.hb.peoplerepu.entity.FriendsuggestionPK[ sender=" + sender + ", reciever=" + reciever + ", suggestedFriend=" + suggestedFriend + " ]";
    }
    
}
