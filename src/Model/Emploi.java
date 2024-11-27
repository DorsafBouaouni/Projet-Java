/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dorsa
 */
public class Emploi {
    private List<Activite>[] emploiDuTemps;
    
  public Emploi() {
        // Initialisation de l'emploi du temps pour chaque jour de la semaine
        emploiDuTemps = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            emploiDuTemps[i] = new ArrayList<>();
        }
    }

    // Méthode pour ajouter une activité à un jour donné avec une heure de début
    public void ajouterActivite(Activite activite, int jour, int heureDebut) {
        if (jour >= 0 && jour < 5) {
            emploiDuTemps[jour].add(activite);
            System.out.println("Activité ajoutée le jour " + jour + " à l'heure de début " + heureDebut);
        } else {
            System.out.println("Jour invalide. Veuillez spécifier un jour entre 0 et 4 ");
    }
    }

}