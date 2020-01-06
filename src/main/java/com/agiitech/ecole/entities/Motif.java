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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP-FOLIO
 */
@Entity
@Table(name = "motif")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motif.findAll", query = "SELECT m FROM Motif m"),
    @NamedQuery(name = "Motif.findByLibellemotif", query = "SELECT m FROM Motif m WHERE m.libellemotif = :libellemotif")})
public class Motif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "libellemotif")
    private Integer libellemotif;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "libellemotif")
    private List<Absence> absenceList;

    public Motif() {
    }

    public Motif(Integer libellemotif) {
        this.libellemotif = libellemotif;
    }

    public Integer getLibellemotif() {
        return libellemotif;
    }

    public void setLibellemotif(Integer libellemotif) {
        this.libellemotif = libellemotif;
    }

    @XmlTransient
    public List<Absence> getAbsenceList() {
        return absenceList;
    }

    public void setAbsenceList(List<Absence> absenceList) {
        this.absenceList = absenceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (libellemotif != null ? libellemotif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motif)) {
            return false;
        }
        Motif other = (Motif) object;
        if ((this.libellemotif == null && other.libellemotif != null) || (this.libellemotif != null && !this.libellemotif.equals(other.libellemotif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Motif[ libellemotif=" + libellemotif + " ]";
    }
    
}
