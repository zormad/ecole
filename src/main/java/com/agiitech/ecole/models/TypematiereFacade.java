/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.models;

import com.agiitech.ecole.entities.Typematiere;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP-FOLIO
 */
@Stateless
public class TypematiereFacade extends AbstractFacade<Typematiere> {

    @PersistenceContext(unitName = "Persistence_school")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypematiereFacade() {
        super(Typematiere.class);
    }
    public Typematiere getTypeMatiereById(Typematiere typematiere){
        return (Typematiere) em.createNamedQuery("Typematiere.findByIdtype").setParameter("idtype", typematiere.getIdtype()).getSingleResult();
    }
    
}
