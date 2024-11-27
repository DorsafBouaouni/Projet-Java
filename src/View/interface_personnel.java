/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import  Model.Employe;
import controller.ControllerEnfant;
import controller.ControllerPersonnelAjout;

import java.text.ParseException;



import java.util.Date;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.VBox;

import javafx.scene.control.TableView;

import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;


/**
 *
 * @author dorsa
 */
public class interface_personnel extends Application {
  @Override
    public void start(Stage primaryStage) throws ParseException {
        //Employe employe1 = new Employe(123,"Ben ahmed","Mohamed", "Ariana",new Date(12/03/2015),22222222,"directeur");
        Employe employe1 = new Employe(123, "Ben ahmed", "Mohamed", "Ariana", new Date(101, 2, 12), "22222222", "directeur");
        Employe employe2 = new Employe(124, "Ben Ali", "ALI", "Tunis", new Date(100, 11, 6), "22222222", "Enseignant");

        Employe employe3 = new Employe(125, "Ben Mohamed", "Sonia", "sokra", new Date(90, 5, 18), "33333333", "Enseignant");

        Employe employe4 = new Employe(126, "Ben ahmed", "Omar", "ariana", new Date(99, 5, 12), "44444444", "Enseignant");

        
        
        TableView<Employe> tableViewPersonnel = new TableView<>(); 
        tableViewPersonnel.setMaxWidth(900);
        
        
     TableColumn<Employe, Integer> idCol = new TableColumn<>("ID");
    idCol.setCellValueFactory(data -> {
    int id = data.getValue().getIdPersonne();
    return id != 0 ? new SimpleObjectProperty<>(id) : new SimpleObjectProperty<>(null);
});


     TableColumn<Employe, String> nomCol = new TableColumn<>("Nom");
nomCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));


TableColumn<Employe, String> prenomCol = new TableColumn<>("Prénom");
prenomCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPrenom()));


TableColumn<Employe, String> adresseCol = new TableColumn<>("Adresse");
adresseCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAdresse()));




TableColumn<Employe, String> dateNaissanceCol = new TableColumn<>("Date de Naissance");
dateNaissanceCol.setCellValueFactory(data -> {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String formattedDate = dateFormat.format(data.getValue().getDateNaissance());
    return new SimpleStringProperty(formattedDate);
});

/*
TableColumn<Employe, Integer> telCol = new TableColumn<>("Téléphone");
telCol.setCellValueFactory(data -> {
    String tel= data.getValue().getTel();
    return tel != 0 ? new SimpleObjectProperty<>(tel) : new SimpleObjectProperty<>(null);
});*/
TableColumn<Employe, String> telCol = new TableColumn<>("TEl");
telCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTel()));


TableColumn<Employe, String> posteCol = new TableColumn<>("poste");
posteCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPoste()));





 tableViewPersonnel.getColumns().addAll(idCol, nomCol, prenomCol, adresseCol,
                                   dateNaissanceCol, telCol,posteCol);
 
 
 ObservableList<Employe> employes = FXCollections.observableArrayList(employe1, employe2,employe3,employe4);
        tableViewPersonnel.setItems(employes);
 //*****************************************
 BorderPane rootB = new BorderPane();
 
 TextField nomField = new TextField();
    nomField.setPromptText("Nom");
    nomField.getStyleClass().add("custom-text-field");

    TextField prenomField = new TextField();
    prenomField.setPromptText("Prénom");
    prenomField.getStyleClass().add("custom-text-field");

    
    TextField adresseField = new TextField();
    adresseField.setPromptText("adresse");
    adresseField.getStyleClass().add("custom-text-field");
    // Ajoutez d'autres champs nécessaires (adresse, date de naissance, email parent, téléphone, alerte)
   
    DatePicker dateNaissancePicker = new DatePicker();
    dateNaissancePicker.setPromptText("Date de Naissance");
    dateNaissancePicker.getStyleClass().add("custom-text-field");
    

    TextField telField = new TextField();
    telField.setPromptText("Téléphone ");
    telField.getStyleClass().add("custom-text-field");


     TextField posteField = new TextField();
    posteField.setPromptText("poste");
    posteField.getStyleClass().add("custom-text-field");

    
    Label labelSexe = new Label("Sexe");
    ChoiceBox<String> sexeChoiceBox = new ChoiceBox<>();
sexeChoiceBox.getItems().addAll("Homme", "Femme");
    
     Text texteGras = new Text("Gérer les données des Employes ou saisir des nouveaux personnels");
     texteGras.getStyleClass().add("label-custom");
    texteGras.setStyle("-fx-font-weight: bold;"); // Appliquer le style en gras

   
   
    
    
    VBox formulaireLayout = new VBox(10); // Espacement entre les éléments
    formulaireLayout.setPadding(new Insets(10));
    
    formulaireLayout.setMaxWidth(600);
    
    
    formulaireLayout.getChildren().addAll(
        nomField, prenomField, adresseField,
        dateNaissancePicker, telField, posteField,labelSexe,sexeChoiceBox
        
    );
 
 
 Button inscriptionButton = new Button("Ajouter ");
 inscriptionButton.getStyleClass().add("button-inscription");
 
    Button modifierButton = new Button("Modifier");
    modifierButton.getStyleClass().add("button-modifier");
    
    Button RetourButton = new Button("Quitter");
    RetourButton.getStyleClass().add("button-mise-a-jour");
    
    HBox boutonsLayout = new HBox(10); // Espacement horizontal entre les boutons
    boutonsLayout.getStyleClass().add("buttons-container");
    
    boutonsLayout.getStyleClass().add("buttons-container");
    boutonsLayout.getChildren().addAll(inscriptionButton, modifierButton,RetourButton);
 
 
 //***************
 inscriptionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ControllerPersonnelAjout controller = new ControllerPersonnelAjout();
                
                try {
                    controller.handleInscriptionButton(
                            nomField, prenomField, adresseField,
                            dateNaissancePicker,
                            telField, posteField,sexeChoiceBox,
                             employes ,tableViewPersonnel
                    );
                } catch (ParseException ex) {
                    Logger.getLogger(interface_personnel.class.getName()).log(Level.SEVERE, null, ex);
                }       }
        });
//********************************************
 /*
 // Instanciation du contrôleur
 
  int idRecherche = 126; // Remplacez cela par l'ID que vous souhaitez sélectionner

        // Parcourir la liste des employés pour trouver celui avec l'ID spécifié
        for (Employe employe : employes) {
            if (employe.getIdPersonne() == idRecherche) {
                // Sélectionner l'employé dans la TableView
                tableViewPersonnel.getSelectionModel().select(employe);
                // Sortir de la boucle une fois que l'employé est trouvé et sélectionné
                break;
            }
        }
        
       
        ControllerPersonnelModifier controllerModifier = new ControllerPersonnelModifier(
                 nomField,
        prenomField,
        adresseField,
     dateNaissancePicker,
       telField,
     posteField,
       sexeChoiceBox,
       employes,
         tableViewPersonnel
                 
               
        );
        
       
  modifierButton.setOnAction(event -> {
    controllerModifier.modifierEmploye();
});
        

 */
 
 //*******
 
        
        VBox root = new VBox(tableViewPersonnel,texteGras,formulaireLayout,boutonsLayout);
        root.getStyleClass().add("root-container");
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        
         scene.getStylesheets().add("file:///C:/Users/dorsa/Documents/NetBeansProjects/Notre_Application/src/View/MyStyle.css");
 // Appliquer les styles CSS
        
        primaryStage.setTitle("A propos des Personnels");
        primaryStage.show();
    }
    
    
    public static void main(String[] args) {
        Application.launch(interface_personnel.class, args);
    }

    }
    


