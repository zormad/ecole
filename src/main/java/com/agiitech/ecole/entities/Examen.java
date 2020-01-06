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
@Table(name = "examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e"),
    @NamedQuery(name = "Examen.findByIdexamen", query = "SELECT e FROM Examen e WHERE e.idexamen = :idexamen"),
    @NamedQuery(name = "Examen.findByDescription", query = "SELECT e FROM Examen e WHERE e.description = :description"),
    @NamedQuery(name = "Examen.findByDateexamen", query = "SELECT e FROM Examen e WHERE e.dateexamen = :dateexamen"),
    @NamedQuery(name = "Examen.findByHeuredebut", query = "SELECT e FROM Examen e WHERE e.heuredebut = :heuredebut"),
    @NamedQuery(name = "Examen.findByHeurefin", query = "SELECT e FROM Examen e WHERE e.heurefin = :heurefin")})
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idexamen")
    private Integer idexamen;
    @Size(max = 254)
    @Column(name = "description")
    private String description;
    @Column(name = "dateexamen")
    @Temporal(TemporalType.DATE)
    private Date dateexamen;
    @Size(max = 254)
    @Column(name = "heuredebut")
    private String heuredebut;
    @Size(max = 254)
    @Column(name = "heurefin")
    private String heurefin;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idexamen")
    private List<Note> noteList;
    @OneToMany(mappedBy = "idexamen")
    private List<Matiere> matiereList;
    @JoinColumn(name = "anneeacademique", referencedColumnName = "anneeacademique")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Anneeacademique anneeacademique;
    @JoinColumn(name = "libelle", referencedColumnName = "libelle")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Trimestre libelle;

    public Examen() {
    }

    public Examen(Integer idexamen) {
        this.idexamen = idexamen;
    }

    public Integer getIdexamen() {
        return idexamen;
    }

    public void setIdexamen(Integer idexamen) {
        this.idexamen = idexamen;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateexamen() {
        return dateexamen;
    }

    public void setDateexamen(Date dateexamen) {
        this.dateexamen = dateexamen;
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

    @XmlTransient
    public List<Matiere> getMatiereList() {
        return matiereList;
    }

    public void setMatiereList(List<Matiere> matiereList) {
        this.matiereList = matiereList;
    }

    public Anneeacademique getAnneeacademique() {
        return anneeacademique;
    }

    public void setAnneeacademique(Anneeacademique anneeacademique) {
        this.anneeacademique = anneeacademique;
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
        hash += (idexamen != null ? idexamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.idexamen == null && other.idexamen != null) || (this.idexamen != null && !this.idexamen.equals(other.idexamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Examen[ idexamen=" + idexamen + " ]";
    }
    
}
