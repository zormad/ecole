/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.controlers;

import com.agiitech.ecole.entities.Lienfamillial;
import com.agiitech.ecole.entities.Parent;
import com.agiitech.ecole.entities.Profession;
import com.agiitech.ecole.entities.Ville;
import com.agiitech.ecole.models.LienfamillialFacade;
import com.agiitech.ecole.models.ParentFacade;
import com.agiitech.ecole.models.ProfessionFacade;
import com.agiitech.ecole.models.VilleFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author HP-FOLIO
 */
@Named(value = "parentAccesBean")
@SessionScoped
public class ParentAccesBean extends AbstractBean implements Serializable {

    /**
     * liste des tableaux
     */
    private List<Parent> parents = null;
    private List<Ville> villes = null;
    private List<Lienfamillial> liens = null;
    private List<Profession> professions = null;
    /**
     * liste des facades
     */
    @Inject
    private VilleFacade villeFacade;
    @Inject
    private ParentFacade facade;
    @Inject
    private ProfessionFacade professionFacade;
    @Inject
    private LienfamillialFacade lienFamillialFacade;

    public ParentAccesBean() {
    }

    @PostConstruct
    public void init() {
        parents = facade.findAll();
        villes = villeFacade.findAll();
        professions = professionFacade.findAll();
        liens = lienFamillialFacade.findAll();

    }


    public void updateVilleRow(RowEditEvent event) {
        try {
            villeFacade.edit((Ville) event.getObject());
            displayInfoMessage("ville " + ((Ville) event.getObject()).getIdville()+ " éditée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du ville " + ((Ville) event.getObject()).getIdville());
        }
       // init();
    }


    public void updateProfessionRow(RowEditEvent event) {
        try {
            professionFacade.edit((Profession) event.getObject());
            displayInfoMessage("profession " + ((Profession) event.getObject()).getLibelleprofession() + " éditée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du profession " + ((Profession) event.getObject()).getLibelleprofession());
        }
        //  init();
    }

    public void updateParentRow(RowEditEvent event) {
        try {
            facade.edit((Parent) event.getObject());
            displayInfoMessage("parent " + ((Parent) event.getObject()).getNom() + " édité avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du parent " + ((Parent) event.getObject()).getNom());
        }
        //  init();
    }

    public void updateLienFamillialRow(RowEditEvent event) {
        try {
            lienFamillialFacade.edit((Lienfamillial) event.getObject());
            displayInfoMessage("lienFamillial " + ((Lienfamillial) event.getObject()).getLibelle() + " édité avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du lienFamillial " + ((Lienfamillial) event.getObject()).getLibelle());
        }
        //  init();
    }

}
