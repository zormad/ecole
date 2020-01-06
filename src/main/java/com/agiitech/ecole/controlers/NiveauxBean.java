/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.controlers;

import com.agiitech.ecole.entities.Niveaux;
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
@Named(value = "niveauxBean")
@SessionScoped
public class NiveauxBean extends AbstractBean implements Serializable {

    /**
     * Creates a new instance of NiveauxBean
     */
    private Niveaux niveau=new Niveaux();
    private Niveaux selectedNiveau;
    @Inject
    private NiveauxFacade facade;
    private List<Niveaux> liste=null;
    private Boolean modifier=true;
    
    public NiveauxBean() {
    }
 @PostConstruct
 public void init(){
     liste=facade.findAll();
 }
 //retourner un niveaux grace a son id
 public Niveaux getNiveauxByID(Niveaux niveauxId){
     return facade.getByIdNiveaux(niveauxId);
 }
  public void create() throws Throwable {
        try {
            facade.create(niveau);
            displayInfoMessage("niveau "+niveau.getLibelleniveaux() + " inséré");

        } catch (Exception e) {
            displayErrorMessage("niveau "+niveau.getLibelleniveaux()+ " inséré");
        } finally {
            niveau=new Niveaux();
            init();
        }
    }
  public void delete(Niveaux niveau) {
        try {
            facade.remove(niveau);
            displayInfoMessage("niveau "+niveau.getLibelleniveaux()+ " supprimé avec succès");
            init();
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du niveau "+niveau.getLibelleniveaux());
        }
        init();
    }

    public void update(RowEditEvent event) {
        try {
            facade.edit((Niveaux) event.getObject());
            displayInfoMessage("niveau " + ((Niveaux) event.getObject()).getLibelleniveaux()+" édité avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du niveau " + ((Niveaux) event.getObject()).getLibelleniveaux());
        }
      //  init();
    }
     public void updateNiveau() {
        try {
            facade.edit(selectedNiveau);
            displayInfoMessage("niveau " + selectedNiveau.getLibelleniveaux()+" édité avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du niveau " + selectedNiveau.getLibelleniveaux());
        }
        init();
    }

    public void cancelled() {
        displayInfoMessage("vous avez annulez la supression");
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
     
    public Niveaux getNiveau() {
        return niveau;
    }

    public Niveaux getSelectedNiveau() {
        return selectedNiveau;
    }

    public NiveauxFacade getFacade() {
        return facade;
    }

    public List<Niveaux> getListe() {
        return liste;
    }

    public void setListe(List<Niveaux> liste) {
        this.liste = liste;
    }
    

    public void setNiveau(Niveaux niveau) {
        this.niveau = niveau;
    }

    public void setSelectedNiveau(Niveaux selectedNiveau) {
        this.selectedNiveau = selectedNiveau;
    }
    
}
