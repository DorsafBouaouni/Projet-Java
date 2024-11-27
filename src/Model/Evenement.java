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

public class Evenement extends Service {
    
    private Date dateEvenement;
    private String nomEvenement;

    public Evenement(int idService ,String nomService, int capacite, double cout) {
        super(idService, nomService, capacite, cout);
        dateEvenement = null; 
        nomEvenement = "";
    }

    public Date getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(Date dateEvenement) {
         this.dateEvenement = dateEvenement;
    }

    public String getNomEvenement() {
        return nomEvenement;
    }

    public void setTypeEvenement(String nomEvenement) {
        this.nomEvenement = nomEvenement;
    } 
}