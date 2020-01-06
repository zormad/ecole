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
@Table(name = "controle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Controle.findAll", query = "SELECT c FROM Controle c"),
    @NamedQuery(name = "Controle.findByIdcontrole", query = "SELECT c FROM Controle c WHERE c.idcontrole = :idcontrole"),
    @NamedQuery(name = "Controle.findByDescription", query = "SELECT c FROM Controle c WHERE c.description = :description"),
    @NamedQuery(name = "Controle.findByDatecontrole", query = "SELECT c FROM Controle c WHERE c.datecontrole = :datecontrole"),
    @NamedQuery(name = "Controle.findByHeuredebut", query = "SELECT c FROM Controle c WHERE c.heuredebut = :heuredebut"),
    @NamedQuery(name = "Controle.findByHeurefin", query = "SELECT c FROM Controle c WHERE c.heurefin = :heurefin")})
public class Controle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcontrole")
    private Integer idcontrole;
    @Size(max = 254)
    @Column(name = "description")
    private String description;
    @Column(name = "datecontrole")
    @Temporal(TemporalType.DATE)
    private Date datecontrole;
    @Size(max = 254)
    @Column(name = "heuredebut")
    private String heuredebut;
    @Size(max = 254)
    @Column(name = "heurefin")
    private String heurefin;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idcontrole")
    private List<Note> noteList;
    @JoinColumn(name = "anneeacademique", referencedColumnName = "anneeacademique")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Anneeacademique anneeacademique;
    @JoinColumn(name = "matriculeenseignant", referencedColumnName = "matriculeenseignant")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Enseignant matriculeenseignant;
    @JoinColumn(name = "idmatiere", referencedColumnName = "idmatiere")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Matiere idmatiere;
    @JoinColumn(name = "libelle", referencedColumnName = "libelle")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Trimestre libelle;

    public Controle() {
    }

    public Controle(Integer idcontrole) {
        this.idcontrole = idcontrole;
    }

    public Integer getIdcontrole() {
        return idcontrole;
    }

    public void setIdcontrole(Integer idcontrole) {
        this.idcontrole = idcontrole;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatecontrole() {
        return datecontrole;
    }

    public void setDatecontrole(Date datecontrole) {
        this.datecontrole = datecontrole;
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

    @XmlTransient
    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    public Anneeacademique getAnneeacademique() {
        return anneeacademique;
    }

    public void setAnneeacademique(Anneeacademique anneeacademique) {
        this.anneeacademique = anneeacademique;
    }

    public Enseignant getMatriculeenseignant() {
        return matriculeenseignant;
    }

    public void setMatriculeenseignant(Enseignant matriculeenseignant) {
        this.matriculeenseignant = matriculeenseignant;
    }

    public Matiere getIdmatiere() {
        return idmatiere;
    }

    public void setIdmatiere(Matiere idmatiere) {
        this.idmatiere = idmatiere;
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
        hash += (idcontrole != null ? idcontrole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Controle)) {
            return false;
        }
        Controle other = (Controle) object;
        if ((this.idcontrole == null && other.idcontrole != null) || (this.idcontrole != null && !this.idcontrole.equals(other.idcontrole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Controle[ idcontrole=" + idcontrole + " ]";
    }
    
}
