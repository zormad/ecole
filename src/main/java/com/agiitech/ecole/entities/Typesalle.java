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
@Table(name = "typesalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typesalle.findAll", query = "SELECT t FROM Typesalle t"),
    @NamedQuery(name = "Typesalle.findByIdtypesalle", query = "SELECT t FROM Typesalle t WHERE t.idtypesalle = :idtypesalle"),
    @NamedQuery(name = "Typesalle.findByLibelletypesalle", query = "SELECT t FROM Typesalle t WHERE t.libelletypesalle = :libelletypesalle")})
public class Typesalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtypesalle")
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typeSalle_seq")
    @SequenceGenerator(
            name = "typeSalle_seq",
            sequenceName = "typeSalle_seq",
            allocationSize = 1
    )
    private Integer idtypesalle;
    @Size(max = 254)
    @Column(name = "libelletypesalle")
    private String libelletypesalle;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idtypesalle")
    private List<Salle> salleList;

    public Typesalle() {
    }

    public Typesalle(Integer idtypesalle) {
        this.idtypesalle = idtypesalle;
    }

    public Integer getIdtypesalle() {
        return idtypesalle;
    }

    public void setIdtypesalle(Integer idtypesalle) {
        this.idtypesalle = idtypesalle;
    }

    public String getLibelletypesalle() {
        return libelletypesalle;
    }

    public void setLibelletypesalle(String libelletypesalle) {
        this.libelletypesalle = libelletypesalle;
    }

    @XmlTransient
    public List<Salle> getSalleList() {
        return salleList;
    }

    public void setSalleList(List<Salle> salleList) {
        this.salleList = salleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypesalle != null ? idtypesalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typesalle)) {
            return false;
        }
        Typesalle other = (Typesalle) object;
        if ((this.idtypesalle == null && other.idtypesalle != null) || (this.idtypesalle != null && !this.idtypesalle.equals(other.idtypesalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Typesalle[ idtypesalle=" + idtypesalle + " ]";
    }
    
}
