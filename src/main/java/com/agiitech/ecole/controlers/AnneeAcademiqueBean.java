/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.controlers;

import com.agiitech.ecole.entities.Anneeacademique;
import com.agiitech.ecole.models.AnneeacademiqueFacade;
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
@Named(value = "anneeAcademiqueBean")
@SessionScoped
public class AnneeAcademiqueBean extends AbstractBean implements Serializable {

    /**
     * Creates a new instance of AnneeAcademiqueBean
     */
    private Anneeacademique anneeAcademique = new Anneeacademique();
    @Inject
    private AnneeacademiqueFacade facade;
    public static Anneeacademique anneeCourante = new Anneeacademique();
    private Anneeacademique selectedAnnee = new Anneeacademique();
    private List<Anneeacademique> liste = null;

    public AnneeAcademiqueBean() {
        anneeCourante.setAnneeacademique("2018-2019");
    }

    @PostConstruct
    public void init() {
        liste = facade.findAll();
    }

    public void create() throws Throwable {
        try {
            facade.create(anneeAcademique);
            displayInfoMessage("anneeAcademique " + anneeAcademique.getAnneeacademique() + " inséré");

        } catch (Exception e) {
            displayErrorMessage("anneeAcademique " + anneeAcademique.getAnneeacademique() + " inséré");
        } finally {
            anneeAcademique = new Anneeacademique();
            init();
        }
    }

    public void delete(Anneeacademique anneeAcademique) {
        try {
            facade.remove(anneeAcademique);
            displayInfoMessage("anneeAcademique " + anneeAcademique.getAnneeacademique() + " supprimé avec succès");
            // init();
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du anneeAcademique " + anneeAcademique.getAnneeacademique());
        }
        init();
    }

    public void update(RowEditEvent event) {
        try {
            facade.edit((Anneeacademique) event.getObject());
            displayInfoMessage("anneeAcademique " + ((Anneeacademique) event.getObject()).getAnneeacademique() + " édité avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur d'edition du anneeAcademique " + ((Anneeacademique) event.getObject()).getAnneeacademique());
        }
        //  init();
    }

    public void updateNiveau() {
        try {
            facade.edit(selectedAnnee);
            displayInfoMessage("anneeAcademique " + selectedAnnee.getAnneeacademique() + " édité avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de du anneeAcademique " + selectedAnnee.getAnneeacademique());
        }
        init();
    }

    public void cancelled() {
        displayInfoMessage("vous avez annulez la supression");
    }

    //getters and setters
    public Anneeacademique getAnneeAcademique() {
        return anneeAcademique;
    }

    public void setAnneeAcademique(Anneeacademique anneeAcademique) {
        this.anneeAcademique = anneeAcademique;
    }

    public Anneeacademique getAnneeCourante() {
        return anneeCourante;
    }

    public void setAnneeCourante(Anneeacademique anneeCourante) {
        this.anneeCourante = anneeCourante;
    }

    public Anneeacademique getSelectedAnnee() {
        return selectedAnnee;
    }

    public void setSelectedAnnee(Anneeacademique selectedAnnee) {
        this.selectedAnnee = selectedAnnee;
    }

    public List<Anneeacademique> getListe() {
        return liste;
    }

    public void setListe(List<Anneeacademique> liste) {
        this.liste = liste;
    }

}
