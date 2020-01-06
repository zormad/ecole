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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP-FOLIO
 */
@Entity
@Table(name = "cours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cours.findAll", query = "SELECT c FROM Cours c"),
    @NamedQuery(name = "Cours.findByIdcours", query = "SELECT c FROM Cours c WHERE c.idcours = :idcours"),
    @NamedQuery(name = "Cours.findByDescriptionCours", query = "SELECT c FROM Cours c WHERE c.descriptionCours = :descriptionCours"),
    @NamedQuery(name = "Cours.findByJour", query = "SELECT c FROM Cours c WHERE c.jour = :jour"),
    @NamedQuery(name = "Cours.findByDebutcours", query = "SELECT c FROM Cours c WHERE c.debutcours = :debutcours"),
    @NamedQuery(name = "Cours.findByFincours", query = "SELECT c FROM Cours c WHERE c.fincours = :fincours"),
    @NamedQuery(name = "Cours.findByAnneeacademique", query = "SELECT c FROM Cours c WHERE c.anneeacademique = :anneeacademique")})
public class Cours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcours")
    private Integer idcours;
    @Size(max = 254)
    @Column(name = "description_cours")
    private String descriptionCours;
    @Size(max = 254)
    @Column(name = "jour")
    private String jour;
    @Size(max = 254)
    @Column(name = "debutcours")
    private String debutcours;
    @Size(max = 254)
    @Column(name = "fincours")
    private String fincours;
    @Size(max = 254)
    @Column(name = "anneeacademique")
    private String anneeacademique;
    @JoinColumn(name = "idclasse", referencedColumnName = "idclasse")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Classe idclasse;
    @JoinColumn(name = "matriculeenseignant", referencedColumnName = "matriculeenseignant")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Enseignant matriculeenseignant;
    @JoinColumn(name = "idmatiere", referencedColumnName = "idmatiere")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Matiere idmatiere;
    @JoinColumn(name = "idsalle", referencedColumnName = "idsalle")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Salle idsalle;

    public Cours() {
    }

    public Cours(Integer idcours) {
        this.idcours = idcours;
    }

    public Integer getIdcours() {
        return idcours;
    }

    public void setIdcours(Integer idcours) {
        this.idcours = idcours;
    }

    public String getDescriptionCours() {
        return descriptionCours;
    }

    public void setDescriptionCours(String descriptionCours) {
        this.descriptionCours = descriptionCours;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getDebutcours() {
        return debutcours;
    }

    public void setDebutcours(String debutcours) {
        this.debutcours = debutcours;
    }

    public String getFincours() {
        return fincours;
    }

    public void setFincours(String fincours) {
        this.fincours = fincours;
    }

    public String getAnneeacademique() {
        return anneeacademique;
    }

    public void setAnneeacademique(String anneeacademique) {
        this.anneeacademique = anneeacademique;
    }

    public Classe getIdclasse() {
        return idclasse;
    }

    public void setIdclasse(Classe idclasse) {
        this.idclasse = idclasse;
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

    public Salle getIdsalle() {
        return idsalle;
    }

    public void setIdsalle(Salle idsalle) {
        this.idsalle = idsalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcours != null ? idcours.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cours)) {
            return false;
        }
        Cours other = (Cours) object;
        if ((this.idcours == null && other.idcours != null) || (this.idcours != null && !this.idcours.equals(other.idcours))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Cours[ idcours=" + idcours + " ]";
    }
    
}
