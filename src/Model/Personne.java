package Model;
import Interface.InterfaceFonctionnelleInformations;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author jihen
 */
public abstract class Personne implements InterfaceFonctionnelleInformations {
    int idPersonne;
    String nom;
    String prenom;
    String adresse;
    Date dateNaissance;
    String mail;
    String tel; // Modifier le type de tel en String

    public Personne(int idPersonne, String nom, String prenom, String adresse, Date dateNaissance, String mail, String tel) throws ParseException {
        this.idPersonne = idPersonne;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;

        // Vérification de la date de naissance
        validateDateNaissance(dateNaissance);

        this.dateNaissance = dateNaissance;

        // Vérification du numéro de téléphone
        validateTel(tel);

        this.mail = mail;
        this.tel = tel;
    }

    public Personne() {
    }

    public Personne(String nom, String prenom, String tel, String mail, String adresse) throws ParseException {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;

        // Vérification du numéro de téléphone
        validateTel(tel);

        this.mail = mail;
        this.tel = tel;
    }
    
    public Personne(int dPersonne,String nom, String prenon,String adresse,Date dateNaissance, String tel) throws ParseException {
        this.idPersonne = idPersonne;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;

        // Vérification de la date de naissance
        validateDateNaissance(dateNaissance);

        this.dateNaissance = dateNaissance;

        // Vérification du numéro de téléphone
        validateTel(tel);
        this.tel = tel;
    }

    // Méthode pour valider la date de naissance
    private void validateDateNaissance(Date dateNaissance) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        dateFormat.parse(dateFormat.format(dateNaissance)); // Cela déclenchera une ParseException si la date est invalide
    }

    // Méthode pour valider le numéro de téléphone
    private void validateTel(String tel) {
        if (tel.length() != 8) {
            throw new IllegalArgumentException("Le numéro de téléphone doit contenir 8 chiffres.");
        }
        try {
            Long.parseLong(tel); // Vérifier si c'est un nombre
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Le numéro de téléphone doit être un nombre.");
        }
    }

    // Getters et Setters pour idPersonne
    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    // Getters et Setters pour nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getters et Setters pour prenom
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Getters et Setters pour adresse
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    // Getters et Setters pour dateNaissance
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    // Getters et Setters pour mail
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    // Getters et Setters pour tel
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        validateTel(tel); // Valider le numéro de téléphone lors de la modification
        this.tel = tel;
    }

    public int calculAge(Date dateNaissance) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateNaissance);
        int anneeNaissance = calendar.get(Calendar.YEAR);

        Calendar calendarCourant = Calendar.getInstance();
        int anneeCourante = calendarCourant.get(Calendar.YEAR);

        return anneeCourante - anneeNaissance;
    }

    // Implémentation de la méthode afficherInformations à l'aide d'une expression lambda
    public InterfaceFonctionnelleInformations afficherInformations = () -> {
        System.out.println("ID: " + idPersonne);
        System.out.println("Nom: " + nom);
        System.out.println("Prénom: " + prenom);
        System.out.println("Adresse: " + adresse);
        System.out.println("Date de Naissance: " + new SimpleDateFormat("dd/MM/yyyy").format(dateNaissance));
        System.out.println("Mail: " + mail);
        System.out.println("Téléphone: " + tel);
        System.out.println("Âge: " + calculAge(dateNaissance));
    };
}