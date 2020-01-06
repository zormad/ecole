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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "frais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Frais.findAll", query = "SELECT f FROM Frais f"),
    @NamedQuery(name = "Frais.findByIdfrais", query = "SELECT f FROM Frais f WHERE f.idfrais = :idfrais"),
    @NamedQuery(name = "Frais.findByLibellefrais", query = "SELECT f FROM Frais f WHERE f.libellefrais = :libellefrais")})
public class Frais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfrais")
    private Integer idfrais;
    @Size(max = 254)
    @Column(name = "libellefrais")
    private String libellefrais;
    @OneToMany(mappedBy = "idfrais")
    private List<Paiement> paiementList;
    @JoinColumn(name = "anneeacademique", referencedColumnName = "anneeacademique")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Anneeacademique anneeacademique;
    @JoinColumn(name = "idniveaux", referencedColumnName = "idniveaux")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Niveaux idniveaux;

    public Frais() {
    }

    public Frais(Integer idfrais) {
        this.idfrais = idfrais;
    }

    public Integer getIdfrais() {
        return idfrais;
    }

    public void setIdfrais(Integer idfrais) {
        this.idfrais = idfrais;
    }

    public String getLibellefrais() {
        return libellefrais;
    }

    public void setLibellefrais(String libellefrais) {
        this.libellefrais = libellefrais;
    }

    @XmlTransient
    public List<Paiement> getPaiementList() {
        return paiementList;
    }

    public void setPaiementList(List<Paiement> paiementList) {
        this.paiementList = paiementList;
    }

    public Anneeacademique getAnneeacademique() {
        return anneeacademique;
    }

    public void setAnneeacademique(Anneeacademique anneeacademique) {
        this.anneeacademique = anneeacademique;
    }

    public Niveaux getIdniveaux() {
        return idniveaux;
    }

    public void setIdniveaux(Niveaux idniveaux) {
        this.idniveaux = idniveaux;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfrais != null ? idfrais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Frais)) {
            return false;
        }
        Frais other = (Frais) object;
        if ((this.idfrais == null && other.idfrais != null) || (this.idfrais != null && !this.idfrais.equals(other.idfrais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Frais[ idfrais=" + idfrais + " ]";
    }
    
}
