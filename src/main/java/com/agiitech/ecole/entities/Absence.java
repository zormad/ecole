/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP-FOLIO
 */
@Entity
@Table(name = "absence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Absence.findAll", query = "SELECT a FROM Absence a"),
    @NamedQuery(name = "Absence.findByIdabsence", query = "SELECT a FROM Absence a WHERE a.idabsence = :idabsence"),
    @NamedQuery(name = "Absence.findByAbsence", query = "SELECT a FROM Absence a WHERE a.absence = :absence"),
    @NamedQuery(name = "Absence.findByRetard", query = "SELECT a FROM Absence a WHERE a.retard = :retard"),
    @NamedQuery(name = "Absence.findByDateabsence", query = "SELECT a FROM Absence a WHERE a.dateabsence = :dateabsence"),
    @NamedQuery(name = "Absence.findByHeuredebut", query = "SELECT a FROM Absence a WHERE a.heuredebut = :heuredebut"),
    @NamedQuery(name = "Absence.findByHeurefin", query = "SELECT a FROM Absence a WHERE a.heurefin = :heurefin"),
    @NamedQuery(name = "Absence.findByComentaire", query = "SELECT a FROM Absence a WHERE a.comentaire = :comentaire")})
public class Absence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idabsence")
    private Integer idabsence;
    @Column(name = "absence")
    private Boolean absence;
    @Column(name = "retard")
    private Boolean retard;
    @Column(name = "dateabsence")
    @Temporal(TemporalType.DATE)
    private Date dateabsence;
    @Size(max = 254)
    @Column(name = "heuredebut")
    private String heuredebut;
    @Size(max = 254)
    @Column(name = "heurefin")
    private String heurefin;
    @Size(max = 254)
    @Column(name = "comentaire")
    private String comentaire;
    @JoinColumn(name = "anneeacademique", referencedColumnName = "anneeacademique")
    @ManyToOne //(optional = false,cascade = CascadeType.MERGE)
    private Anneeacademique anneeacademique;
    @JoinColumn(name = "ideleve", referencedColumnName = "ideleve")
    @ManyToOne //(optional = true,cascade = CascadeType.MERGE)
    private Eleve eleve;
    @JoinColumn(name = "matriculeenseignant", referencedColumnName = "matriculeenseignant")
    @ManyToOne
    private Enseignant matriculeenseignant;
    @JoinColumn(name = "libellemotif", referencedColumnName = "libellemotif")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Motif libellemotif;
    @JoinColumn(name = "libelle", referencedColumnName = "libelle")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Trimestre libelle;

    public Absence() {
    }

    public Absence(Integer idabsence) {
        this.idabsence = idabsence;
    }

    public Integer getIdabsence() {
        return idabsence;
    }

    public void setIdabsence(Integer idabsence) {
        this.idabsence = idabsence;
    }

    public Boolean getAbsence() {
        return absence;
    }

    public void setAbsence(Boolean absence) {
        this.absence = absence;
    }

    public Boolean getRetard() {
        return retard;
    }

    public void setRetard(Boolean retard) {
        this.retard = retard;
    }

    public Date getDateabsence() {
        return dateabsence;
    }

    public void setDateabsence(Date dateabsence) {
        this.dateabsence = dateabsence;
    }

    public String getHeuredebut() {
        return heuredebut;
    }

    public void setHeuredebut(String heuredebut) {
        this.heuredebut = heuredebut;
    }

    public String getHeurefin() {
        return heurefin;
    }

    public void setHeurefin(String heurefin) {
        this.heurefin = heurefin;
    }

    public String getComentaire() {
        return comentaire;
    }

    public void setComentaire(String comentaire) {
        this.comentaire = comentaire;
    }

    public Anneeacademique getAnneeacademique() {
        return anneeacademique;
    }

    public void setAnneeacademique(Anneeacademique anneeacademique) {
        this.anneeacademique = anneeacademique;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Enseignant getMatriculeenseignant() {
        return matriculeenseignant;
    }

    public void setMatriculeenseignant(Enseignant matriculeenseignant) {
        this.matriculeenseignant = matriculeenseignant;
    }

    public Motif getLibellemotif() {
        return libellemotif;
    }

    public void setLibellemotif(Motif libellemotif) {
        this.libellemotif = libellemotif;
    }

    public Trimestre getLibelle() {
        return libelle;
    }

    public void setLibelle(Trimestre libelle) {
        this.libelle = libelle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idabsence != null ? idabsence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Absence)) {
            return false;
        }
        Absence other = (Absence) object;
        if ((this.idabsence == null && other.idabsence != null) || (this.idabsence != null && !this.idabsence.equals(other.idabsence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Absence[ idabsence=" + idabsence + " ]";
    }
    
}
