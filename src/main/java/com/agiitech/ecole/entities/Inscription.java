/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP-FOLIO
 */
@Entity
@Table(name = "inscription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscription.findAll", query = "SELECT i FROM Inscription i"),
    @NamedQuery(name = "Inscription.findByIdclasse", query = "SELECT i FROM Inscription i WHERE i.inscriptionPK.idclasse = :idclasse"),
    @NamedQuery(name = "Inscription.findByMatricule", query = "SELECT i FROM Inscription i WHERE i.inscriptionPK.matricule = :matricule"),
    @NamedQuery(name = "Inscription.findByIdinscription", query = "SELECT i FROM Inscription i WHERE i.inscriptionPK.idinscription = :idinscription"),
    @NamedQuery(name = "Inscription.findByDateinscription", query = "SELECT i FROM Inscription i WHERE i.dateinscription = :dateinscription")})
public class Inscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InscriptionPK inscriptionPK;
    @Column(name = "dateinscription")
    private Integer dateinscription;
    @JoinColumn(name = "anneeacademique", referencedColumnName = "anneeacademique")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Anneeacademique anneeacademique;
    @JoinColumn(name = "idclasse", referencedColumnName = "idclasse", insertable = false, updatable = false)
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Classe classe;
    @JoinColumn(name = "matricule", referencedColumnName = "matricule", insertable = false, updatable = false)
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Eleve eleve;

    public Inscription() {
    }

    public Inscription(InscriptionPK inscriptionPK) {
        this.inscriptionPK = inscriptionPK;
    }

    public Inscription(int idclasse, String matricule, int idinscription) {
        this.inscriptionPK = new InscriptionPK(idclasse, matricule, idinscription);
    }

    public InscriptionPK getInscriptionPK() {
        return inscriptionPK;
    }

    public void setInscriptionPK(InscriptionPK inscriptionPK) {
        this.inscriptionPK = inscriptionPK;
    }

    public Integer getDateinscription() {
        return dateinscription;
    }

    public void setDateinscription(Integer dateinscription) {
        this.dateinscription = dateinscription;
    }

    public Anneeacademique getAnneeacademique() {
        return anneeacademique;
    }

    public void setAnneeacademique(Anneeacademique anneeacademique) {
        this.anneeacademique = anneeacademique;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inscriptionPK != null ? inscriptionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscription)) {
            return false;
        }
        Inscription other = (Inscription) object;
        if ((this.inscriptionPK == null && other.inscriptionPK != null) || (this.inscriptionPK != null && !this.inscriptionPK.equals(other.inscriptionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Inscription[ inscriptionPK=" + inscriptionPK + " ]";
    }
    
}
