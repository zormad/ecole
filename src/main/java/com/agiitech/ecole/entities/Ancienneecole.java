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
@Table(name = "ancienneecole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ancienneecole.findAll", query = "SELECT a FROM Ancienneecole a"),
    @NamedQuery(name = "Ancienneecole.findByAbbbecole", query = "SELECT a FROM Ancienneecole a WHERE a.abbbecole = :abbbecole"),
    @NamedQuery(name = "Ancienneecole.findByNomecole", query = "SELECT a FROM Ancienneecole a WHERE a.nomecole = :nomecole")})
public class Ancienneecole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "abbbecole")
    private String abbbecole;
    @Size(max = 254)
    @Column(name = "nomecole")
    private String nomecole;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "ancienecole")
    private List<Eleve> eleveList;

    public Ancienneecole() {
    }

    public Ancienneecole(String abbbecole) {
        this.abbbecole = abbbecole;
    }

    public String getAbbbecole() {
        return abbbecole;
    }

    public void setAbbbecole(String abbbecole) {
        this.abbbecole = abbbecole;
    }

    public String getNomecole() {
        return nomecole;
    }

    public void setNomecole(String nomecole) {
        this.nomecole = nomecole;
    }

    @XmlTransient
    public List<Eleve> getEleveList() {
        return eleveList;
    }

    public void setEleveList(List<Eleve> eleveList) {
        this.eleveList = eleveList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (abbbecole != null ? abbbecole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ancienneecole)) {
            return false;
        }
        Ancienneecole other = (Ancienneecole) object;
        if ((this.abbbecole == null && other.abbbecole != null) || (this.abbbecole != null && !this.abbbecole.equals(other.abbbecole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Ancienneecole[ abbbecole=" + abbbecole + " ]";
    }
    
}
