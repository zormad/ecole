/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.models;

import com.agiitech.ecole.entities.Ancienneecole;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP-FOLIO
 */
@Stateless
public class AncienneecoleFacade extends AbstractFacade<Ancienneecole> {

    @PersistenceContext(unitName = "Persistence_school")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AncienneecoleFacade() {
        super(Ancienneecole.class);
    }
    public Ancienneecole getByID(Ancienneecole ancienneecole){
        return (Ancienneecole) em.createNamedQuery("Ancienneecole.findByAbbbecole").setParameter("abbbecole", ancienneecole.getAbbbecole()).getSingleResult();
    }
    
}
