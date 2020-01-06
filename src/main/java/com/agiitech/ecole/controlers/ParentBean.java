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
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author HP-FOLIO
 */
@Named(value = "parentBean")
@SessionScoped
public class ParentBean extends AbstractBean implements Serializable {

    /**
     * Creates a new instance of Parent
     */
    /**
     * liste des proprietes
     */
    private Parent parent = new Parent();
    private Ville ville = new Ville();
    private Ville selectedVille = new Ville();
    private Lienfamillial lienFamillial = new Lienfamillial();
    private boolean modifier = false;// pour modifier et consulter avec la meme dialogue
    private boolean modifierVille = false;// pour modifier et consulter avec la meme dialogue
    // private boolean modifierParent = false;// pour modifier et consulter avec la meme dialogue
    private boolean modifierProfession = false;// pour modifier et consulter avec la meme dialogue
    private boolean modifierLienFamillial = false;// pour modifier et consulter avec la meme dialogue
    private Boolean skip = true;//pour faire avancer le wizard
    private Boolean skypeParent = false;// pour skype le parent
    /**
     * liste des elements selectionnes
     */
    private Lienfamillial selectedLienFamillial = new Lienfamillial();
    private Parent selectedParent = new Parent();
    private Profession profession = new Profession();
    private Profession selectedProfession = new Profession();
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

    public ParentBean() {
    }

    @PostConstruct
    public void init() {
        parents = facade.findAll();
        villes = villeFacade.findAll();
        professions = professionFacade.findAll();
        liens = lienFamillialFacade.findAll();

    }

    public String onFlowProcess(FlowEvent event) {
//        if (skip==true) {
//            skip = false;   //reset in case user goes back
//            return "confirm";
//        } else {
//            return event.getNewStep();
//        }
//System.out.println("test:"+event.getNewStep());
        if (skypeParent == true) {
            event.getNewStep();
            skypeParent = false;
        }
        return event.getNewStep();
    }

    public Boolean getSkip() {
        return skip;
    }

    public void setSkip(Boolean skip) {
        this.skip = skip;
    }

    public Boolean getSkypeParent() {
        return skypeParent;
    }

    public void setSkypeParent(Boolean skypeParent) {
        this.skypeParent = skypeParent;
    }

    /**
     * methodes de creation, suppression, modification pour la ville
     */
    public void createVille() throws Throwable {
        try {
            villeFacade.create(ville);
            displayInfoMessage("ville " + ville.getLibelleville() + " insérée");

        } catch (Exception e) {
            displayErrorMessage("ville " + ville.getLibelleville() + " non insérée");
        } finally {
            ville = new Ville();
            init();
        }
    }

    public void deleteVille(Ville ville) {
        try {
            villeFacade.remove(ville);
            displayInfoMessage("ville " + ville.getLibelleville() + " supprimée avec succès");
            init();
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression de la ville " + ville.getLibelleville());
        }
        init();
    }

    public void updateVilleRow(RowEditEvent event) {
        try {
            villeFacade.edit((Ville) event.getObject());
            displayInfoMessage("ville " + ((Ville) event.getObject()).getIdville() + " éditée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du ville " + ((Ville) event.getObject()).getIdville());
        }
        // init();
    }

    public void updateVille(Ville ville) {
        try {
            villeFacade.edit(selectedVille);
            displayInfoMessage("ville " + selectedVille.getLibelleville() + " éditée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du ville " + selectedVille.getLibelleville());
        }
        init();
    }

    public void updateVille() {
        try {
            villeFacade.edit(selectedVille);
            displayInfoMessage("ville " + selectedVille.getLibelleville() + " éditée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du ville " + selectedVille.getLibelleville());
        }
        init();
    }

    /**
     * methodes de creation, suppression, modification pour la profession
     */
    public void createProfession() throws Throwable {
        try {
            professionFacade.create(profession);
            displayInfoMessage("profession " + profession.getLibelleprofession() + " insérée");

        } catch (Exception e) {
            displayErrorMessage("profession " + profession.getLibelleprofession() + " non insérée");
        } finally {
            profession = new Profession();
            init();
        }
    }

    public void deleteProfession(Profession profession) {
        try {
            professionFacade.remove(profession);
            displayInfoMessage("profession " + profession.getLibelleprofession() + " supprimée avec succès");
            init();
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression de la profession " + profession.getLibelleprofession());
        }
        init();
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

    public void updateProfession() {
        try {
            professionFacade.edit(selectedProfession);
            displayInfoMessage("profession " + selectedProfession.getLibelleprofession() + " éditée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du profession " + selectedProfession.getLibelleprofession());
        }
        init();
    }

    /**
     * methodes de creation, suppression, modification des parents
     */
    public void createParent() throws Throwable {
        try {
            parent.setIdlien(lienFamillial);
            parent.setIdprofession(profession);
            parent.setIdville(ville);
            facade.create(parent);
            displayInfoMessage("parent " + parent.getNom() + " inséré");

        } catch (Exception e) {
            displayErrorMessage("parent " + parent.getNom() + " non inséré");
        } finally {
            parent = new Parent();
            init();
        }
    }

    public void createParentWizard() throws Throwable {
        parent.setIdlien(lienFamillial);
        parent.setIdprofession(profession);
        parent.setIdville(ville);
        facade.create(parent);
    }

    public void deleteParent(Parent parent) {
        try {
            facade.remove(parent);
            displayInfoMessage("parent " + parent.getNom() + " supprimé avec succès");
            init();
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du parent " + parent.getNom());
        }
        init();
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

    public void updateParent() {
        try {
            selectedParent.setIdlien(lienFamillialFacade.getbByID(selectedParent.getIdlien()));
            selectedParent.setIdprofession(professionFacade.getByID(selectedParent.getIdprofession()));
            selectedParent.setIdville(villeFacade.getById(selectedParent.getIdville()));
            facade.edit(selectedParent);
            displayInfoMessage("parent " + selectedParent.getNom() + " édité avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du parent " + selectedParent.getNom());
        }
        init();
    }

    /**
     * methodes de creation, suppression, modification du lienFamillial
     */
    public void createLienFamillial() throws Throwable {
        try {
            lienFamillialFacade.create(lienFamillial);
            displayInfoMessage("lienFamillial " + lienFamillial.getLibelle() + " inséré");

        } catch (Exception e) {
            displayErrorMessage("lienFamillial " + lienFamillial.getLibelle() + " non inséré");
        } finally {
            lienFamillial = new Lienfamillial();
            init();
        }
    }

    public void deleteLienFamillial(Lienfamillial lienFamillial) {
        try {
            lienFamillialFacade.remove(lienFamillial);
            displayInfoMessage("lienFamillial " + lienFamillial.getLibelle() + " supprimé avec succès");
            init();
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du lienFamillial " + lienFamillial.getLibelle());
        }
        init();
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

    public void updateLienFamillial() {
        try {
            lienFamillialFacade.edit(selectedLienFamillial);
            displayInfoMessage("lienFamillial " + selectedLienFamillial.getLibelle() + " édité avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression du lienFamillial " + selectedLienFamillial.getLibelle());
        }
        init();
    }

    public void cancelled() {
        displayInfoMessage("vous avez annulez la supression");
    }

    public void setModifierVilleToFalse() {
        modifierVille = false;
    }

    public void setModifierVilleToTrue() {
        modifierVille = true;
    }

    public void setModifierProfessionToFalse() {
        modifierProfession = false;
    }

    public void setModifierProfessionToTrue() {
        modifierProfession = true;
    }

    public void setModifierLienFamillialToFalse() {
        modifierLienFamillial = false;
    }

    public void setModifierLienFamillialToTrue() {
        modifierLienFamillial = true;
    }

    public Parent getParent() {
        return parent;
    }

    public Ville getVille() {
        return ville;
    }

    public Ville getSelectedVille() {
        return selectedVille;
    }

    public Lienfamillial getLienFamillial() {
        return lienFamillial;
    }

    public boolean isModifierVille() {
        return modifierVille;
    }

    public Lienfamillial getSelectedLienFamillial() {
        return selectedLienFamillial;
    }

    public Parent getSelectedParent() {
        return selectedParent;
    }

    public Profession getProfession() {
        return profession;
    }

    public Profession getSelectedProfession() {
        return selectedProfession;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Ville> getVilles() {
        return villes;
    }

    public List<Lienfamillial> getLiens() {
        return liens;
    }

    public List<Profession> getProfessions() {
        return professions;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public void setSelectedVille(Ville selectedVille) {
        this.selectedVille = selectedVille;
    }

    public void setLienFamillial(Lienfamillial lienFamillial) {
        this.lienFamillial = lienFamillial;
    }

    public void setModifierVille(boolean modifierVille) {
        this.modifierVille = modifierVille;
    }

    public void setSelectedLienFamillial(Lienfamillial selectedLienFamillial) {
        this.selectedLienFamillial = selectedLienFamillial;
    }

    public void setSelectedParent(Parent selectedParent) {
        this.selectedParent = selectedParent;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public void setSelectedProfession(Profession selectedProfession) {
        this.selectedProfession = selectedProfession;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public void setVilles(List<Ville> villes) {
        this.villes = villes;
    }

    public void setLiens(List<Lienfamillial> liens) {
        this.liens = liens;
    }

    public void setProfessions(List<Profession> professions) {
        this.professions = professions;
    }

    public boolean isModifierProfession() {
        return modifierProfession;
    }

    public void setModifierProfession(boolean modifierProfession) {
        this.modifierProfession = modifierProfession;
    }

    public boolean isModifierLienFamillial() {
        return modifierLienFamillial;
    }

    public void setModifierLienFamillial(boolean modifierLienFamillial) {
        this.modifierLienFamillial = modifierLienFamillial;
    }

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
