/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.controlers;

import com.agiitech.ecole.entities.Classe;
import com.agiitech.ecole.entities.Niveaux;
import com.agiitech.ecole.models.ClasseFacade;
import com.agiitech.ecole.models.NiveauxFacade;
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
@Named(value = "classeBean")
@SessionScoped
public class ClasseBean extends AbstractBean implements Serializable {

    /**
     * Creates a new instance of NiveauxBean
     */
    private Niveaux niveau = new Niveaux();
    //private Classe classe=new Classe();
    private Classe classe = new Classe();
    // private Classe selectedClasse;
    private Classe selectedClasse=new Classe();
    @Inject
    private NiveauxFacade niveauxFacade;
    @Inject
    private ClasseFacade facade;
    //private List<Classe> liste=null;
    private List<Classe> liste = null;
    private Boolean modifier = false;

    public ClasseBean() {
    }

    @PostConstruct
    public void init() {
        liste = facade.findAll();
    }

    public void create() throws Throwable {
        try {
            classe.setIdniveaux(niveau);
            facade.create(classe);
            displayInfoMessage("classe " + classe.getDescriptionclasse() + " insérée");

        } catch (Exception e) {
            displayErrorMessage("classe " + classe.getDescriptionclasse() + " insérée");
        } finally {
            classe = new Classe();
            init();
        }
    }

    public void delete() {
        try {
            facade.remove(selectedClasse);
            displayInfoMessage("classe " + selectedClasse.getDescriptionclasse() + " supprimée avec succès");
            init();
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression de la classe de " + selectedClasse.getDescriptionclasse());
        }
       // resetselectedClasse();
        init();
    }

//    public void resetselectedClasse() {
//        selectedClasse = new Classe();
//    }

    public void updateClasse() {
        try {
            selectedClasse.setIdniveaux(niveauxFacade.getByIdNiveaux(selectedClasse.getIdniveaux()));
            facade.edit(selectedClasse);
            displayInfoMessage("classe " + selectedClasse.getDescriptionclasse() + " éditée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur d'édition de la classe " + selectedClasse.getDescriptionclasse());
        }
       // resetselectedClasse();
        init();
    }
     public void update(RowEditEvent event) {
        try {
            facade.edit((Classe) event.getObject());
            displayInfoMessage("classe " + ((Classe) event.getObject()).getDescriptionclasse() + " éditée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur d'édition de la classe " + ((Classe) event.getObject()).getDescriptionclasse());
        }
       // resetselectedClasse();
      //  init();
    }
    
    public void setModifierToFalse(){
        modifier=false;
    }
     public void setModifierToTrue(){
        modifier=true;
    }

    public Boolean getModifier() {
        return modifier;
    }

    public void setModifier(Boolean modifier) {
        this.modifier = modifier;
    }


    public void cancelled() {
        displayInfoMessage("vous avez annulez la supression");
    }

    public Niveaux getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveaux niveau) {
        this.niveau = niveau;
    }

    public ClasseFacade getFacade() {
        return facade;
    }

    
    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public List<Classe> getListe() {
        return liste;
    }

    public void setListe(List<Classe> liste) {
        this.liste = liste;
    }

    public Classe getSelectedClasse() {
        return selectedClasse;
    }

    public void setSelectedClasse(Classe selectedClasse) {
        this.selectedClasse = selectedClasse;
    }

}
