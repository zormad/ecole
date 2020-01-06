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
@Table(name = "modepaiement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modepaiement.findAll", query = "SELECT m FROM Modepaiement m"),
    @NamedQuery(name = "Modepaiement.findByIdmode", query = "SELECT m FROM Modepaiement m WHERE m.idmode = :idmode"),
    @NamedQuery(name = "Modepaiement.findByLibellemode", query = "SELECT m FROM Modepaiement m WHERE m.libellemode = :libellemode")})
public class Modepaiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmode")
    private Integer idmode;
    @Size(max = 254)
    @Column(name = "libellemode")
    private String libellemode;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idmode")
    private List<Paiement> paiementList;

    public Modepaiement() {
    }

    public Modepaiement(Integer idmode) {
        this.idmode = idmode;
    }

    public Integer getIdmode() {
        return idmode;
    }

    public void setIdmode(Integer idmode) {
        this.idmode = idmode;
    }

    public String getLibellemode() {
        return libellemode;
    }

    public void setLibellemode(String libellemode) {
        this.libellemode = libellemode;
    }

    @XmlTransient
    public List<Paiement> getPaiementList() {
        return paiementList;
    }

    public void setPaiementList(List<Paiement> paiementList) {
        this.paiementList = paiementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmode != null ? idmode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modepaiement)) {
            return false;
        }
        Modepaiement other = (Modepaiement) object;
        if ((this.idmode == null && other.idmode != null) || (this.idmode != null && !this.idmode.equals(other.idmode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Modepaiement[ idmode=" + idmode + " ]";
    }
    
}
