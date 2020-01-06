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
@Table(name = "niveauxacademique")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Niveauxacademique.findAll", query = "SELECT n FROM Niveauxacademique n"),
    @NamedQuery(name = "Niveauxacademique.findByIdniveaux", query = "SELECT n FROM Niveauxacademique n WHERE n.idniveaux = :idniveaux"),
    @NamedQuery(name = "Niveauxacademique.findByLibelleniveaux", query = "SELECT n FROM Niveauxacademique n WHERE n.libelleniveaux = :libelleniveaux")})
public class Niveauxacademique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "idniveaux")
    private String idniveaux;
    @Size(max = 254)
    @Column(name = "libelleniveaux")
    private String libelleniveaux;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idniveaux")
    private List<Enseignant> enseignantList;

    public Niveauxacademique() {
    }

    public Niveauxacademique(String idniveaux) {
        this.idniveaux = idniveaux;
    }

    public String getIdniveaux() {
        return idniveaux;
    }

    public void setIdniveaux(String idniveaux) {
        this.idniveaux = idniveaux;
    }

    public String getLibelleniveaux() {
        return libelleniveaux;
    }

    public void setLibelleniveaux(String libelleniveaux) {
        this.libelleniveaux = libelleniveaux;
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
        hash += (idniveaux != null ? idniveaux.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveauxacademique)) {
            return false;
        }
        Niveauxacademique other = (Niveauxacademique) object;
        if ((this.idniveaux == null && other.idniveaux != null) || (this.idniveaux != null && !this.idniveaux.equals(other.idniveaux))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Niveauxacademique[ idniveaux=" + idniveaux + " ]";
    }
    
}
