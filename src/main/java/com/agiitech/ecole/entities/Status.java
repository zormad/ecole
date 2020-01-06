/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author HP-FOLIO
 */
@Entity
@Table(name = "status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s"),
    @NamedQuery(name = "Status.findByLibellestatus", query = "SELECT s FROM Status s WHERE s.libellestatus = :libellestatus")})
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "libellestatus")
    private String libellestatus;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "libellestatus")
    private List<Enseignant> enseignantList;

    public Status() {
    }

    public Status(String libellestatus) {
        this.libellestatus = libellestatus;
    }

    public String getLibellestatus() {
        return libellestatus;
    }

    public void setLibellestatus(String libellestatus) {
        this.libellestatus = libellestatus;
    }

    @XmlTransient
    public List<Enseignant> getEnseignantList() {
        return enseignantList;
    }

    public void setEnseignantList(List<Enseignant> enseignantList) {
        this.enseignantList = enseignantList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (libellestatus != null ? libellestatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.libellestatus == null && other.libellestatus != null) || (this.libellestatus != null && !this.libellestatus.equals(other.libellestatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Status[ libellestatus=" + libellestatus + " ]";
    }
    
}
