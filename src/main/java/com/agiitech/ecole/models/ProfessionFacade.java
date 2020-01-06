/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.models;

import com.agiitech.ecole.entities.Profession;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP-FOLIO
 */
@Stateless
public class ProfessionFacade extends AbstractFacade<Profession> {

    @PersistenceContext(unitName = "Persistence_school")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfessionFacade() {
        super(Profession.class);
    }
    public Profession getByID(Profession profession){
        return (Profession) em.createNamedQuery("Profession.findByIdprofession").setParameter("idprofession", profession.getIdprofession()).getSingleResult();
    }
    
}
