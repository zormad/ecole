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
@Table(name = "lienfamillial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lienfamillial.findAll", query = "SELECT l FROM Lienfamillial l"),
    @NamedQuery(name = "Lienfamillial.findByIdlien", query = "SELECT l FROM Lienfamillial l WHERE l.idlien = :idlien"),
    @NamedQuery(name = "Lienfamillial.findByLibelle", query = "SELECT l FROM Lienfamillial l WHERE l.libelle = :libelle")})
public class Lienfamillial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idlien")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lienFamillial_seq")
    @SequenceGenerator(
            name = "lienFamillial_seq",
            sequenceName = "lienFamillial_idlf_seq",
            allocationSize = 1
    )
    private Integer idlien;
    @Size(max = 254)
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idlien")
    private List<Parent> parentList;

    public Lienfamillial() {
    }

    public Lienfamillial(Integer idlien) {
        this.idlien = idlien;
    }

    public Integer getIdlien() {
        return idlien;
    }

    public void setIdlien(Integer idlien) {
        this.idlien = idlien;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public List<Parent> getParentList() {
        return parentList;
    }

    public void setParentList(List<Parent> parentList) {
        this.parentList = parentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlien != null ? idlien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lienfamillial)) {
            return false;
        }
        Lienfamillial other = (Lienfamillial) object;
        if ((this.idlien == null && other.idlien != null) || (this.idlien != null && !this.idlien.equals(other.idlien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Lienfamillial[ idlien=" + idlien + " ]";
    }
    
}
