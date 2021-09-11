package org.example.demo.ticket.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.example.demo.ticket.webapp.WebappHelper;

public class GestionUtilisateurAction extends ActionSupport {

    //********** Les paramètres de l'action
    //====> Les paramètres d'entrée
    private Integer id; // id du paramètre du lien
    //====> Les paramètres de sorties
    private Utilisateur utilisateur;

    //****** Les getteurs/ setteurs
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    // ***** Les méthodes ou nos actions
    public String doDetail(){
        if(this.id==null){
            this.addActionError("Veillez cliquer sur un utilisateur");
        }else{
            try {
                this.utilisateur = WebappHelper.getManagerFactory()
                        .getUtilisateurManager().getUtilisateur(this.id);
            } catch (NotFoundException e) {
                this.addActionError("L'utilisateur ID = " + this.id +
                        " n'existe pas!");
            }
        }
        return (this.hasActionErrors())?ActionSupport.ERROR:ActionSupport.SUCCESS;
    }

}
