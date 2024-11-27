/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.io.Serializable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Voiture implements Serializable {
 
    private String matricule;
    private String couleur;
    private String capacite;
    private String marque;

    public Voiture() {
        // Constructeur par défaut
    }

    public Voiture(String matricule, String couleur, String capacite, String marque) {
        this.matricule = matricule;
        this.couleur = couleur;
        this.capacite = capacite;
        this.marque = marque;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
}