/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import View.interface_enfant;
import Model.Enfant;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import java.util.Date;
import java.util.List;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;



import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

 

public class ControllerEnfant {

    public void handleInscriptionButton(
            TextField nomField, TextField prenomField, TextField adresseField,
            DatePicker dateNaissancePicker, TextField emailParentField,
            TextField telParentField, TextField alerteField,
            ChoiceBox<String> sexeChoiceBox, DatePicker dateDebutPicker, DatePicker dateFinPicker,
            List<Enfant> enfants, TableView<Enfant> tableView
    ) throws ParseException {

        LocalDate dateNaissance = dateNaissancePicker.getValue();
        LocalDateTime dateTimeNaissance = null;

        if (dateNaissance != null) {
            dateTimeNaissance = dateNaissance.atStartOfDay(ZoneId.systemDefault()).toLocalDateTime();
        } else {
            System.out.println("Veuillez sélectionner une date de naissance.");
            return;
        }

        LocalDate dateDebut = dateDebutPicker.getValue();
        LocalDateTime dateTimeDebut = null;

        if (dateDebut != null) {
            dateTimeDebut = dateDebut.atStartOfDay(ZoneId.systemDefault()).toLocalDateTime();
        } else {
            System.out.println("Veuillez sélectionner une date de début.");
            return;
        }

        LocalDate dateFin = dateFinPicker.getValue();
        LocalDateTime dateTimeFin = null;

        if (dateFin != null) {
            dateTimeFin = dateFin.atStartOfDay(ZoneId.systemDefault()).toLocalDateTime();
        } else {
            System.out.println("Veuillez sélectionner une date de fin.");
            return;
        }

        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String adresse = adresseField.getText();
        String emailParent = emailParentField.getText();
        String tel = telParentField.getText();
       /* 
        int tel = 0;

        String telText = telParentField.getText();
        if (!telText.isEmpty()) {
            try {
                tel = Integer.parseInt(telText);
            } catch (NumberFormatException e) {
                System.out.println("Le numéro de téléphone n'est pas un nombre valide !");
                return;
            }
        }
*/
        String alerte = alerteField.getText();
        String sexe = sexeChoiceBox.getValue();

        Enfant nouvelEnfant = new Enfant(
            126, nom, prenom, adresse,
            Date.from(dateTimeNaissance.atZone(ZoneId.systemDefault()).toInstant()),
            emailParent, tel, alerte,
            Date.from(dateTimeDebut.atZone(ZoneId.systemDefault()).toInstant()),
            Date.from(dateTimeFin.atZone(ZoneId.systemDefault()).toInstant())
        );

        enfants.add(nouvelEnfant);
        tableView.setItems(FXCollections.observableArrayList(enfants));

        // Effacer les champs après l'inscription
        nomField.clear();
        prenomField.clear();
        // Effacer les autres champs de la même manière
    }
    
   
   

 public void handleRetourButton() throws ParseException {
        // Votre code existant

        // Initialisation du bouton retourButton
        Button retourButton = new Button("Retour"); // Assurez-vous d'avoir importé Button de javafx.scene.control

        // Ajout de l'événement au bouton
        retourButton.setOnAction(event -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("View/InterfaceGenerale.fxml"));
                Scene scene = new Scene(root);
                Stage primaryStage=(Stage)((Node)event.getSource()).getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.show();
                
                primaryStage.setTitle("Centre de Loisir d'enfants HAPPY KIDS");
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException ex) {
                Logger.getLogger(ControllerEnfant.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
 }

public void initialize() {
        // Suppose que vous avez déjà votre bouton "RetourButton" initialisé
        Button retourButton = new Button("Retour");
        
        // Ajout de l'événement au bouton
        retourButton.setOnAction(event -> {
            
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceGenerale.fxml"));
                Parent root = loader.load();
                
                Scene scene = new Scene(root, 913, 676); // Adjust the size as needed
                Stage primaryStage=(Stage)((Node)event.getSource()).getScene().getWindow();
                primaryStage.setTitle("Centre de Loisir d'enfants HAPPY KIDS");
                primaryStage.setScene(scene);
                primaryStage.show();
                
                // Vous pouvez ajouter le bouton à votre interface si nécessaire
                // ...
            } catch (IOException ex) {
                Logger.getLogger(ControllerEnfant.class.getName()).log(Level.SEVERE, null, ex);
            }
    
              
        });
}}