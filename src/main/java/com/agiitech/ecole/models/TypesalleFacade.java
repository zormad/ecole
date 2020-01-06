/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.models;

import com.agiitech.ecole.entities.Typesalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP-FOLIO
 */
@Stateless
public class TypesalleFacade extends AbstractFacade<Typesalle> {

    @PersistenceContext(unitName = "Persistence_school")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypesalleFacade() {
        super(Typesalle.class);
    }
    public Typesalle getByIdType(Typesalle typesalle){
        return (Typesalle) em.createNamedQuery("Typesalle.findByIdtypesalle").setParameter("idtypesalle", typesalle.getIdtypesalle()).getSingleResult();
    }
    
}
