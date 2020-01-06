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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "enseignant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enseignant.findAll", query = "SELECT e FROM Enseignant e"),
    @NamedQuery(name = "Enseignant.findByMatriculeenseignant", query = "SELECT e FROM Enseignant e WHERE e.matriculeenseignant = :matriculeenseignant"),
    @NamedQuery(name = "Enseignant.findByNom", query = "SELECT e FROM Enseignant e WHERE e.nom = :nom"),
    @NamedQuery(name = "Enseignant.findByPrenom", query = "SELECT e FROM Enseignant e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Enseignant.findByDatenaissance", query = "SELECT e FROM Enseignant e WHERE e.datenaissance = :datenaissance"),
    @NamedQuery(name = "Enseignant.findByLieunaissance", query = "SELECT e FROM Enseignant e WHERE e.lieunaissance = :lieunaissance"),
    @NamedQuery(name = "Enseignant.findBySexe", query = "SELECT e FROM Enseignant e WHERE e.sexe = :sexe"),
    @NamedQuery(name = "Enseignant.findByEmail", query = "SELECT e FROM Enseignant e WHERE e.email = :email"),
    @NamedQuery(name = "Enseignant.findByTelephone", query = "SELECT e FROM Enseignant e WHERE e.telephone = :telephone"),
    @NamedQuery(name = "Enseignant.findByAdresse", query = "SELECT e FROM Enseignant e WHERE e.adresse = :adresse"),
    @NamedQuery(name = "Enseignant.findByDaterecrutement", query = "SELECT e FROM Enseignant e WHERE e.daterecrutement = :daterecrutement"),
    @NamedQuery(name = "Enseignant.findByNbreexperience", query = "SELECT e FROM Enseignant e WHERE e.nbreexperience = :nbreexperience"),
    @NamedQuery(name = "Enseignant.findByTelephonefixe", query = "SELECT e FROM Enseignant e WHERE e.telephonefixe = :telephonefixe"),
    @NamedQuery(name = "Enseignant.findByCodepostal", query = "SELECT e FROM Enseignant e WHERE e.codepostal = :codepostal")})
public class Enseignant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "matriculeenseignant")
    private String matriculeenseignant;
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
    @Column(name = "daterecrutement")
    @Temporal(TemporalType.DATE)
    private Date daterecrutement;
    @Size(max = 254)
    @Column(name = "nbreexperience")
    private String nbreexperience;
    @Column(name = "telephonefixe")
    private Integer telephonefixe;
    @Size(max = 254)
    @Column(name = "codepostal")
    private String codepostal;
    @ManyToMany(mappedBy = "enseignantList")
    private List<Diplomes> diplomesList;
    @OneToMany(mappedBy = "matriculeenseignant")
    private List<Absence> absenceList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "matriculeenseignant")
    private List<Controle> controleList;
//    @OneToMany(mappedBy = "matriculeenseignant")
//    private List<Salaire> salaireList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "matriculeenseignant")
    private List<Cours> coursList;
    @JoinColumn(name = "libelle", referencedColumnName = "libelle")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Nationalite libelle;
    @JoinColumn(name = "idniveaux", referencedColumnName = "idniveaux")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Niveauxacademique idniveaux;
//    @JoinColumn(name = "idsalaire", referencedColumnName = "idsalaire")
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "enseignant")
    private List <Salaire> ListSalaires;
    @JoinColumn(name = "libellefamillial", referencedColumnName = "libellefamillial")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Situationfamilliale libellefamillial;
    @JoinColumn(name = "libellestatus", referencedColumnName = "libellestatus")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Status libellestatus;
    @JoinColumn(name = "idville", referencedColumnName = "idville")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Ville idville;

    public Enseignant() {
    }

    public Enseignant(String matriculeenseignant) {
        this.matriculeenseignant = matriculeenseignant;
    }

    public String getMatriculeenseignant() {
        return matriculeenseignant;
    }

    public void setMatriculeenseignant(String matriculeenseignant) {
        this.matriculeenseignant = matriculeenseignant;
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

    public Date getDaterecrutement() {
        return daterecrutement;
    }

    public void setDaterecrutement(Date daterecrutement) {
        this.daterecrutement = daterecrutement;
    }

    public String getNbreexperience() {
        return nbreexperience;
    }

    public void setNbreexperience(String nbreexperience) {
        this.nbreexperience = nbreexperience;
    }

    public Integer getTelephonefixe() {
        return telephonefixe;
    }

    public void setTelephonefixe(Integer telephonefixe) {
        this.telephonefixe = telephonefixe;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    @XmlTransient
    public List<Diplomes> getDiplomesList() {
        return diplomesList;
    }

    public void setDiplomesList(List<Diplomes> diplomesList) {
        this.diplomesList = diplomesList;
    }

    @XmlTransient
    public List<Absence> getAbsenceList() {
        return absenceList;
    }

    public void setAbsenceList(List<Absence> absenceList) {
        this.absenceList = absenceList;
    }

    @XmlTransient
    public List<Controle> getControleList() {
        return controleList;
    }

    public void setControleList(List<Controle> controleList) {
        this.controleList = controleList;
    }
//
//    @XmlTransient
//    public List<Salaire> getSalaireList() {
//        return salaireList;
//    }
//
//    public void setSalaireList(List<Salaire> salaireList) {
//        this.salaireList = salaireList;
//    }

    @XmlTransient
    public List<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }

    public Nationalite getLibelle() {
        return libelle;
    }

    public void setLibelle(Nationalite libelle) {
        this.libelle = libelle;
    }

    public Niveauxacademique getIdniveaux() {
        return idniveaux;
    }

    public void setIdniveaux(Niveauxacademique idniveaux) {
        this.idniveaux = idniveaux;
    }

    public List<Salaire> getListSalaires() {
        return ListSalaires;
    }

    public void setListSalaires(List<Salaire> ListSalaires) {
        this.ListSalaires = ListSalaires;
    }


    public Situationfamilliale getLibellefamillial() {
        return libellefamillial;
    }

    public void setLibellefamillial(Situationfamilliale libellefamillial) {
        this.libellefamillial = libellefamillial;
    }

    public Status getLibellestatus() {
        return libellestatus;
    }

    public void setLibellestatus(Status libellestatus) {
        this.libellestatus = libellestatus;
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
        hash += (matriculeenseignant != null ? matriculeenseignant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enseignant)) {
            return false;
        }
        Enseignant other = (Enseignant) object;
        if ((this.matriculeenseignant == null && other.matriculeenseignant != null) || (this.matriculeenseignant != null && !this.matriculeenseignant.equals(other.matriculeenseignant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Enseignant[ matriculeenseignant=" + matriculeenseignant + " ]";
    }
    
}
