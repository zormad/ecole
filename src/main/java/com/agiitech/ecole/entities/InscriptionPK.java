/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author HP-FOLIO
 */
@Embeddable
public class InscriptionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idclasse")
    private int idclasse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "matricule")
    private String matricule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idinscription")
    private int idinscription;

    public InscriptionPK() {
    }

    public InscriptionPK(int idclasse, String matricule, int idinscription) {
        this.idclasse = idclasse;
        this.matricule = matricule;
        this.idinscription = idinscription;
    }

    public int getIdclasse() {
        return idclasse;
    }

    public void setIdclasse(int idclasse) {
        this.idclasse = idclasse;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getIdinscription() {
        return idinscription;
    }

    public void setIdinscription(int idinscription) {
        this.idinscription = idinscription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idclasse;
        hash += (matricule != null ? matricule.hashCode() : 0);
        hash += (int) idinscription;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscriptionPK)) {
            return false;
        }
        InscriptionPK other = (InscriptionPK) object;
        if (this.idclasse != other.idclasse) {
            return false;
        }
        if ((this.matricule == null && other.matricule != null) || (this.matricule != null && !this.matricule.equals(other.matricule))) {
            return false;
        }
        if (this.idinscription != other.idinscription) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.InscriptionPK[ idclasse=" + idclasse + ", matricule=" + matricule + ", idinscription=" + idinscription + " ]";
    }
    
}
