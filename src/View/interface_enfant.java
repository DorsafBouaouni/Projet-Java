/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;




import Model.Enfant;
import controller.ControllerEnfant;
import java.text.ParseException;
import java.util.Date;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.scene.control.TableColumn;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;









public class interface_enfant extends Application {


    
@Override
    public void start(Stage primaryStage) throws ParseException {
        Enfant enfant1 = new Enfant(123, "Ben ahmed", "Mohamed", "Ariana", new Date(115, 2, 12), "parent123@gmail.com"," 22222222", "alergique");
         Enfant enfant2 = new Enfant(124, "Ben Ali", "Sirin", "Tunis", new Date(117, 5, 12), "parent124@gmail.com", "22222222", "");
        Enfant enfant3 = new Enfant(125, "Ben Mohamed", "Eline", "sokra", new Date(118, 5, 18), "parent125@gmail.com", "33333333", "Probleme psychologique");
        Enfant enfant4 = new Enfant(126, "Ben ahmed", "joud", "ariana", new Date(116, 5, 12), "parent126@gmail.com", "44444444", "");

        
        TableView<Enfant> tableView = new TableView<>();
        
         tableView.setMaxWidth(1000);
         
         
         
        
        
     TableColumn<Enfant, Integer> idCol = new TableColumn<>("ID");
    idCol.setCellValueFactory(data -> {
    int id = data.getValue().getIdPersonne();
    return id != 0 ? new SimpleObjectProperty<>(id) : new SimpleObjectProperty<>(null);
});


     TableColumn<Enfant, String> nomCol = new TableColumn<>("Nom");
nomCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));

TableColumn<Enfant, String> prenomCol = new TableColumn<>("Prénom");
prenomCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPrenom()));

TableColumn<Enfant, String> adresseCol = new TableColumn<>("Adresse");
adresseCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAdresse()));

TableColumn<Enfant, String> dateNaissanceCol = new TableColumn<>("Date de Naissance");
dateNaissanceCol.setCellValueFactory(data -> {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String formattedDate = dateFormat.format(data.getValue().getDateNaissance());
    return new SimpleStringProperty(formattedDate);
});
TableColumn<Enfant, String> emailParentCol = new TableColumn<>("Email Parent");
emailParentCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMail()));

TableColumn<Enfant, String> telCol = new TableColumn<>("Téléphone");
telCol.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getTel())));


TableColumn<Enfant, String> alerteCol = new TableColumn<>("Alerte");
alerteCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAlert()));


//****************adddddddddd
TableColumn<Enfant, String> debut_inscrip_Col = new TableColumn<>("debut d'insecription");
TableColumn<Enfant, String> fin_inscrip_Col = new TableColumn<>("fin d'insecription");
//******

 tableView.getColumns().addAll(idCol, nomCol, prenomCol, adresseCol,
                                   dateNaissanceCol, emailParentCol, telCol,alerteCol,debut_inscrip_Col,fin_inscrip_Col);
 
 
 ObservableList<Enfant> enfants = FXCollections.observableArrayList(enfant1, enfant2,enfant3,enfant4);
        tableView.setItems(enfants);
 
 //**************************************************************************************
 
 BorderPane rootB = new BorderPane();
 TextField nomField = new TextField();
    nomField.setPromptText("Nom");
nomField.getStyleClass().add("custom-text-field");
    
    TextField prenomField = new TextField();
    prenomField.setPromptText("Prénom");
    prenomField.getStyleClass().add("custom-text-field");
    // Ajoutez d'autres champs nécessaires (adresse, date de naissance, email parent, téléphone, alerte)
    
    TextField adresseField = new TextField();
    adresseField.setPromptText("adresse");
    adresseField.getStyleClass().add("custom-text-field");
     
    DatePicker dateNaissancePicker = new DatePicker();
    dateNaissancePicker.setPromptText("Date de Naissance");
    dateNaissancePicker.getStyleClass().add("custom-text-field");
    
    TextField emailParentField = new TextField();
    emailParentField.setPromptText("Email Parent");
    emailParentField.getStyleClass().add("custom-text-field");
    
    TextField telParentField = new TextField();
    telParentField.setPromptText("Téléphone Parent");
    telParentField.getStyleClass().add("custom-text-field");

    TextField alerteField = new TextField();
    alerteField.setPromptText("Alerte");
    alerteField.getStyleClass().add("custom-text-field");
    
    Label labelSexe = new Label("Sexe");
    
    
    ChoiceBox<String> sexeChoiceBox = new ChoiceBox<>();
sexeChoiceBox.getItems().addAll("Homme", "Femme");

//**************addddd

Label label_debut = new Label("Date de debut de l'inscription");
  DatePicker dateDebutPicker = new DatePicker();
    dateDebutPicker.setPromptText("debut d'insecription");
    dateDebutPicker.getStyleClass().add("custom-text-field");
    
    Label label_fin = new Label("Date de fin de l'inscription");
     DatePicker dateFinPicker = new DatePicker();
    dateFinPicker.setPromptText("fin d'insecription");
    dateFinPicker.getStyleClass().add("custom-text-field");
    
//**********
    
     Text texteGras = new Text("Gérer les données des enfants ou saisir de nouvelles inscriptions");
     texteGras.getStyleClass().add("label-custom");
     
    texteGras.setStyle("-fx-font-weight: bold;"); // Appliquer le style en gras

   
   
    
    
    VBox formulaireLayout = new VBox(10); // Espacement entre les éléments
    formulaireLayout.setPadding(new Insets(10));
    
    formulaireLayout.setMaxWidth(600);
    
    
    formulaireLayout.getChildren().addAll(
        nomField, prenomField, 
        dateNaissancePicker, emailParentField, telParentField, alerteField,labelSexe,sexeChoiceBox,label_debut,dateDebutPicker,label_fin,dateFinPicker
        
    );
 
 
 Button inscriptionButton = new Button("Inscription");
 inscriptionButton.getStyleClass().add("button-inscription");
 
    Button RetourButton = new Button("Quitter");
    RetourButton.getStyleClass().add("button-modifier");
    
    Button miseAJourButton = new Button("Mise à jour Inscription");
    miseAJourButton.getStyleClass().add("button-mise-a-jour");
    
    HBox boutonsLayout = new HBox(10); // Espacement horizontal entre les boutons
    boutonsLayout.getStyleClass().add("buttons-container");
    
    boutonsLayout.getStyleClass().add("buttons-container");
    boutonsLayout.getChildren().addAll(inscriptionButton,miseAJourButton, RetourButton);
 //**********************************************
 ObservableList<Enfant> enfantsList = FXCollections.observableArrayList(enfant1, enfant2, enfant3, enfant4);
 
 
 inscriptionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ControllerEnfant controller = new ControllerEnfant();
                
                try {
                    controller.handleInscriptionButton(
                            nomField, prenomField, adresseField,
                            dateNaissancePicker, emailParentField,
                            telParentField, alerteField,
                            sexeChoiceBox, dateDebutPicker,dateFinPicker,
                            enfantsList, tableView
                    );
                } catch (ParseException ex) {
                    Logger.getLogger(interface_enfant.class.getName()).log(Level.SEVERE, null, ex);
                }       }
        });
 
 RetourButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ControllerEnfant controller = new ControllerEnfant();
                
                try {
                    controller.handleRetourButton(
                            
                    );
                } catch (ParseException ex) {
                    Logger.getLogger(interface_enfant.class.getName()).log(Level.SEVERE, null, ex);
                }       }
        });

 //**********************
        rootB.setCenter(formulaireLayout); 
        VBox root = new VBox(tableView,texteGras,formulaireLayout,boutonsLayout);
         root.getStyleClass().add("root-container");
        Scene scene = new Scene(root, 400, 300);
        
      

        primaryStage.setScene(scene);
        
       scene.getStylesheets().add("file:///C:/Users/dorsa/Documents/NetBeansProjects/Notre_Application/src/View/MyStyle.css");
 // Appliquer les styles CSS
        primaryStage.setTitle("Apropos des Enfants");
        primaryStage.show();
    }
    
    
     public static void main(String[] args) {
        Application.launch(interface_enfant.class, args);
    }

   
}
    

