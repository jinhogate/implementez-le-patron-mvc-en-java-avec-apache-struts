package org.example.demo.ticket.webapp.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.example.demo.ticket.webapp.WebappHelper;

import java.util.List;

public class GestionProjectAction extends ActionSupport implements Action {
    // ******* Les attributs de l'action ******
    //===== Les paramètres en entrée ======
    private Integer id; // id du paramètre à recupérer dans le lien
    //===== Les données de résultat =======
    private List<Projet> listProjet;
    private Projet projet;

    // ******* Les getteurs / setteurs
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public List<Projet> getListProjet() {
        return listProjet;
    }
    public Projet getProjet() {
        return projet;
    }

    //****** Les méthodes
    /**
     * Action listant la liste des projets
     * @return
     */
    public String doList(){
        this.listProjet = WebappHelper.getManagerFactory().getProjetManager().getListProjet();
        return ActionSupport.SUCCESS;
    }

    /**
     * Action affichant les détails d'un projet
     * @return
     */
    public String doDetail(){
        if(id==null){
            this.addActionError("Vous devez indiquer un id" +
                    "du projet");
        }else{
            try {
                this.projet = WebappHelper.getManagerFactory()
                        .getProjetManager().getProjet(this.id);
            } catch (NotFoundException e) {
                this.addActionError("Projet non trouvé" +
                        ". ID = " + this.id);
            }
        }
        return (this.hasErrors())?ActionSupport.ERROR: ActionSupport.SUCCESS;
    }
}
