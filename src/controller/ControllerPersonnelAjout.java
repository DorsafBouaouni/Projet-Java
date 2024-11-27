/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import View.interface_personnel;
import Model.Employe;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author dorsa
 */
public class ControllerPersonnelAjout {
    public void handleInscriptionButton(
            TextField nomField, TextField prenomField, TextField adresseField,
            DatePicker dateNaissancePicker, 
            TextField telField, TextField posteField,
            ChoiceBox<String> sexeChoiceBox,
            List<Employe> employes, TableView<Employe> tableViewPersonnel
    ) throws ParseException {
       
     LocalDate dateNaissance = dateNaissancePicker.getValue();
      
        LocalDateTime dateTimeNaissance = null;

        if (dateNaissance != null) {
            dateTimeNaissance = dateNaissance.atStartOfDay(ZoneId.systemDefault()).toLocalDateTime();
        } else {
            System.out.println("Veuillez sélectionner une date de naissance.");
            return; // Sortir de la méthode si la date de naissance est null
        }
        
        //************
       
        
        //******

        String nom = nomField.getText();
        String prenom = prenomField.getText();
      
        String adresse = adresseField.getText();
         String tel = telField.getText();
       
        String poste = posteField.getText();
        String sexe = sexeChoiceBox.getValue();

        Employe nouvelEmploye = new Employe(126, nom, prenom, adresse, Date.from(dateTimeNaissance.atZone(ZoneId.systemDefault()).toInstant()), tel, poste);
        employes.add(nouvelEmploye);
        tableViewPersonnel.setItems(FXCollections.observableArrayList(employes));

        // Effacer les champs après l'inscription
        nomField.clear();
        prenomField.clear();
        // Effacer les autres champs de la même manière
    }

    
}
