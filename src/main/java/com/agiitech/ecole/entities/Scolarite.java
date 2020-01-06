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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP-FOLIO
 */
@Entity
@Table(name = "scolarite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Scolarite.findAll", query = "SELECT s FROM Scolarite s"),
    @NamedQuery(name = "Scolarite.findByIdscolarite", query = "SELECT s FROM Scolarite s WHERE s.idscolarite = :idscolarite"),
    @NamedQuery(name = "Scolarite.findByMontant", query = "SELECT s FROM Scolarite s WHERE s.montant = :montant")})
public class Scolarite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idscolarite")
    private Integer idscolarite;
    @Column(name = "montant")
    private Integer montant;
    @JoinTable(name = "scolaritetranche", joinColumns = {
        @JoinColumn(name = "idscolarite", referencedColumnName = "idscolarite")}, inverseJoinColumns = {
        @JoinColumn(name = "idtranche", referencedColumnName = "idtranche")})
    @ManyToMany
    private List<Tranche> trancheList;
    @JoinColumn(name = "anneeacademique", referencedColumnName = "anneeacademique")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Anneeacademique anneeacademique;
    @JoinColumn(name = "idniveaux", referencedColumnName = "idniveaux")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Niveaux idniveaux;

    public Scolarite() {
    }

    public Scolarite(Integer idscolarite) {
        this.idscolarite = idscolarite;
    }

    public Integer getIdscolarite() {
        return idscolarite;
    }

    public void setIdscolarite(Integer idscolarite) {
        this.idscolarite = idscolarite;
    }

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    @XmlTransient
    public List<Tranche> getTrancheList() {
        return trancheList;
    }

    public void setTrancheList(List<Tranche> trancheList) {
        this.trancheList = trancheList;
    }

    public Anneeacademique getAnneeacademique() {
        return anneeacademique;
    }

    public void setAnneeacademique(Anneeacademique anneeacademique) {
        this.anneeacademique = anneeacademique;
    }

    public Niveaux getIdniveaux() {
        return idniveaux;
    }

    public void setIdniveaux(Niveaux idniveaux) {
        this.idniveaux = idniveaux;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idscolarite != null ? idscolarite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Scolarite)) {
            return false;
        }
        Scolarite other = (Scolarite) object;
        if ((this.idscolarite == null && other.idscolarite != null) || (this.idscolarite != null && !this.idscolarite.equals(other.idscolarite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Scolarite[ idscolarite=" + idscolarite + " ]";
    }
    
}
