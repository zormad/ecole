/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.controlers;

import com.agiitech.ecole.entities.Ancienneecole;
import com.agiitech.ecole.entities.Eleve;
import com.agiitech.ecole.entities.Nationalite;
import com.agiitech.ecole.entities.Niveaux;
import com.agiitech.ecole.entities.Parent;
import com.agiitech.ecole.entities.Ville;
import com.agiitech.ecole.models.AncienneecoleFacade;
import com.agiitech.ecole.models.EleveFacade;
import com.agiitech.ecole.models.NationaliteFacade;
import com.agiitech.ecole.models.NiveauxFacade;
import com.agiitech.ecole.models.VilleFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author HP-FOLIO
 */
@Named(value = "eleveBean")
@SessionScoped
public class EleveBean extends AbstractBean implements Serializable {

    /**
     * Creates a new instance of EleveBean
     */
    //test
    @Inject
    VilleFacade villeFacade;
    @Inject
    private EleveFacade facade;
    private List<Eleve> liste = null;
    private Eleve eleve = new Eleve();
    private Eleve selectedEleve;
    private Niveaux niveau = new Niveaux();
    private Nationalite nationalite = new Nationalite();
    private Ancienneecole ancienneEcole = new Ancienneecole();
    private List<Ancienneecole> anciensEcoles = null;
    private List<Nationalite> nationalites = null;
    @Inject
    private NationaliteFacade nationaliteFacade;
    @Inject
    private AncienneecoleFacade ancienneecoleFacade;
    @Inject
    private ParentBean parentBean;
    private List<Parent> parentList = null;
    @Inject
    private NiveauxFacade niveauxFacade;

    //private List<
    //private Boolean modifier=false;
    public EleveBean() {
    }

    @PostConstruct
    public void init() {
        liste = facade.findAll();
        nationalites = nationaliteFacade.findAll();
        anciensEcoles = ancienneecoleFacade.findAll();
    }

    public void create() throws Throwable {
        try {
            eleve.setAncienecole(ancienneEcole);
            eleve.setNiveauAncienneEcole(niveau);
            eleve.setLibelle(nationalite);
            //parentList.add(parentBean.getParent());
            //eleve.setParentList(parentList);
            facade.create(eleve);
            displayInfoMessage("elève " + eleve.getMatricule() + " inséré");

        } catch (Exception e) {
            displayErrorMessage("errreur!!!!!!!!!1elève " + eleve.getMatricule() + " non inséré");
        } finally {
            eleve = new Eleve();
            init();
        }
    }

    public void createWizard() throws Throwable, Exception {
        try {
            eleve.setAncienecole(ancienneEcole);
            eleve.setNiveauAncienneEcole(niveau);
            eleve.setLibelle(nationalite);
            parentBean.createParentWizard();
            parentList.add(parentBean.getParent());
            System.out.println("parent!!!"+parentList.toString());
            eleve.setParentList(parentList);
           // facade.create(eleve);
            displayInfoMessage("elève " + eleve.getMatricule() + " inséré");

        } catch (Exception e) {
            displayErrorMessage("errreur!!!!!!!!!1elève " + eleve.getMatricule() + " non inséré");
            System.out.println("erreur!!!!!!!!!"+e.getMessage());
//             System.out.println("parent!!!!!!!!!"+eleve.getParentList().toString());
        } finally {
            eleve = new Eleve();
            init();
        }
    }

    public void delete() {
        try {
            facade.remove(selectedEleve);
            displayInfoMessage("elève " + selectedEleve.getMatricule() + " supprimé avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression de l'elève " + selectedEleve.getMatricule());
        }
        clearSelectedEleve();
        init();
    }

    public void update() {
        try {
            selectedEleve.setAncienecole(ancienneecoleFacade.getByID(selectedEleve.getAncienecole()));
            selectedEleve.setNiveauAncienneEcole(niveauxFacade.getByIdNiveaux(selectedEleve.getNiveauAncienneEcole()));
            selectedEleve.setLibelle(nationaliteFacade.getNationaliteById(selectedEleve.getLibelle()));
            facade.edit(selectedEleve);
            displayInfoMessage("elève " + (selectedEleve.getMatricule() + " édité avec succès"));
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression de l'elève " + (selectedEleve.getMatricule()));
        }
        init();
    }

    public void createAncienneEcole() throws Throwable {
        try {
            ancienneecoleFacade.create(ancienneEcole);
            displayInfoMessage("école " + ancienneEcole.getNomecole() + " insérée");

        } catch (Exception e) {
            displayInfoMessage("erreur!!!!!! école " + ancienneEcole.getNomecole() + " non insérée");
        } finally {
            ancienneEcole = new Ancienneecole();
            init();
        }
    }

    public void deleteAncienneEcole(Ancienneecole ancienneEcole) {
        try {
            ancienneecoleFacade.remove(ancienneEcole);
            displayInfoMessage("école " + ancienneEcole.getNomecole() + " supprimée avec succès");
            init();
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression de l'école " + ancienneEcole.getNomecole());
        }
        init();
    }

    public void updateAncienneEcole(RowEditEvent event) {
        try {
            ancienneecoleFacade.edit((Ancienneecole) event.getObject());
            displayInfoMessage("école " + ((Ancienneecole) event.getObject()).getNomecole() + " éditée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression de l'école " + ((Ancienneecole) event.getObject()).getNomecole());
        }
        //init();
    }

    public void createNationalite() throws Throwable {
        try {
            nationaliteFacade.create(nationalite);
            displayInfoMessage("nationalité " + nationalite.getLibelle() + " insérée");

        } catch (Exception e) {
            displayInfoMessage("erreur!!!!!! nationalité " + nationalite.getLibelle() + " non insérée");
        } finally {
            ancienneEcole = new Ancienneecole();
            init();
        }
    }

    public void deleteNationalite(Nationalite nationalite) {
        try {
            nationaliteFacade.remove(nationalite);
            displayInfoMessage("nationalité " + nationalite.getLibelle() + " supprimée avec succès");
            init();
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression de la nationalité " + nationalite.getLibelle());
        }
        init();
    }

    public void updateVille(RowEditEvent event) {

        try {

            villeFacade.edit((Ville) event.getObject());
            displayInfoMessage("ville " + ((Ville) event.getObject()).getIdville() + " éditée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du ville " + ((Ville) event.getObject()).getIdville());
        }
        // init();
    }

    public void updateNationalite(RowEditEvent event) {
        try {
            nationaliteFacade.edit((Nationalite) event.getObject());
            displayInfoMessage("nationalité " + ((Nationalite) event.getObject()).getLibelle() + " éditée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression de la nationalité " + ((Nationalite) event.getObject()).getLibelle());
        }
        // init();
    }

    public void cancelled() {
        displayInfoMessage("vous avez annulez la supression");
    }
//public void setModifierTrue(){
//    modifier=true;
//}
//public void setModifierFalse(){
//    modifier=false;
//}

    public EleveFacade getFacade() {
        return facade;
    }

    public List<Eleve> getListe() {
        return liste;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public Eleve getSelectedEleve() {
        return selectedEleve;
    }

    public void setListe(List<Eleve> liste) {
        this.liste = liste;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public void setSelectedEleve(Eleve selectedEleve) {
        this.selectedEleve = selectedEleve;
    }

    public Niveaux getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveaux niveau) {
        this.niveau = niveau;
    }

    public Nationalite getNationalite() {
        return nationalite;
    }

    public void setNationalite(Nationalite nationalite) {
        this.nationalite = nationalite;
    }

    public Ancienneecole getAncienneEcole() {
        return ancienneEcole;
    }

    public void setAncienneEcole(Ancienneecole ancienneEcole) {
        this.ancienneEcole = ancienneEcole;
    }

    public List<Ancienneecole> getAnciensEcoles() {
        return anciensEcoles;
    }

    public void setAnciensEcoles(List<Ancienneecole> anciensEcoles) {
        this.anciensEcoles = anciensEcoles;
    }

    public List<Nationalite> getNationalites() {
        return nationalites;
    }

    public void setNationalites(List<Nationalite> nationalites) {
        this.nationalites = nationalites;
    }
//renitialiser l'élève selectionné

    public void clearSelectedEleve() {
        selectedEleve = new Eleve();
    }

//
//    public Boolean getModifier() {
//        return modifier;
//    }
//
//    public void setModifier(Boolean modifier) {
//        this.modifier = modifier;
//    }
}
