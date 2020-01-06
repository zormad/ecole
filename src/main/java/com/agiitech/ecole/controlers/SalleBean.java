/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.controlers;

import com.agiitech.ecole.entities.Salle;
import com.agiitech.ecole.entities.Typesalle;
import com.agiitech.ecole.models.SalleFacade;
import com.agiitech.ecole.models.TypesalleFacade;
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
@Named(value = "salleBean")
@SessionScoped
public class SalleBean extends AbstractBean implements Serializable {

    /**
     * Creates a new instance of Salle
     */
    //proprietes
    private Salle salle = new Salle();
    private List<Salle> liste = null;
    private Salle selectedSalle = new Salle();
    @Inject
    private SalleFacade facade;

    private Typesalle typesalle = new Typesalle();
    private List<Typesalle> typesalles = null;
    @Inject
    private TypesalleFacade typefacade;

    private Boolean modifier = false;

    public SalleBean() {
    }

    @PostConstruct
    public void init() {
        liste = facade.findAll();
        typesalles = typefacade.findAll();
    }

    public void create() throws Throwable {
        try {
            salle.setIdtypesalle(typesalle);
            facade.create(salle);
            displayInfoMessage("salle " + salle.getLibellesalle() + " inséréee");

        } catch (Exception e) {
            displayErrorMessage("errreur!!!!!!!!!salle " + salle.getLibellesalle() + " non insérée");
        } finally {
            salle = new Salle();
            init();
        }
    }

    public void delete() {
        try {
            facade.remove(selectedSalle);
            displayInfoMessage("salle " + selectedSalle.getLibellesalle() + " supprimé avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression de la salle " + selectedSalle.getLibellesalle());
        }
        init();
    }

    public void update() {
        try {
            //typesalle = typefacade.getByIdType(typesalle);
            Typesalle typesalle1=typefacade.getByIdType(selectedSalle.getIdtypesalle());
            selectedSalle.setIdtypesalle(typesalle1);
            facade.edit(selectedSalle);
            displayInfoMessage("salle " + (selectedSalle.getLibellesalle() + " éditée avec succès"));
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression de la salle " + (selectedSalle.getLibellesalle()));
        }
        init();
    }

    public void createTypeSalle() throws Throwable {
        try {
            typefacade.create(typesalle);
            displayInfoMessage(" " + typesalle.getLibelletypesalle() + " insérée");

        } catch (Exception e) {
            displayErrorMessage("errreur!!!!!!!!!type de salle: " + typesalle.getLibelletypesalle() + " non inséré");
        } finally {
            typesalle = new Typesalle();
            init();
        }
    }

    public void deleteTypeSalle(Typesalle typesalle) {
        try {
            typefacade.remove(typesalle);
            displayInfoMessage("type de salle " + typesalle.getLibelletypesalle() + " supprimé avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du type de salle " + typesalle.getLibelletypesalle());
        }
        init();
    }

    public void updateTypeSalle(RowEditEvent event) {
        try {
            typefacade.edit((Typesalle) event.getObject());
            displayInfoMessage("type de salle " + (((Typesalle) event.getObject()).getLibelletypesalle() + " édité avec succès"));
        } catch (Exception e) {
            displayErrorMessage("erreur d'édition du type de salle " + (((Typesalle) event.getObject()).getLibelletypesalle()));
        }
        init();
    }

    /**
     * action de modification annuléé
     */
    public void cancelled() {
        displayInfoMessage("vous avez annulez la modification ");
    }
    //une methode permettant de consulter et d'editer sur la meme dialogue

    public void setModifierToFalse() {
        modifier = false;
    }

    public void setModifierToTrue() {
        modifier = true;
    }
    //getters and setters

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public List<Salle> getListe() {
        return liste;
    }

    public void setListe(List<Salle> liste) {
        this.liste = liste;
    }

    public Salle getSelectedSalle() {
        return selectedSalle;
    }

    public void setSelectedSalle(Salle selectedSalle) {
        this.selectedSalle = selectedSalle;
    }

    public Typesalle getTypesalle() {
        return typesalle;
    }

    public void setTypesalle(Typesalle typesalle) {
        this.typesalle = typesalle;
    }

    public List<Typesalle> getTypesalles() {
        return typesalles;
    }

    public void setTypesalles(List<Typesalle> typesalles) {
        this.typesalles = typesalles;
    }

    public Boolean getModifier() {
        return modifier;
    }

    public void setModifier(Boolean modifier) {
        this.modifier = modifier;
    }

}
