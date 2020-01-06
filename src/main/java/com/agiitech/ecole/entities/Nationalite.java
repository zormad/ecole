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
@Table(name = "nationalite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nationalite.findAll", query = "SELECT n FROM Nationalite n")
    ,
    @NamedQuery(name = "Nationalite.findByLibelle", query = "SELECT n FROM Nationalite n WHERE n.libelle = :libelle")
    ,
@NamedQuery(name = "Nationalite.findByPays", query = "SELECT n FROM Nationalite n WHERE n.pays = :pays")})
public class Nationalite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "pays")
    private String pays;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "libelle")
    private List<Eleve> eleveList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "libelle")
    private List<Enseignant> enseignantList;

    public Nationalite() {
    }

    public Nationalite(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public List<Eleve> getEleveList() {
        return eleveList;
    }

    public void setEleveList(List<Eleve> eleveList) {
        this.eleveList = eleveList;
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
        hash += (libelle != null ? libelle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nationalite)) {
            return false;
        }
        Nationalite other = (Nationalite) object;
        if ((this.libelle == null && other.libelle != null) || (this.libelle != null && !this.libelle.equals(other.libelle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Nationalite[ libelle=" + libelle + " ]";
    }

}
