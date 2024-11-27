/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Date;
import Model.Enfant;

/**
 *
 * @author dorsa
 */
/*public class Formulaire_inscription extends Application {
    


     @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        // Labels
        Label nameLabel = new Label("Nom:");
        Label firstNameLabel = new Label("Prénom:");
        Label addressLabel = new Label("Adresse:");
        Label telParentLabel = new Label("Téléphone Parent:");
        Label emailParentLabel = new Label("Email Parent:");
        Label alertLabel = new Label("Alerte:");

        // Text Fields
        TextField nameField = new TextField();
        TextField firstNameField = new TextField();
        TextField addressField = new TextField();
        TextField telParentField = new TextField();
        TextField emailParentField = new TextField();
        TextField alertField = new TextField();

        // Date Picker for Date of Birth
        DatePicker datePicker = new DatePicker();

        // Button to submit the form
        Button submitButton = new Button("Enregistrer");
        submitButton.setOnAction(event -> {
            // Récupérez les valeurs saisies
            String nom = nameField.getText();
            String prenom = firstNameField.getText();
            String adresse = addressField.getText();
            int telParent = Integer.parseInt(telParentField.getText());
            String emailParent = emailParentField.getText();
            String alerte = alertField.getText();
            Date dateNaissance = java.sql.Date.valueOf(datePicker.getValue());

            // Créez un nouvel objet Enfant avec les valeurs saisies
            Enfant nouvelEnfant = new Enfant();
            nouvelEnfant.setNom(nom);
            nouvelEnfant.setPrenom(prenom);
            nouvelEnfant.setAdresse(adresse);
            nouvelEnfant.setTelParent(telParent);
            nouvelEnfant.setEmailParent(emailParent);
            nouvelEnfant.setAlert(alerte);
           // nouvelEnfant.setDateNaissance(dateNaissance);

            // Ici, vous pouvez faire quelque chose avec nouvelEnfant, par exemple l'enregistrer dans une liste
            // Ou faire d'autres opérations en fonction de votre logique métier
        });

        // Add components to the grid
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(firstNameLabel, 0, 1);
        grid.add(firstNameField, 1, 1);
        grid.add(addressLabel, 0, 2);
        grid.add(addressField, 1, 2);
        grid.add(telParentLabel, 0, 3);
        grid.add(telParentField, 1, 3);
        grid.add(emailParentLabel, 0, 4);
        grid.add(emailParentField, 1, 4);
        grid.add(alertLabel, 0, 5);
        grid.add(alertField, 1, 5);
        grid.add(new Label("Date de Naissance:"), 0, 6);
        grid.add(datePicker, 1, 6);
        grid.add(submitButton, 0, 7, 2, 1);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Formulaire Enfant");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}*/