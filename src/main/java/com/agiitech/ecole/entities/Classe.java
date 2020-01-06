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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP-FOLIO
 */
@Entity
@Table(name = "classe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c"),
    @NamedQuery(name = "Classe.findByIdclasse", query = "SELECT c FROM Classe c WHERE c.idclasse = :idclasse"),
    @NamedQuery(name = "Classe.findByDescriptionclasse", query = "SELECT c FROM Classe c WHERE c.descriptionclasse = :descriptionclasse")})
public class Classe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idclasse")
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classe_seq")
    @SequenceGenerator(
            name = "classe_seq",
            sequenceName = "clsse_idclsse_seq",
            allocationSize = 1
    )
    private Integer idclasse;
    @Column(name = "descriptionclasse")
    private String descriptionclasse;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "classe")
    private List<Inscription> inscriptionList;
    @JoinColumn(name = "idniveaux", referencedColumnName = "idniveaux")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Niveaux idniveaux;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idclasse")
    private List<Cours> coursList;

    public Classe() {
    }

    public Classe(Integer idclasse) {
        this.idclasse = idclasse;
    }

    public Integer getIdclasse() {
        return idclasse;
    }

    public void setIdclasse(Integer idclasse) {
        this.idclasse = idclasse;
    }

    public String getDescriptionclasse() {
        return descriptionclasse;
    }

    public void setDescriptionclasse(String descriptionclasse) {
        this.descriptionclasse = descriptionclasse;
    }

    @XmlTransient
    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    public Niveaux getIdniveaux() {
        return idniveaux;
    }

    public void setIdniveaux(Niveaux idniveaux) {
        this.idniveaux = idniveaux;
    }

    @XmlTransient
    public List<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclasse != null ? idclasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.idclasse == null && other.idclasse != null) || (this.idclasse != null && !this.idclasse.equals(other.idclasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Classe[ idclasse=" + idclasse + " ]";
    }
    
}
