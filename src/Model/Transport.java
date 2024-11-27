/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.ArrayList;

public class Transport extends Service {

    private final ArrayList<Integer> matriculeVoiture;
    private final ArrayList<Employe> moniteurs;
    private String stationDepart;
    private String stationArrive;
    private String horaire;

    public Transport(int idService, String nomService, int capacite, double cout) {
        super(idService, nomService, capacite, cout);
        matriculeVoiture = new ArrayList<>();
        moniteurs = new ArrayList<>();
        stationDepart = "";
        stationArrive = "";
        horaire = "";
    }

    public ArrayList<Integer>getMatriculeVoiture() {
        return matriculeVoiture;
    }

    public ArrayList<Employe>getMoniteurs() {
        return moniteurs;
    }

    public String getStationDepart() {
        return stationDepart;
    }

    public void setStationDepart(String stationDepart) {
        this.stationDepart = stationDepart;
    }

    public String getStationArrive() {
        return stationArrive;
    }

    public void setStationArrive(String stationArrive) {
        this.stationArrive = stationArrive;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public void ajouterVoiture(int matricule) {
        matriculeVoiture.add(matricule);
    }

    public void ajouterMoniteur(Employe moniteur) {
        moniteurs.add(moniteur);
}
}

