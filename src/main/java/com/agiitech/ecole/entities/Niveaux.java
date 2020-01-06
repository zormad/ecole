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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "niveaux")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Niveaux.findAll", query = "SELECT n FROM Niveaux n"),
    @NamedQuery(name = "Niveaux.findByIdniveaux", query = "SELECT n FROM Niveaux n WHERE n.idniveaux = :idniveaux"),
    @NamedQuery(name = "Niveaux.findByLibelleniveaux", query = "SELECT n FROM Niveaux n WHERE n.libelleniveaux = :libelleniveaux"),
    @NamedQuery(name = "Niveaux.findByDescriptionniveaux", query = "SELECT n FROM Niveaux n WHERE n.descriptionniveaux = :descriptionniveaux")})
public class Niveaux implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idniveaux")
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "niv_seq")
    @SequenceGenerator(
            name = "niv_seq",
            sequenceName = "niv_idniv_seq",
            allocationSize = 1
    )
    private Integer idniveaux;
    @Size(max = 254)
    @Column(name = "libelleniveaux")
    private String libelleniveaux;
    @Size(max = 254)
    @Column(name = "descriptionniveaux")
    private String descriptionniveaux;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idniveaux")
    private List<Scolarite> scolariteList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idniveaux")
    private List<Matiere> matiereList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idniveaux")
    private List<Classe> classeList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idniveaux")
    private List<Frais> fraisList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "niveauAncienneEcole")
    private List<Eleve> eleveList;

    public Niveaux() {
    }

    public Niveaux(Integer idniveaux) {
        this.idniveaux = idniveaux;
    }

    public Integer getIdniveaux() {
        return idniveaux;
    }

    public void setIdniveaux(Integer idniveaux) {
        this.idniveaux = idniveaux;
    }

    public String getLibelleniveaux() {
        return libelleniveaux;
    }

    public void setLibelleniveaux(String libelleniveaux) {
        this.libelleniveaux = libelleniveaux;
    }

    public String getDescriptionniveaux() {
        return descriptionniveaux;
    }

    public void setDescriptionniveaux(String descriptionniveaux) {
        this.descriptionniveaux = descriptionniveaux;
    }

    @XmlTransient
    public List<Scolarite> getScolariteList() {
        return scolariteList;
    }

    public void setScolariteList(List<Scolarite> scolariteList) {
        this.scolariteList = scolariteList;
    }

    @XmlTransient
    public List<Matiere> getMatiereList() {
        return matiereList;
    }

    public void setMatiereList(List<Matiere> matiereList) {
        this.matiereList = matiereList;
    }

    @XmlTransient
    public List<Classe> getClasseList() {
        return classeList;
    }

    public void setClasseList(List<Classe> classeList) {
        this.classeList = classeList;
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
        hash += (idniveaux != null ? idniveaux.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveaux)) {
            return false;
        }
        Niveaux other = (Niveaux) object;
        if ((this.idniveaux == null && other.idniveaux != null) || (this.idniveaux != null && !this.idniveaux.equals(other.idniveaux))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Niveaux[ idniveaux=" + idniveaux + " ]";
    }
    
}
