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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "eleve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eleve.findAll", query = "SELECT e FROM Eleve e"),
    @NamedQuery(name = "Eleve.findByMatricule", query = "SELECT e FROM Eleve e WHERE e.matricule = :matricule"),
    @NamedQuery(name = "Eleve.findByIdElve", query = "SELECT e FROM Eleve e WHERE e.ideleve = :ideleve"),
    @NamedQuery(name = "Eleve.findByNom", query = "SELECT e FROM Eleve e WHERE e.nom = :nom"),
    @NamedQuery(name = "Eleve.findByPrenom", query = "SELECT e FROM Eleve e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Eleve.findByDatenaissance", query = "SELECT e FROM Eleve e WHERE e.datenaissance = :datenaissance"),
    @NamedQuery(name = "Eleve.findByLieunaissance", query = "SELECT e FROM Eleve e WHERE e.lieunaissance = :lieunaissance"),
    @NamedQuery(name = "Eleve.findBySexe", query = "SELECT e FROM Eleve e WHERE e.sexe = :sexe"),
    @NamedQuery(name = "Eleve.findByEmail", query = "SELECT e FROM Eleve e WHERE e.email = :email"),
    @NamedQuery(name = "Eleve.findByTelephone", query = "SELECT e FROM Eleve e WHERE e.telephone = :telephone"),
    @NamedQuery(name = "Eleve.findByAdresse", query = "SELECT e FROM Eleve e WHERE e.adresse = :adresse")})
public class Eleve implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ideleve")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eleve_seq")
    @SequenceGenerator(
            name = "eleve_seq",
            sequenceName = "eleve_ideleve_seq",
            allocationSize = 1
    )
    private Integer ideleve;
    @Size(min = 1, max = 254)
    @Column(name = "matricule")
    private String matricule;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "datenaissance")
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    @Size(max = 254)
    @Column(name = "lieunaissance")
    private String lieunaissance;
    @Column(name = "sexe")
    private String sexe;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private Integer telephone;
    @Size(max = 254)
    @Column(name = "adresse")
    private String adresse;
    @JoinTable(name = "eleveparent", joinColumns = {
        @JoinColumn(name = "ideleve", referencedColumnName = "ideleve")}, inverseJoinColumns = {
        @JoinColumn(name = "idparent", referencedColumnName = "idparent")})
    @ManyToMany
    private List<Parent> parentList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "eleve")
    private List<Note> noteList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "eleve")
    private List<Paiement> paiementList;
    @OneToMany(mappedBy = "eleve")
    private List<Absence> absenceList;
    @JoinColumn(name = "abbbecole", referencedColumnName = "abbbecole")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Ancienneecole ancienecole;
    @JoinColumn(name = "libelle", referencedColumnName = "libelle")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Nationalite libelle;
    @JoinColumn(name = "niveaux", referencedColumnName = "idniveaux")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Niveaux niveauAncienneEcole;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "eleve")
    private List<Inscription> inscriptionList;

    public Eleve() {
    }

    public Eleve(String matricule) {
        this.matricule = matricule;
    }

    public Integer getIdeleve() {
        return ideleve;
    }

    public void setIdeleve(Integer ideleve) {
        this.ideleve = ideleve;
    }


    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getLieunaissance() {
        return lieunaissance;
    }

    public void setLieunaissance(String lieunaissance) {
        this.lieunaissance = lieunaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @XmlTransient
    public List<Parent> getParentList() {
        return parentList;
    }

    public void setParentList(List<Parent> parentList) {
        this.parentList = parentList;
    }

    @XmlTransient
    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    @XmlTransient
    public List<Paiement> getPaiementList() {
        return paiementList;
    }

    public void setPaiementList(List<Paiement> paiementList) {
        this.paiementList = paiementList;
    }

    @XmlTransient
    public List<Absence> getAbsenceList() {
        return absenceList;
    }

    public void setAbsenceList(List<Absence> absenceList) {
        this.absenceList = absenceList;
    }

    public Ancienneecole getAncienecole() {
        return ancienecole;
    }

    public void setAncienecole(Ancienneecole ancienecole) {
        this.ancienecole = ancienecole;
    }

    public Nationalite getLibelle() {
        return libelle;
    }

    public void setLibelle(Nationalite libelle) {
        this.libelle = libelle;
    }

    public Niveaux getNiveauAncienneEcole() {
        return niveauAncienneEcole;
    }

    public void setNiveauAncienneEcole(Niveaux niveauAncienneEcole) {
        this.niveauAncienneEcole = niveauAncienneEcole;
    }

   
    @XmlTransient
    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricule != null ? matricule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eleve)) {
            return false;
        }
        Eleve other = (Eleve) object;
        if ((this.matricule == null && other.matricule != null) || (this.matricule != null && !this.matricule.equals(other.matricule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Eleve[ matricule=" + matricule + " ]";
    }
    
}
