package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Interface.InterfaceFonctionnelleInformations;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jihen
 */
public class Enfant extends Personne {
    
    private String alert;
    Date  dateDebut;
    Date dateFin;
      
    // Constructeur de la classe Enfant
    public Enfant(int idPersonne, String nom, String prenom, String adresse, Date dateNaissance, String mail, String tel, String alert) throws ParseException {
        super(idPersonne,nom,prenom,adresse,dateNaissance, mail, tel);
        this.alert = alert;
    }

    
    public Enfant(int idPersonne, String nom, String prenom, String adresse, Date dateNaissance, String mail, String tel, String alert, Date  dateDebut, Date  dateFin) throws ParseException {
        super(idPersonne, nom, prenom, adresse, dateNaissance, mail, tel);
        this.alert = alert;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
    }

  
   // Getters et Setters pour idPersonne
    @Override
    public int getIdPersonne() {
        return idPersonne;
    }
    
    @Override
    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    // Getters et Setters pour nom
    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getters et Setters pour prenom
    @Override
    public String getPrenom() {
        return prenom;
    }

    @Override
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Getters et Setters pour adresse
    @Override
    public String getAdresse() {
        return adresse;
    }

    @Override
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    // Getters et Setters pour dateNaissance
    @Override
    public Date getDateNaissance() {
        return dateNaissance;
    }

    @Override
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    // Getters et Setters pour mail
    @Override
    public String getMail() {
        return mail;
    }

    @Override
    public void setMail(String mail) {
        this.mail = mail;
    }

    // Getters et Setters pour tel
    @Override
    public String getTel() {
        return tel;
    }

    @Override
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }


  // Implémentation de la méthode afficherInformations pour Enfant
    private InterfaceFonctionnelleInformations afficherInformationsEnfant = () -> {
        afficherInformations.afficherInformations();
        System.out.println("Alert: " + alert);
    };

    // Appel de la méthode afficherInformations spécifique à Enfant
    public void afficherInformationsEnfant() {
        afficherInformationsEnfant.afficherInformations();
    }

    @Override
    public void afficherInformations() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}