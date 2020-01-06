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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP-FOLIO
 */
@Entity
@Table(name = "profession")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profession.findAll", query = "SELECT p FROM Profession p"),
    @NamedQuery(name = "Profession.findByIdprofession", query = "SELECT p FROM Profession p WHERE p.idprofession = :idprofession"),
    @NamedQuery(name = "Profession.findByLibelleprofession", query = "SELECT p FROM Profession p WHERE p.libelleprofession = :libelleprofession")})
public class Profession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprofession")
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profession_seq")
    @SequenceGenerator(
            name = "profession_seq",
            sequenceName = "prof_idprof_seq",
            allocationSize = 1
    )
    private Integer idprofession;
    @Column(name = "libelleprofession")
    private String libelleprofession;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "idprofession")
    private List<Parent> parentList;

    public Profession() {
    }

    public Profession(Integer idprofession) {
        this.idprofession = idprofession;
    }

    public Integer getIdprofession() {
        return idprofession;
    }

    public void setIdprofession(Integer idprofession) {
        this.idprofession = idprofession;
    }

    public String getLibelleprofession() {
        return libelleprofession;
    }

    public void setLibelleprofession(String libelleprofession) {
        this.libelleprofession = libelleprofession;
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
        hash += (idprofession != null ? idprofession.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profession)) {
            return false;
        }
        Profession other = (Profession) object;
        if ((this.idprofession == null && other.idprofession != null) || (this.idprofession != null && !this.idprofession.equals(other.idprofession))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Profession[ idprofession=" + idprofession + " ]";
    }
    
}
