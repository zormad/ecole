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
@Table(name = "situationfamilliale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Situationfamilliale.findAll", query = "SELECT s FROM Situationfamilliale s"),
    @NamedQuery(name = "Situationfamilliale.findByLibellefamillial", query = "SELECT s FROM Situationfamilliale s WHERE s.libellefamillial = :libellefamillial")})
public class Situationfamilliale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "libellefamillial")
    private String libellefamillial;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "libellefamillial")
    private List<Enseignant> enseignantList;

    public Situationfamilliale() {
    }

    public Situationfamilliale(String libellefamillial) {
        this.libellefamillial = libellefamillial;
    }

    public String getLibellefamillial() {
        return libellefamillial;
    }

    public void setLibellefamillial(String libellefamillial) {
        this.libellefamillial = libellefamillial;
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
        hash += (libellefamillial != null ? libellefamillial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Situationfamilliale)) {
            return false;
        }
        Situationfamilliale other = (Situationfamilliale) object;
        if ((this.libellefamillial == null && other.libellefamillial != null) || (this.libellefamillial != null && !this.libellefamillial.equals(other.libellefamillial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Situationfamilliale[ libellefamillial=" + libellefamillial + " ]";
    }
    
}
