/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.controlers;

import com.agiitech.ecole.entities.Diplomes;
import com.agiitech.ecole.entities.Enseignant;
import com.agiitech.ecole.entities.Nationalite;
import com.agiitech.ecole.entities.Niveauxacademique;
import com.agiitech.ecole.entities.Salaire;
import com.agiitech.ecole.entities.Situationfamilliale;
import com.agiitech.ecole.entities.Status;
import com.agiitech.ecole.entities.Ville;
import com.agiitech.ecole.models.DiplomesFacade;
import com.agiitech.ecole.models.EnseignantFacade;
import com.agiitech.ecole.models.SalaireFacade;
import com.agiitech.ecole.models.SituationfamillialeFacade;
import com.agiitech.ecole.models.StatusFacade;
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
@Named(value = "enseignantBean")
@SessionScoped
public class EnseignantBean extends AbstractBean implements Serializable {

    /**
     * Creates a new instance of EnseignantBean
     */
    //Proprietes de l'enseignant
    private Enseignant enseignant=new Enseignant();
    private Enseignant selectedEnseignant=new Enseignant();
    @Inject
    private EnseignantFacade facade;
    private List<Enseignant> liste=null;
    
    //proprietes du diplomes
    private Diplomes diplome=new Diplomes();
    private Diplomes selectedDiplome=new Diplomes();
    @Inject
    private DiplomesFacade diplomesFacade;
    private List<Diplomes> listeDiplomes=null;
    
    //proprietes de salaire
    private Salaire salaire=new Salaire();
    private Salaire selectedSalaire =new Salaire();
    private List<Salaire> salaires;
    @Inject
    private SalaireFacade salaireFacade;
    
    //proprietes de la nationalite
    private Nationalite nationalite=new Nationalite();
    //proprietes de status
    private Status status=new Status();
    private Status selectedStatus =new Status();
    private List<Status> listeStatus=null;
    @Inject
    private StatusFacade statusFacade;
    
    //proprietes de situationFamillial
    private Situationfamilliale situationfamilliale=new Situationfamilliale();
    private Situationfamilliale selectedSituationfamilliale=new Situationfamilliale();
    private List<Situationfamilliale> situationfamilliales=null;
    @Inject
    private SituationfamillialeFacade situationfamillialeFacade;
    
    //proprietes de la ville
    private Ville ville=new Ville();
    
    private Niveauxacademique niveauxAcademique=new Niveauxacademique();
    
    //modifier
    private Boolean modifier = false;
    private Boolean modifierDiplome = false;
    private Boolean modifierStatus = false;
    private Boolean modifierSituationfamilliale = false;
    
    /**
     *
     */
    public EnseignantBean() {
    }

    /**
     *
     */
    @PostConstruct
    public void init(){
        listeStatus=statusFacade.findAll();
        listeDiplomes=diplomesFacade.findAll();
        situationfamilliales=situationfamillialeFacade.findAll();
        
    }
    
    /**
     *
     * @throws Throwable
     */
    public void create() throws Throwable {
        try {
            //enseignant.setIdtypeenseignant(typeenseignant);
            enseignant.setIdniveaux(niveauxAcademique);
            enseignant.setIdville(ville);
            enseignant.setLibelle(nationalite);
            enseignant.setLibellestatus(status);
            enseignant.setLibellefamillial(situationfamilliale);
            facade.create(enseignant);
            displayInfoMessage("enseignant " + enseignant.getMatriculeenseignant() + " inséréee");

        } catch (Exception e) {
            displayErrorMessage("errreur!!!!!!!!!enseignant " + enseignant.getMatriculeenseignant() + " non insérée");
        } finally {
            enseignant = new Enseignant();
            init();
        }
    }

    /**
     *
     */
    public void delete() {
        try {
            facade.remove(selectedEnseignant);
            displayInfoMessage("enseignant " + selectedEnseignant.getMatriculeenseignant() + " supprimé avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression de l'enseignant " + selectedEnseignant.getMatriculeenseignant());
        }
        init();
    }

    /**
     *
     */
    public void update() {
        try {
            //typeenseignant = typefacade.getByIdType(typeenseignant);
           // Typeenseignant typeenseignant1=typefacade.getByIdType(selectedEnseignant.getIdtypeenseignant());
           // selectedEnseignant.setIdtypeenseignant(typeenseignant1);
            facade.edit(selectedEnseignant);
            displayInfoMessage("enseignant " + (selectedEnseignant.getMatriculeenseignant()+ " éditée avec succès"));
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression de l'enseignant " + (selectedEnseignant.getMatriculeenseignant()));
        }
        init();
    }

    /**
     * Status
     * @throws Throwable 
     */
    public void createStatus() throws Throwable {
        try {
            statusFacade.create(status);
            displayInfoMessage(" " + status.getLibellestatus() + " inséré");

        } catch (Exception e) {
            displayErrorMessage("errreur!!!!!!!!! salle: " + status.getLibellestatus() + " non inséré");
        } finally {
            status = new Status();
            init();
        }
    }

    /**
     *
     * @param status
     */
    public void deleteStatus(Status status) {
        try {
            statusFacade.remove(status);
            displayInfoMessage("status " + status.getLibellestatus() + " supprimé avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du status " + status.getLibellestatus());
        }
        init();
    }

    /**
     *
     * @param event
     */
    public void updateStatus(RowEditEvent event) {
        try {
            statusFacade.edit((Status) event.getObject());
            displayInfoMessage("status: " + (((Status) event.getObject()).getLibellestatus() + " édité avec succès"));
        } catch (Exception e) {
            displayErrorMessage("erreur d'édition du status: " + (((Status) event.getObject()).getLibellestatus()));
        }
        init();
    }

    
    /**
     * Salaire
     * @throws Throwable 
     */
     public void createSalaire() throws Throwable {
        try {
            salaireFacade.create(salaire);
            displayInfoMessage(" salaire ID:" + salaire.getIdsalaire() + " inséré");

        } catch (Exception e) {
            displayErrorMessage("errreur!!!!!!!!! salaire ID: " + salaire.getIdsalaire() + " non inséré");
        } finally {
            salaire = new Salaire();
            init();
        } 
    }

    /**
     *
     * @param salaire
     */
    public void deleteSalaire(Salaire salaire) {
        try {
            salaireFacade.remove(salaire);
            displayInfoMessage("salaire ID: " + salaire.getIdsalaire()+ " supprimé avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du salaire " + salaire.getIdsalaire());
        }
        init();
    }

    /**
     *
     * @param event
     */
    public void updateSalaire(RowEditEvent event) {
        try {
            salaireFacade.edit((Salaire) event.getObject());
            displayInfoMessage("salaire ID: " + (((Salaire) event.getObject()).getIdsalaire() + " édité avec succès"));
        } catch (Exception e) {
            displayErrorMessage("erreur d'édition du salaire: " + (((Salaire) event.getObject()).getIdsalaire()));
        }
        init();
    }
    
    /**
     * Diplomes
     * @throws Throwable 
     */
    public void createDiplomes() throws Throwable {
        try {
            diplomesFacade.create(diplome);
            displayInfoMessage(" diplome ID: " + diplome.getIddiplome()+ " inséré");

        } catch (Exception e) {
            displayErrorMessage("errreur!!!!!!!!! diplome ID: " + diplome.getIddiplome() + " non inséré");
        } finally {
            diplome = new Diplomes();
            init();
        }
    }

    /**
     *
     * @param diplome
     */
    public void deleteDiplomes(Diplomes diplome) {
        try {
            diplomesFacade.remove(diplome);
            displayInfoMessage("diplome ID: " + diplome.getIddiplome()+ " supprimé avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du diplome ID:" + diplome.getIddiplome());
        }
        init();
    }

    /**
     *
     * @param event
     */
    public void updateDiplomes(RowEditEvent event) {
        try {
            diplomesFacade.edit((Diplomes) event.getObject());
            displayInfoMessage("diplome ID: " + (((Diplomes) event.getObject()).getIddiplome() + " édité avec succès"));
        } catch (Exception e) {
            displayErrorMessage("erreur d'édition du diplome ID: " + (((Diplomes) event.getObject()).getIddiplome()));
        }
        init();
    }
    
    /**
     * Situation Familliale
     * @throws java.lang.Throwable
     */
    
    public void createSituationfamilliale() throws Throwable {
        try {
            situationfamillialeFacade.create(situationfamilliale);
            displayInfoMessage(" " + situationfamilliale.getLibellefamillial() + " inséré");

        } catch (Exception e) {
            displayErrorMessage("errreur!!!!!!!!! " + situationfamilliale.getLibellefamillial()+ " non inséré");
        } finally {
            situationfamilliale = new Situationfamilliale();
            init();
        }
    }

    /**
     *
     * @param situationfamilliale
     */
    public void deleteSituationfamilliale(Situationfamilliale situationfamilliale) {
        try {
            situationfamillialeFacade.remove(situationfamilliale);
            displayInfoMessage(" " + situationfamilliale.getLibellefamillial() + " supprimé avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression de la situation familliale: " + situationfamilliale.getLibellefamillial());
        }
        init();
    }

    /**
     *
     * @param event
     */
    public void updateSituationfamilliale(RowEditEvent event) {
        try {
            situationfamillialeFacade.edit((Situationfamilliale) event.getObject());
            displayInfoMessage("situation familliale: " + (((Situationfamilliale) event.getObject()).getLibellefamillial() + " édité avec succès"));
        } catch (Exception e) {
            displayErrorMessage("erreur d'édition du situation familliale: " + (((Situationfamilliale) event.getObject()).getLibellefamillial()));
        }
        init();
    }

    //getters and setters

    /**
     *
     * @return
     */

    public Enseignant getEnseignant() {
        return enseignant;
    }

    /**
     *
     * @param enseignant
     */
    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    /**
     *
     * @return
     */
    public Enseignant getSelectedEnseignant() {
        return selectedEnseignant;
    }

    /**
     *
     * @param selectedEnseignant
     */
    public void setSelectedEnseignant(Enseignant selectedEnseignant) {
        this.selectedEnseignant = selectedEnseignant;
    }

    /**
     *
     * @return
     */
    public List<Enseignant> getListe() {
        return liste;
    }

    /**
     *
     * @param liste
     */
    public void setListe(List<Enseignant> liste) {
        this.liste = liste;
    }

    /**
     *
     * @return
     */
    public Diplomes getDiplome() {
        return diplome;
    }

    /**
     *
     * @param diplome
     */
    public void setDiplome(Diplomes diplome) {
        this.diplome = diplome;
    }

    /**
     *
     * @return
     */
    public Diplomes getSelectedDiplome() {
        return selectedDiplome;
    }

    /**
     *
     * @param selectedDiplome
     */
    public void setSelectedDiplome(Diplomes selectedDiplome) {
        this.selectedDiplome = selectedDiplome;
    }

    /**
     *
     * @return
     */
    public List<Diplomes> getListeDiplomes() {
        return listeDiplomes;
    }

    /**
     *
     * @param listeDiplomes
     */
    public void setListeDiplomes(List<Diplomes> listeDiplomes) {
        this.listeDiplomes = listeDiplomes;
    }

    /**
     *
     * @return
     */
    public Salaire getSalaire() {
        return salaire;
    }

    /**
     *
     * @param salaire
     */
    public void setSalaire(Salaire salaire) {
        this.salaire = salaire;
    }

    /**
     *
     * @return
     */
    public Salaire getSelectedSalaire() {
        return selectedSalaire;
    }

    /**
     *
     * @param selectedSalaire
     */
    public void setSelectedSalaire(Salaire selectedSalaire) {
        this.selectedSalaire = selectedSalaire;
    }

    /**
     *
     * @return
     */
    public List<Salaire> getSalaires() {
        return salaires;
    }

    /**
     *
     * @param salaires
     */
    public void setSalaires(List<Salaire> salaires) {
        this.salaires = salaires;
    }

    /**
     *
     * @return
     */
    public Status getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public Status getSelectedStatus() {
        return selectedStatus;
    }

    /**
     *
     * @param selectedStatus
     */
    public void setSelectedStatus(Status selectedStatus) {
        this.selectedStatus = selectedStatus;
    }

    /**
     *
     * @return
     */
    public List<Status> getListeStatus() {
        return listeStatus;
    }

    /**
     *
     * @param listeStatus
     */
    public void setListeStatus(List<Status> listeStatus) {
        this.listeStatus = listeStatus;
    }

    /**
     *
     * @return
     */
    public Situationfamilliale getSituationfamilliale() {
        return situationfamilliale;
    }

    /**
     *
     * @param situationfamilliale
     */
    public void setSituationfamilliale(Situationfamilliale situationfamilliale) {
        this.situationfamilliale = situationfamilliale;
    }

    /**
     *
     * @return
     */
    public Situationfamilliale getSelectedSituationfamilliale() {
        return selectedSituationfamilliale;
    }

    /**
     *
     * @param selectedSituationfamilliale
     */
    public void setSelectedSituationfamilliale(Situationfamilliale selectedSituationfamilliale) {
        this.selectedSituationfamilliale = selectedSituationfamilliale;
    }

    /**
     *
     * @return
     */
    public List<Situationfamilliale> getSituationfamilliales() {
        return situationfamilliales;
    }

    /**
     *
     * @param situationfamilliales
     */
    public void setSituationfamilliales(List<Situationfamilliale> situationfamilliales) {
        this.situationfamilliales = situationfamilliales;
    }

    /**
     *
     * @return
     */
    public Ville getVille() {
        return ville;
    }

    /**
     *
     * @param ville
     */
    public void setVille(Ville ville) {
        this.ville = ville;
    }

    /**
     *
     * @return
     */
    public Nationalite getNationalite() {
        return nationalite;
    }

    /**
     *
     * @param nationalite
     */
    public void setNationalite(Nationalite nationalite) {
        this.nationalite = nationalite;
    }
    
 //une methode permettant de consulter et d'editer sur la meme dialogue

    /**
     *
     */

    public void setModifierToFalse() {
        modifier = false;
    }

    /**
     *
     */
    public void setModifierToTrue() {
        modifier = true;
    }

    /**
     *
     */
    public void setModifierDiplomeToFalse() {
        modifier = false;
    }

    /**
     *
     */
    public void setModifierDiplomeToTrue() {
        modifier = true;
    }
    
    /**
     *
     */
    public void setModifierStatusToFalse() {
        modifier = false;
    }

    /**
     *
     */
    public void setModifierSituationFamillialeToFalse() {
        modifier = false;
    }

    /**
     *
     */
    public void setModifierSituationFamillialeToTrue() {
        modifier = true;
    }
    
    /**
     *
     */
    public void setModifierStatusToTrue() {
        modifier = true;
    }

    /**
     *
     * @return
     */
    public Boolean getModifier() {
        return modifier;
    }

    /**
     *
     * @param modifier
     */
    public void setModifier(Boolean modifier) {
        this.modifier = modifier;
    }

    /**
     *
     * @return
     */
    public Boolean getModifierDiplome() {
        return modifierDiplome;
    }

    /**
     *
     * @param modifierDiplome
     */
    public void setModifierDiplome(Boolean modifierDiplome) {
        this.modifierDiplome = modifierDiplome;
    }

    /**
     *
     * @return
     */
    public Boolean getModifierStatus() {
        return modifierStatus;
    }

    /**
     *
     * @param modifierStatus
     */
    public void setModifierStatus(Boolean modifierStatus) {
        this.modifierStatus = modifierStatus;
    }
    
    /**
     *
     * @return
     */
    public Boolean getModifierSituationfamilliale() {
        return modifierStatus;
    }

    /**
     *
     * @param modifierStatus
     */
    public void setModifierSituationfamilliale(Boolean modifierStatus) {
        this.modifierStatus = modifierStatus;
    }
    
    /**
     *
     */
    public void setModifierSituationfamillialeToFalse() {
        modifier = false;
    }

    /**
     *
     */
    public void setModifierSituationfamillialeToTrue() {
        modifier = true;
    }

    /**
     *
     * @return
     */
    public Niveauxacademique getNiveauxAcademique() {
        return niveauxAcademique;
    }

    /**
     *
     * @param niveauxAcademique
     */
    public void setNiveauxAcademique(Niveauxacademique niveauxAcademique) {
        this.niveauxAcademique = niveauxAcademique;
    }
}
