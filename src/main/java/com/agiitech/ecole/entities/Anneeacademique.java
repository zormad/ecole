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
@Table(name = "anneeacademique")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anneeacademique.findAll", query = "SELECT a FROM Anneeacademique a"),
    @NamedQuery(name = "Anneeacademique.findByAnneeacademique", query = "SELECT a FROM Anneeacademique a WHERE a.anneeacademique = :anneeacademique")})
public class Anneeacademique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "anneeacademique")
    private String anneeacademique;
    @Column(name = "libelleannee")
    private String libelleannee;
    @JoinTable(name = "anneematiere", joinColumns = {
        @JoinColumn(name = "anneeacademique", referencedColumnName = "anneeacademique")}, inverseJoinColumns = {
        @JoinColumn(name = "idmatiere", referencedColumnName = "idmatiere")})
    @ManyToMany
    private List<Matiere> matiereList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "anneeacademique")
    private List<Scolarite> scolariteList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "anneeacademique")
    private List<Absence> absenceList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "anneeacademique")
    private List<Inscription> inscriptionList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "anneeacademique")
    private List<Controle> controleList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "anneeacademique")
    private List<Examen> examenList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "anneeacademique")
    private List<Frais> fraisList;

    public Anneeacademique() {
    }

    public Anneeacademique(String anneeacademique) {
        this.anneeacademique = anneeacademique;
    }

    public String getAnneeacademique() {
        return anneeacademique;
    }

    public String getLibelleannee() {
        return libelleannee;
    }

    public void setLibelleannee(String libelleannee) {
        this.libelleannee = libelleannee;
    }

    public void setAnneeacademique(String anneeacademique) {
        this.anneeacademique = anneeacademique;
    }

    @XmlTransient
    public List<Matiere> getMatiereList() {
        return matiereList;
    }

    public void setMatiereList(List<Matiere> matiereList) {
        this.matiereList = matiereList;
    }

    @XmlTransient
    public List<Scolarite> getScolariteList() {
        return scolariteList;
    }

    public void setScolariteList(List<Scolarite> scolariteList) {
        this.scolariteList = scolariteList;
    }

    @XmlTransient
    public List<Absence> getAbsenceList() {
        return absenceList;
    }

    public void setAbsenceList(List<Absence> absenceList) {
        this.absenceList = absenceList;
    }

    @XmlTransient
    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    @XmlTransient
    public List<Controle> getControleList() {
        return controleList;
    }

    public void setControleList(List<Controle> controleList) {
        this.controleList = controleList;
    }

    @XmlTransient
    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    @XmlTransient
    public List<Frais> getFraisList() {
        return fraisList;
    }

    public void setFraisList(List<Frais> fraisList) {
        this.fraisList = fraisList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anneeacademique != null ? anneeacademique.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anneeacademique)) {
            return false;
        }
        Anneeacademique other = (Anneeacademique) object;
        if ((this.anneeacademique == null && other.anneeacademique != null) || (this.anneeacademique != null && !this.anneeacademique.equals(other.anneeacademique))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Anneeacademique[ anneeacademique=" + anneeacademique + " ]";
    }
    
}
