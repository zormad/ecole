/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.models;

import com.agiitech.ecole.entities.Lienfamillial;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP-FOLIO
 */
@Stateless
public class LienfamillialFacade extends AbstractFacade<Lienfamillial> {

    @PersistenceContext(unitName = "Persistence_school")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LienfamillialFacade() {
        super(Lienfamillial.class);
    }
    public Lienfamillial getbByID(Lienfamillial lienfamillial){
        return (Lienfamillial) em.createNamedQuery("Lienfamillial.findByIdlien").setParameter("idlien", lienfamillial.getIdlien()).getSingleResult();
    }
}
