/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.models;

import com.agiitech.ecole.entities.Niveaux;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP-FOLIO
 */
@Stateless
public class NiveauxFacade extends AbstractFacade<Niveaux> {

    @PersistenceContext(unitName = "Persistence_school")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NiveauxFacade() {
        super(Niveaux.class);
    }
    public Niveaux getByIdNiveaux(Niveaux niveaux){
        return (Niveaux) em.createNamedQuery("Niveaux.findByIdniveaux").setParameter("idniveaux",niveaux.getIdniveaux()).getSingleResult();
    }
}
