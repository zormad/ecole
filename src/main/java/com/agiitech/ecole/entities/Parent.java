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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "parent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parent.findAll", query = "SELECT p FROM Parent p"),
    @NamedQuery(name = "Parent.findByIdparent", query = "SELECT p FROM Parent p WHERE p.idparent = :idparent"),
    @NamedQuery(name = "Parent.findByNom", query = "SELECT p FROM Parent p WHERE p.nom = :nom"),
    @NamedQuery(name = "Parent.findByPrenom", query = "SELECT p FROM Parent p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Parent.findByAdresse", query = "SELECT p FROM Parent p WHERE p.adresse = :adresse"),
    @NamedQuery(name = "Parent.findByTelephone", query = "SELECT p FROM Parent p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "Parent.findByTelephoneMobile", query = "SELECT p FROM Parent p WHERE p.telephoneMobile = :telephoneMobile"),
    @NamedQuery(name = "Parent.findByEmail", query = "SELECT p FROM Parent p WHERE p.email = :email")})
public class Parent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idparent")
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parent_seq")
    @SequenceGenerator(
            name = "parent_seq",
            sequenceName = "parent_idpar_seq",
            allocationSize = 1
    )
    private Integer idparent;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 254)
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "telephone")
    private Integer telephone;
    @Column(name = "telephone_mobile")
    private Integer telephoneMobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "email")
    private String email;
    @ManyToMany(mappedBy = "parentList")
    private List<Eleve> eleveList;
    @JoinColumn(name = "idlien", referencedColumnName = "idlien")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Lienfamillial idlien;
    @JoinColumn(name = "idprofession", referencedColumnName = "idprofession")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Profession idprofession;
    @JoinColumn(name = "idville", referencedColumnName = "idville")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Ville idville;

    public Parent() {
    }

    public Parent(Integer idparent) {
        this.idparent = idparent;
    }

    public Integer getIdparent() {
        return idparent;
    }

    public void setIdparent(Integer idparent) {
        this.idparent = idparent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Integer getTelephoneMobile() {
        return telephoneMobile;
    }

    public void setTelephoneMobile(Integer telephoneMobile) {
        this.telephoneMobile = telephoneMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Eleve> getEleveList() {
        return eleveList;
    }

    public void setEleveList(List<Eleve> eleveList) {
        this.eleveList = eleveList;
    }

    public Lienfamillial getIdlien() {
        return idlien;
    }

    public void setIdlien(Lienfamillial idlien) {
        this.idlien = idlien;
    }

    public Profession getIdprofession() {
        return idprofession;
    }

    public void setIdprofession(Profession idprofession) {
        this.idprofession = idprofession;
    }

    public Ville getIdville() {
        return idville;
    }

    public void setIdville(Ville idville) {
        this.idville = idville;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparent != null ? idparent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parent)) {
            return false;
        }
        Parent other = (Parent) object;
        if ((this.idparent == null && other.idparent != null) || (this.idparent != null && !this.idparent.equals(other.idparent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Parent[ idparent=" + idparent + " ]";
    }
    
}
