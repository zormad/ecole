/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP-FOLIO
 */
@Entity
@Table(name = "tranche")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tranche.findAll", query = "SELECT t FROM Tranche t"),
    @NamedQuery(name = "Tranche.findByIdtranche", query = "SELECT t FROM Tranche t WHERE t.idtranche = :idtranche"),
    @NamedQuery(name = "Tranche.findByLibelletranche", query = "SELECT t FROM Tranche t WHERE t.libelletranche = :libelletranche"),
    @NamedQuery(name = "Tranche.findByMontant", query = "SELECT t FROM Tranche t WHERE t.montant = :montant"),
    @NamedQuery(name = "Tranche.findByDelai", query = "SELECT t FROM Tranche t WHERE t.delai = :delai")})
public class Tranche implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtranche")
    private Integer idtranche;
    @Size(max = 254)
    @Column(name = "libelletranche")
    private String libelletranche;
    @Column(name = "montant")
    private Integer montant;
    @Column(name = "delai")
    @Temporal(TemporalType.DATE)
    private Date delai;
    @ManyToMany(mappedBy = "trancheList")
    private List<Scolarite> scolariteList;
    @OneToMany(mappedBy = "idtranche")
    private List<Paiement> paiementList;

    public Tranche() {
    }

    public Tranche(Integer idtranche) {
        this.idtranche = idtranche;
    }

    public Integer getIdtranche() {
        return idtranche;
    }

    public void setIdtranche(Integer idtranche) {
        this.idtranche = idtranche;
    }

    public String getLibelletranche() {
        return libelletranche;
    }

    public void setLibelletranche(String libelletranche) {
        this.libelletranche = libelletranche;
    }

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    public Date getDelai() {
        return delai;
    }

    public void setDelai(Date delai) {
        this.delai = delai;
    }

    @XmlTransient
    public List<Scolarite> getScolariteList() {
        return scolariteList;
    }

    public void setScolariteList(List<Scolarite> scolariteList) {
        this.scolariteList = scolariteList;
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
        hash += (idtranche != null ? idtranche.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tranche)) {
            return false;
        }
        Tranche other = (Tranche) object;
        if ((this.idtranche == null && other.idtranche != null) || (this.idtranche != null && !this.idtranche.equals(other.idtranche))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Tranche[ idtranche=" + idtranche + " ]";
    }
    
}
