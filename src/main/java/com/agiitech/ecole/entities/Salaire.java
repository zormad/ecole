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
@Table(name = "salaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salaire.findAll", query = "SELECT s FROM Salaire s"),
    @NamedQuery(name = "Salaire.findByIdsalaire", query = "SELECT s FROM Salaire s WHERE s.idsalaire = :idsalaire"),
    @NamedQuery(name = "Salaire.findBySalairebrut", query = "SELECT s FROM Salaire s WHERE s.salairebrut = :salairebrut"),
    @NamedQuery(name = "Salaire.findBySalairenet", query = "SELECT s FROM Salaire s WHERE s.salairenet = :salairenet"),
    @NamedQuery(name = "Salaire.findByNbreenfant", query = "SELECT s FROM Salaire s WHERE s.nbreenfant = :nbreenfant")})
public class Salaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsalaire")
    private Integer idsalaire;
    @Column(name = "salairebrut")
    private Integer salairebrut;
    @Column(name = "salairenet")
    private Integer salairenet;
    @Column(name = "nbreenfant")
    private Integer nbreenfant;
    @JoinColumn(name = "matriculeenseignant", referencedColumnName = "matriculeenseignant")
    @ManyToOne
    private Enseignant matriculeenseignant;
    @ManyToOne(optional = true,cascade = CascadeType.MERGE)
    private Enseignant enseignant;

    public Salaire() {
    }

    public Salaire(Integer idsalaire) {
        this.idsalaire = idsalaire;
    }

    public Integer getIdsalaire() {
        return idsalaire;
    }

    public void setIdsalaire(Integer idsalaire) {
        this.idsalaire = idsalaire;
    }

    public Integer getSalairebrut() {
        return salairebrut;
    }

    public void setSalairebrut(Integer salairebrut) {
        this.salairebrut = salairebrut;
    }

    public Integer getSalairenet() {
        return salairenet;
    }

    public void setSalairenet(Integer salairenet) {
        this.salairenet = salairenet;
    }

    public Integer getNbreenfant() {
        return nbreenfant;
    }

    public void setNbreenfant(Integer nbreenfant) {
        this.nbreenfant = nbreenfant;
    }

    public Enseignant getMatriculeenseignant() {
        return matriculeenseignant;
    }

    public void setMatriculeenseignant(Enseignant matriculeenseignant) {
        this.matriculeenseignant = matriculeenseignant;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsalaire != null ? idsalaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salaire)) {
            return false;
        }
        Salaire other = (Salaire) object;
        if ((this.idsalaire == null && other.idsalaire != null) || (this.idsalaire != null && !this.idsalaire.equals(other.idsalaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Salaire[ idsalaire=" + idsalaire + " ]";
    }
    
}
