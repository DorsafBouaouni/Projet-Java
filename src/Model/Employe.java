package Model;
import Interface.InterfaceFonctionnelleInformations;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jihen
 */


public class Employe extends Personne {
        
   private String poste;
    private String CIN;
    private double salaire;

    // Constructeur de la classe Employe
    public Employe(int idPersonne, String nom, String prenom, String adresse, Date dateNaissance, String mail, String tel, String poste, String CIN, double salaire) throws ParseException {
        super(idPersonne, nom, prenom, adresse, dateNaissance, mail, tel);
        this.poste = poste;
        this.CIN = CIN;
        this.salaire = salaire;
    }
    
    public Employe() {
    }
    
    public Employe(int idPersonne, String nom, String prenom, String adresse, Date dateNaissance, String mail,String tel,double salaire) throws ParseException {
        super(idPersonne, nom, prenom, adresse, dateNaissance,mail, tel);
        this.salaire = salaire;
    }
    public Employe(int idPersonne, String nom, String prenom, String adresse, Date dateNaissance,String tel,String poste) throws ParseException {
        super(idPersonne, nom, prenom, adresse, dateNaissance, tel);
        this.poste = poste;
    }

    // Un constructeur qui prend en charge les attributs essentiels
    public Employe(String nom, String prenom,String CIN, String tel , String mail ,String adresse) throws ParseException {
        super(nom, prenom, tel, mail,adresse);
        this.CIN = CIN;
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

    // Getters et Setters pour poste
    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    // Getters et Setters pour CIN
    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    // Getters et Setters pour salaire
    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public int calculAge(Date dateNaissance) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateNaissance);
        int anneeNaissance = calendar.get(Calendar.YEAR);

         Calendar calendarCourant = Calendar.getInstance();
        int anneeCourante = calendarCourant.get(Calendar.YEAR);

        int age = anneeCourante - anneeNaissance;
        return age;
    }

     // Implémentation de la méthode afficherInformations pour Employe
    private InterfaceFonctionnelleInformations afficherInformationsEmploye = () -> {
        afficherInformations.afficherInformations();
        System.out.println("Poste: " + poste);
        System.out.println("CIN: " + CIN);
        System.out.println("Salaire: " + salaire);
    };

    // Appel de la méthode afficherInformations spécifique à Employe
    public void afficherInformationsEmploye() {
        afficherInformationsEmploye.afficherInformations();
    }

    @Override
    public void afficherInformations() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}