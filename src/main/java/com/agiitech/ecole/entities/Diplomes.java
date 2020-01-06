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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "diplomes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diplomes.findAll", query = "SELECT d FROM Diplomes d")
    ,
    @NamedQuery(name = "Diplomes.findByIddiplome", query = "SELECT d FROM Diplomes d WHERE d.iddiplome = :iddiplome")
    ,
    @NamedQuery(name = "Diplomes.findByIntitule", query = "SELECT d FROM Diplomes d WHERE d.intitule = :intitule")
    ,
    @NamedQuery(name = "Diplomes.findByEcole", query = "SELECT d FROM Diplomes d WHERE d.ecole = :ecole")
    ,
    @NamedQuery(name = "Diplomes.findBySpecialite", query = "SELECT d FROM Diplomes d WHERE d.specialite = :specialite")
    ,
    @NamedQuery(name = "Diplomes.findByNiveau", query = "SELECT d FROM Diplomes d WHERE d.niveau = :niveau")
    ,
    @NamedQuery(name = "Diplomes.findByDateobtention", query = "SELECT d FROM Diplomes d WHERE d.dateobtention = :dateobtention")})
public class Diplomes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddiplome")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "iddiplome_seq")
    @SequenceGenerator(
            name = "iddiplome_seq",
            sequenceName = "diplome_iddiplome_seq",
            allocationSize = 1
    )
    private Integer iddiplome;
    @Size(max = 254)
    @Column(name = "intitule")
    private String intitule;
    @Size(max = 254)
    @Column(name = "ecole")
    private String ecole;
    @Size(max = 254)
    @Column(name = "specialite")
    private String specialite;
    @Size(max = 254)
    @Column(name = "niveau")
    private String niveau;
    @Column(name = "dateobtention")
    @Temporal(TemporalType.DATE)
    private Date dateobtention;
    @JoinTable(name = "enseignantdiplome", joinColumns = {
        @JoinColumn(name = "iddiplome", referencedColumnName = "iddiplome")}, inverseJoinColumns = {
        @JoinColumn(name = "matriculeenseignant", referencedColumnName = "matriculeenseignant")})
    @ManyToMany
    private List<Enseignant> enseignantList;

    public Diplomes() {
    }

    public Diplomes(Integer iddiplome) {
        this.iddiplome = iddiplome;
    }

    public Integer getIddiplome() {
        return iddiplome;
    }

    public void setIddiplome(Integer iddiplome) {
        this.iddiplome = iddiplome;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public Date getDateobtention() {
        return dateobtention;
    }

    public void setDateobtention(Date dateobtention) {
        this.dateobtention = dateobtention;
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
        hash += (iddiplome != null ? iddiplome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diplomes)) {
            return false;
        }
        Diplomes other = (Diplomes) object;
        if ((this.iddiplome == null && other.iddiplome != null) || (this.iddiplome != null && !this.iddiplome.equals(other.iddiplome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Diplomes[ iddiplome=" + iddiplome + " ]";
    }

}
