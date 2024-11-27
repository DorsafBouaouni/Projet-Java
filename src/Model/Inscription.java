/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author dorsa
 */
import java.util.Date;
import java.util.ArrayList;

public class Inscription {
    
    int idInscription;
    private Enfant enfant;
    private ArrayList<Activite> activites;
    private ArrayList<Service> services;
    private Date dateInscription;
    private Date finInscription;
    private double montantPaye;
    
    public int getIdInscription(){
        return idInscription ;
    }
    public Enfant getEnfant() {
        return enfant;
    }

    public void setEnfant(Enfant enfant) {
        this.enfant = enfant;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public Date getDateFinInscription() {
        return finInscription;
    }

    public boolean controleSession() {
       Date dateCourante = new Date(); 
    // Comparez la date courante avec la date de fin d'inscription
       if (finInscription.after(dateCourante)) {
           return true; }// L'inscription est encore valide
       else {
        return false; }// L'inscription a expiré
    }

    public double calculMontant() {
       double montantTotal = 0.0;

    if (activites != null) {
        for (Activite activite : activites) {  
            montantTotal += activite.getCout();
        }
    }

    if (services != null) {
        for (Service service : services) {
            montantTotal += service.getCout();
        }
    }
    return montantTotal;
}
}
