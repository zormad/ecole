/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP-FOLIO
 */
@Entity
@Table(name = "note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n"),
    @NamedQuery(name = "Note.findByIdnote", query = "SELECT n FROM Note n WHERE n.idnote = :idnote"),
    @NamedQuery(name = "Note.findByNote", query = "SELECT n FROM Note n WHERE n.note = :note")})
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idnote")
    private Integer idnote;
    @Column(name = "note")
    private Integer note;
    @JoinColumn(name = "idcontrole", referencedColumnName = "idcontrole")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Controle idcontrole;
    @JoinColumn(name = "ideleve", referencedColumnName = "ideleve")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Eleve eleve;
    @JoinColumn(name = "idexamen", referencedColumnName = "idexamen")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Examen idexamen;
    @JoinColumn(name = "idmatiere", referencedColumnName = "idmatiere")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Matiere idmatiere;
    @JoinColumn(name = "libelle", referencedColumnName = "libelle")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Trimestre libelle;

    public Note() {
    }

    public Note(Integer idnote) {
        this.idnote = idnote;
    }

    public Integer getIdnote() {
        return idnote;
    }

    public void setIdnote(Integer idnote) {
        this.idnote = idnote;
    }

    public Integer getNote() {
        return note;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Controle getIdcontrole() {
        return idcontrole;
    }

    public void setIdcontrole(Controle idcontrole) {
        this.idcontrole = idcontrole;
    }

    public Examen getIdexamen() {
        return idexamen;
    }

    public void setIdexamen(Examen idexamen) {
        this.idexamen = idexamen;
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
        hash += (idnote != null ? idnote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.idnote == null && other.idnote != null) || (this.idnote != null && !this.idnote.equals(other.idnote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Note[ idnote=" + idnote + " ]";
    }
    
}
