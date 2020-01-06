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
@Table(name = "typematiere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typematiere.findAll", query = "SELECT t FROM Typematiere t"),
    @NamedQuery(name = "Typematiere.findByIdtype", query = "SELECT t FROM Typematiere t WHERE t.idtype = :idtype"),
    @NamedQuery(name = "Typematiere.findByLielletype", query = "SELECT t FROM Typematiere t WHERE t.lielletype = :lielletype")})
public class Typematiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "idtype")
    private String idtype;
    @Size(max = 254)
    @Column(name = "lielletype")
    private String lielletype;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idtype")
    private List<Matiere> matiereList;

    public Typematiere() {
    }

    public Typematiere(String idtype) {
        this.idtype = idtype;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getLielletype() {
        return lielletype;
    }

    public void setLielletype(String lielletype) {
        this.lielletype = lielletype;
    }

    @XmlTransient
    public List<Matiere> getMatiereList() {
        return matiereList;
    }

    public void setMatiereList(List<Matiere> matiereList) {
        this.matiereList = matiereList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtype != null ? idtype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typematiere)) {
            return false;
        }
        Typematiere other = (Typematiere) object;
        if ((this.idtype == null && other.idtype != null) || (this.idtype != null && !this.idtype.equals(other.idtype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Typematiere[ idtype=" + idtype + " ]";
    }
    
}
