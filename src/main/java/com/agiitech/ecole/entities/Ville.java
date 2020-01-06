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
@Table(name = "ville")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ville.findAll", query = "SELECT v FROM Ville v"),
    @NamedQuery(name = "Ville.findByIdville", query = "SELECT v FROM Ville v WHERE v.idville = :idville"),
    @NamedQuery(name = "Ville.findByLibelleville", query = "SELECT v FROM Ville v WHERE v.libelleville = :libelleville")})
public class Ville implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idville")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ville_seq")
    @SequenceGenerator(
            name = "ville_seq",
            sequenceName = "ville_idville_seq",
            allocationSize = 1
    )
    private Integer idville;
    @Size(max = 254)
    @Column(name = "libelleville")
    private String libelleville;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idville")
    private List<Parent> parentList;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idville")
    private List<Enseignant> enseignantList;

    public Ville() {
    }

    public Ville(Integer idville) {
        this.idville = idville;
    }

    public Integer getIdville() {
        return idville;
    }

    public void setIdville(Integer idville) {
        this.idville = idville;
    }

    public String getLibelleville() {
        return libelleville;
    }

    public void setLibelleville(String libelleville) {
        this.libelleville = libelleville;
    }

    @XmlTransient
    public List<Parent> getParentList() {
        return parentList;
    }

    public void setParentList(List<Parent> parentList) {
        this.parentList = parentList;
    }

    @XmlTransient
    public List<Enseignant> getEnseignantList() {
        return enseignantList;
    }

    public void setEnseignantList(List<Enseignant> enseignantList) {
        this.enseignantList = enseignantList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idville != null ? idville.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ville)) {
            return false;
        }
        Ville other = (Ville) object;
        if ((this.idville == null && other.idville != null) || (this.idville != null && !this.idville.equals(other.idville))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Ville[ idville=" + idville + " ]";
    }

}
