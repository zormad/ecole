/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.models;

import com.agiitech.ecole.entities.Situationfamilliale;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP-FOLIO
 */
@Stateless
public class SituationfamillialeFacade extends AbstractFacade<Situationfamilliale> {

    @PersistenceContext(unitName = "Persistence_school")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SituationfamillialeFacade() {
        super(Situationfamilliale.class);
    }
    
}
