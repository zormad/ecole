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
import javax.persistence.OneToMany;
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
@Table(name = "matiere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matiere.findAll", query = "SELECT m FROM Matiere m"),
    @NamedQuery(name = "Matiere.findByIdmatiere", query = "SELECT m FROM Matiere m WHERE m.idmatiere = :idmatiere"),
    @NamedQuery(name = "Matiere.findByNommatiere", query = "SELECT m FROM Matiere m WHERE m.nommatiere = :nommatiere"),
    @NamedQuery(name = "Matiere.findByCoefficient", query = "SELECT m FROM Matiere m WHERE m.coefficient = :coefficient")})
public class Matiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmatiere")
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matiere_seq")
    @SequenceGenerator(
            name = "matiere_seq",
            sequenceName = "matiere_idmat_seq",
            allocationSize = 1
    )
    private Integer idmatiere;
    @Size(max = 254)
    @Column(name = "nommatiere")
    private String nommatiere;
    @Column(name = "coefficient")
    private Integer coefficient;
    @ManyToMany(mappedBy = "matiereList")
    private List<Anneeacademique> anneeacademiqueList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idmatiere")
    private List<Note> noteList;
    @JoinColumn(name = "idexamen", referencedColumnName = "idexamen")
    @ManyToOne
    private Examen idexamen;
    @JoinColumn(name = "idniveaux", referencedColumnName = "idniveaux")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Niveaux idniveaux;
    @JoinColumn(name = "idtype", referencedColumnName = "idtype")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Typematiere idtype;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idmatiere")
    private List<Controle> controleList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idmatiere")
    private List<Cours> coursList;

    public Matiere() {
    }

    public Matiere(Integer idmatiere) {
        this.idmatiere = idmatiere;
    }

    public Integer getIdmatiere() {
        return idmatiere;
    }

    public void setIdmatiere(Integer idmatiere) {
        this.idmatiere = idmatiere;
    }

    public String getNommatiere() {
        return nommatiere;
    }

    public void setNommatiere(String nommatiere) {
        this.nommatiere = nommatiere;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    @XmlTransient
    public List<Anneeacademique> getAnneeacademiqueList() {
        return anneeacademiqueList;
    }

    public void setAnneeacademiqueList(List<Anneeacademique> anneeacademiqueList) {
        this.anneeacademiqueList = anneeacademiqueList;
    }

    @XmlTransient
    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    public Examen getIdexamen() {
        return idexamen;
    }

    public void setIdexamen(Examen idexamen) {
        this.idexamen = idexamen;
    }

    public Niveaux getIdniveaux() {
        return idniveaux;
    }

    public void setIdniveaux(Niveaux idniveaux) {
        this.idniveaux = idniveaux;
    }

    public Typematiere getIdtype() {
        return idtype;
    }

    public void setIdtype(Typematiere idtype) {
        this.idtype = idtype;
    }

    @XmlTransient
    public List<Controle> getControleList() {
        return controleList;
    }

    public void setControleList(List<Controle> controleList) {
        this.controleList = controleList;
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
        hash += (idmatiere != null ? idmatiere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matiere)) {
            return false;
        }
        Matiere other = (Matiere) object;
        if ((this.idmatiere == null && other.idmatiere != null) || (this.idmatiere != null && !this.idmatiere.equals(other.idmatiere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Matiere[ idmatiere=" + idmatiere + " ]";
    }
    
}
