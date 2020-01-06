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
@Table(name = "paiement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paiement.findAll", query = "SELECT p FROM Paiement p"),
    @NamedQuery(name = "Paiement.findByIdpaiement", query = "SELECT p FROM Paiement p WHERE p.idpaiement = :idpaiement"),
    @NamedQuery(name = "Paiement.findByDatepaiement", query = "SELECT p FROM Paiement p WHERE p.datepaiement = :datepaiement"),
    @NamedQuery(name = "Paiement.findBySommeversee", query = "SELECT p FROM Paiement p WHERE p.sommeversee = :sommeversee"),
    @NamedQuery(name = "Paiement.findByCommentaire", query = "SELECT p FROM Paiement p WHERE p.commentaire = :commentaire"),
    @NamedQuery(name = "Paiement.findBySommepaye", query = "SELECT p FROM Paiement p WHERE p.sommepaye = :sommepaye")})
public class Paiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpaiement")
    private Integer idpaiement;
    @Column(name = "datepaiement")
    private Integer datepaiement;
    @Column(name = "sommeversee")
    private Integer sommeversee;
    @Size(max = 254)
    @Column(name = "commentaire")
    private String commentaire;
    @Column(name = "sommepaye")
    private Integer sommepaye;
    @JoinColumn(name = "ideleve", referencedColumnName = "ideleve")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Eleve eleve;
    @JoinColumn(name = "idfrais", referencedColumnName = "idfrais")
    @ManyToOne
    private Frais idfrais;
    @JoinColumn(name = "idmode", referencedColumnName = "idmode")
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Modepaiement idmode;
    @JoinColumn(name = "idtranche", referencedColumnName = "idtranche")
    @ManyToOne
    private Tranche idtranche;

    public Paiement() {
    }

    public Paiement(Integer idpaiement) {
        this.idpaiement = idpaiement;
    }

    public Integer getIdpaiement() {
        return idpaiement;
    }

    public void setIdpaiement(Integer idpaiement) {
        this.idpaiement = idpaiement;
    }

    public Integer getDatepaiement() {
        return datepaiement;
    }

    public void setDatepaiement(Integer datepaiement) {
        this.datepaiement = datepaiement;
    }

    public Integer getSommeversee() {
        return sommeversee;
    }

    public void setSommeversee(Integer sommeversee) {
        this.sommeversee = sommeversee;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Integer getSommepaye() {
        return sommepaye;
    }

    public void setSommepaye(Integer sommepaye) {
        this.sommepaye = sommepaye;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Frais getIdfrais() {
        return idfrais;
    }

    public void setIdfrais(Frais idfrais) {
        this.idfrais = idfrais;
    }

    public Modepaiement getIdmode() {
        return idmode;
    }

    public void setIdmode(Modepaiement idmode) {
        this.idmode = idmode;
    }

    public Tranche getIdtranche() {
        return idtranche;
    }

    public void setIdtranche(Tranche idtranche) {
        this.idtranche = idtranche;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaiement != null ? idpaiement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paiement)) {
            return false;
        }
        Paiement other = (Paiement) object;
        if ((this.idpaiement == null && other.idpaiement != null) || (this.idpaiement != null && !this.idpaiement.equals(other.idpaiement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agiitech.ecole.entities.Paiement[ idpaiement=" + idpaiement + " ]";
    }
    
}
