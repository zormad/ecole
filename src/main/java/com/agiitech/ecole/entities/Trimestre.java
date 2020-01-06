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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP-FOLIO
 */
@Entity
@Table(name = "trimestre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trimestre.findAll", query = "SELECT t FROM Trimestre t"),
    @NamedQuery(name = "Trimestre.findByLibelle", query = "SELECT t FROM Trimestre t WHERE t.libelle = :libelle")})
public class Trimestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "libelle")
    private Integer libelle;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "libelle")
    private List<Note> noteList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "libelle")
    private List<Absence> absenceList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "libelle")
    private List<Controle> controleList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "libelle")
    private List<Examen> examenList;

    public Trimestre() {
    }

    public Trimestre(Integer libelle) {
        this.libelle = libelle;
    }

    public Integer getLibelle() {
        return libelle;
    }

    public void setLibelle(Integer libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
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

    @XmlTransient
    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (libelle != null ? libelle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trimestre)) {
            return false;
        }
        Trimestre other = (Trimestre) object;
        if ((this.libelle == null && other.libelle != null) || (this.libelle != null && !this.libelle.equals(other.libelle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Trimestre[ libelle=" + libelle + " ]";
    }
    
}
