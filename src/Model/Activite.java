/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Date;
public class Activite {
    
    int idActivite;
    String nomActivite;
    String description;
    Employe responsable;
    String type;
    String outils;
    double cout; 

    public Activite(int idActivite, String nomActivite, String description, Employe responsable , String type, String outils , double cout) {
        this.idActivite = idActivite;
        this.nomActivite = nomActivite;
        this.description = description;
        this.responsable = responsable;
        this.type = type;
        this.outils = outils;
        this.cout = cout;
    }

    public Activite(String nomActivite) {
        this.nomActivite = nomActivite;
    }
   
    // Getters et setters pour les attributs de Activite
    public int getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(int idActivite) {
        this.idActivite = idActivite;
    }

    public String getNomActivite() {
        return nomActivite;
    }

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Employe getResponsable() {
        return responsable;
    }

    public void setResponsable(Employe responsable) {
        this.responsable = responsable;
    }

    public String getOutils() {
        return outils;
    }

    public void setOutils(String outils) {
        this.outils = outils;
    }
    
    public double getCout() {
        return cout;
    }

    public void setCout(double cout){
        this.cout = cout;
    }
    
    // Méthode pour saisir une activité
    public void saisirActivite(int id, String nom, String description, Employe responsable, String type , String outils , double cout) {
        this.idActivite = id;
        this.nomActivite = nom;
        this.description = description;
        this.responsable = responsable;
        this.type = type;
        this.outils = outils;
        this.cout = cout;
    }

    // Méthode pour afficher une activité
    public void afficherActivite() {
        System.out.println("ID d'activité : " + idActivite);
        System.out.println("Nom de l'activité : " + nomActivite);
        System.out.println("Description : " + description);
        System.out.println("Responsable : " + responsable.getNom() + " " + responsable.getPrenom());
        System.out.println("Type: " + type);
        System.out.println("Outils: " + outils);
    }
}
