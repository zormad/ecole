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
@Table(name = "salle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salle.findAll", query = "SELECT s FROM Salle s")
    ,
    @NamedQuery(name = "Salle.findByIdsalle", query = "SELECT s FROM Salle s WHERE s.idsalle = :idsalle")
    ,
    @NamedQuery(name = "Salle.findByLibellesalle", query = "SELECT s FROM Salle s WHERE s.libellesalle = :libellesalle")
    ,
    @NamedQuery(name = "Salle.findByCapacite", query = "SELECT s FROM Salle s WHERE s.capacite = :capacite")})
public class Salle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsalle")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salle_seq")
    @SequenceGenerator(
            name = "salle_seq",
            sequenceName = "salle_idsalle_seq",
            allocationSize = 1
    )
    private Integer idsalle;
    @Size(max = 254)
    @Column(name = "libellesalle")
    private String libellesalle;
    @Column(name = "capacite")
    private Integer capacite;
    @JoinColumn(name = "idtypesalle", referencedColumnName = "idtypesalle")
    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    private Typesalle idtypesalle;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idsalle")
    private List<Cours> coursList;

    public Salle() {
    }

    public Salle(Integer idsalle) {
        this.idsalle = idsalle;
    }

    public Integer getIdsalle() {
        return idsalle;
    }

    public void setIdsalle(Integer idsalle) {
        this.idsalle = idsalle;
    }

    public String getLibellesalle() {
        return libellesalle;
    }

    public void setLibellesalle(String libellesalle) {
        this.libellesalle = libellesalle;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public Typesalle getIdtypesalle() {
        return idtypesalle;
    }

    public void setIdtypesalle(Typesalle idtypesalle) {
        this.idtypesalle = idtypesalle;
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
        hash += (idsalle != null ? idsalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salle)) {
            return false;
        }
        Salle other = (Salle) object;
        if ((this.idsalle == null && other.idsalle != null) || (this.idsalle != null && !this.idsalle.equals(other.idsalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Salle[ idsalle=" + idsalle + " ]";
    }

}
