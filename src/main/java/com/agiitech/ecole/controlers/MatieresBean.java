/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.controlers;

//import com.agiitech.ecole.entities.Matiere;
import com.agiitech.ecole.entities.*;
import com.agiitech.ecole.models.MatiereFacade;
import com.agiitech.ecole.models.NiveauxFacade;
import com.agiitech.ecole.models.TypematiereFacade;
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
@Named(value = "matieresBean")
@SessionScoped
public class MatieresBean extends AbstractBean implements Serializable {

    private Matiere matiere = new Matiere();
    private Anneeacademique anneeacademique = new Anneeacademique();
    @Inject
    private MatiereFacade matiereFacade;
    private Niveaux niveaux = new Niveaux();
    private Typematiere typematiere = new Typematiere();
    @Inject
    private TypematiereFacade typematiereFacade;
    @Inject
    private NiveauxFacade niveauxFacade;
    private Matiere selectedMatiere = new Matiere();
    private Typematiere selectedTypeMatiere = new Typematiere();
    private List<Anneeacademique> listeAnnees = null;
    private List<Matiere> liste = null;
    private List<Typematiere> typeMatieres = null;
    private Boolean modifier = false;

    public MatieresBean() {
    }

    @PostConstruct
    public void init() {
        liste = matiereFacade.findAll();
        typeMatieres = typematiereFacade.findAll();

    }

    public void create() throws Throwable {
        try {
//            listeAnnees.add(AnneeAcademiqueBean.anneeCourante);
//            matiere.setAnneeacademiqueList(listeAnnees);
            matiere.setIdtype(typematiere);
            matiere.setIdniveaux(niveaux);
            matiereFacade.create(matiere);
            displayInfoMessage("matiere " + matiere.getNommatiere() + " inséréee");

        } catch (Exception e) {
            displayErrorMessage("errreur!!!!!!!!!matiere " + matiere.getNommatiere() + " non insérée");
        } finally {
            matiere = new Matiere();
            init();
        }
    }

    public void delete() {
        try {
            matiereFacade.remove(selectedMatiere);
            displayInfoMessage("matière " + selectedMatiere.getNommatiere() + " supprimé avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression de la matière " + selectedMatiere.getNommatiere());
        }
        init();
    }

    public void update() {
        try {
           // niveaux=niveauxFacade.getByIdNiveaux(niveaux);
            selectedMatiere.setIdniveaux(niveauxFacade.getByIdNiveaux(selectedMatiere.getIdniveaux()));
            //typematiere=typematiereFacade.getTypeMatiereById(typematiere);
            selectedMatiere.setIdtype(typematiereFacade.getTypeMatiereById(selectedMatiere.getIdtype()));
            matiereFacade.edit(selectedMatiere);
            displayInfoMessage("matière " + (selectedMatiere.getNommatiere() + " éditée avec succès"));
        } catch (Exception e) {
            displayErrorMessage("erreur d'edition de la matière " + (selectedMatiere.getNommatiere()));
        }
        init();
    }

    public void createTypeMatiere() throws Throwable {
        try {
            typematiereFacade.create(typematiere);
            displayInfoMessage("type de matière " + typematiere.getLielletype() + " inséré");

        } catch (Exception e) {
            displayErrorMessage("errreur!!!!!!!!!type de matière " + typematiere.getLielletype() + " non inséré");
        } finally {
            typematiere = new Typematiere();
            init();
        }
    }

    public void deleteTypeMatiere(Typematiere typematiere) {
        try {
            typematiereFacade.remove(typematiere);
            displayInfoMessage("type de matière " + typematiere.getLielletype() + " supprimé avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du type de matière " + typematiere.getLielletype());
        }
        init();
    }

    public void updateTypeMatiere(RowEditEvent event) {
        try {
            typematiereFacade.edit((Typematiere) event.getObject());
            displayInfoMessage("type de matière " + (((Typematiere) event.getObject()).getLielletype() + " édité avec succès"));
        } catch (Exception e) {
            displayErrorMessage("erreur d'édition du type de matière " + (((Typematiere) event.getObject()).getLielletype()));
        }
        init();
    }

    /**
     * action de modification annuléé
     */
    public void cancelled() {
        displayInfoMessage("vous avez annulez la modification ");
    }

    //getters and setters
   

    public Anneeacademique getAnneeacademique() {
        return anneeacademique;
    }

    public void setAnneeacademique(Anneeacademique anneeacademique) {
        this.anneeacademique = anneeacademique;
    }

    public Niveaux getNiveaux() {
        return niveaux;
    }

    public void setNiveaux(Niveaux niveaux) {
        this.niveaux = niveaux;
    }

    public Typematiere getTypematiere() {
        return typematiere;
    }

    public void setTypematiere(Typematiere typematiere) {
        this.typematiere = typematiere;
    }

    public Matiere getSelectedMatiere() {
        return selectedMatiere;
    }

    public void setSelectedMatiere(Matiere selectedMatiere) {
        this.selectedMatiere = selectedMatiere;
    }

    public Typematiere getSelectedTypeMatiere() {
        return selectedTypeMatiere;
    }

    public void setSelectedTypeMatiere(Typematiere selectedTypeMatiere) {
        this.selectedTypeMatiere = selectedTypeMatiere;
    }

    public List<Anneeacademique> getListeAnnees() {
        return listeAnnees;
    }

    public void setListeAnnees(List<Anneeacademique> listeAnnees) {
        this.listeAnnees = listeAnnees;
    }

    public List<Matiere> getListe() {
        return liste;
    }

    public void setListe(List<Matiere> liste) {
        this.liste = liste;
    }

    public List<Typematiere> getTypeMatieres() {
        return typeMatieres;
    }

    public void setTypeMatieres(List<Typematiere> typeMatieres) {
        this.typeMatieres = typeMatieres;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
    
    //une methode permettant de consulter et d'editer sur la meme dialogue

    public void setModifierToFalse() {
        modifier = false;
    }

    public void setModifierToTrue() {
        modifier = true;
    }

    public Boolean getModifier() {
        return modifier;
    }

    public void setModifier(Boolean modifier) {
        this.modifier = modifier;
    }

}
