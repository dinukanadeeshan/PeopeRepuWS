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
@Table(name = "userjobdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userjobdetail.findAll", query = "SELECT u FROM Userjobdetail u"),
    @NamedQuery(name = "Userjobdetail.findByUserId", query = "SELECT u FROM Userjobdetail u WHERE u.userjobdetailPK.userId = :userId"),
    @NamedQuery(name = "Userjobdetail.findByJobId", query = "SELECT u FROM Userjobdetail u WHERE u.userjobdetailPK.jobId = :jobId"),
    @NamedQuery(name = "Userjobdetail.findByPriority", query = "SELECT u FROM Userjobdetail u WHERE u.priority = :priority")})
public class Userjobdetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserjobdetailPK userjobdetailPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "priority")
    private int priority;
    @JoinColumn(name = "jobId", referencedColumnName = "jobId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Job job;
    @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    public Userjobdetail() {
    }

    public Userjobdetail(UserjobdetailPK userjobdetailPK) {
        this.userjobdetailPK = userjobdetailPK;
    }

    public Userjobdetail(UserjobdetailPK userjobdetailPK, int priority) {
        this.userjobdetailPK = userjobdetailPK;
        this.priority = priority;
    }

    public Userjobdetail(String userId, String jobId) {
        this.userjobdetailPK = new UserjobdetailPK(userId, jobId);
    }

    public UserjobdetailPK getUserjobdetailPK() {
        return userjobdetailPK;
    }

    public void setUserjobdetailPK(UserjobdetailPK userjobdetailPK) {
        this.userjobdetailPK = userjobdetailPK;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userjobdetailPK != null ? userjobdetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userjobdetail)) {
            return false;
        }
        Userjobdetail other = (Userjobdetail) object;
        if ((this.userjobdetailPK == null && other.userjobdetailPK != null) || (this.userjobdetailPK != null && !this.userjobdetailPK.equals(other.userjobdetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.redonz.hb.peoplerepu.entity.Userjobdetail[ userjobdetailPK=" + userjobdetailPK + " ]";
    }
    
}
