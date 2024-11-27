package View;
import Model.Employe;
import Model.Enfant;
import controller.ControllerEnfant;
import controller.ControllerPersonnelAjout;
//import Controller.ControllerPersonnelModifier;
import View.interface_personnel;
import View.interface_enfant;
import java.io.IOException;
import static java.lang.constant.ConstantDescs.NULL;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.text.View;


public class InterfaceGeneraleController implements Initializable {

    @FXML
    private Button Emploi;
    @FXML
    private Button Enfant;
    @FXML
    private Button NosServices;
    @FXML
    private Button Personnel;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView imgG;
    @FXML
    private ImageView imgE;
    @FXML
    private ImageView imgA;
    @FXML
    private ImageView imgP;
    @FXML
    private ImageView imgS;
    @FXML
    private Button NosActivites;


    private void afficherMessageErreur(String message) {
  
        System.err.println(message);
    }  

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        chargerImages();
    }
 
    private void chargerImages() {
    chargerImageDansImageView("/Images/image1.jpg", img1);
    chargerImageDansImageView("/Images/image2.jpg", img2);
    chargerImageDansImageView("/Images/imageG.jpg", imgG);
    chargerImageDansImageView("/Images/emploi.jpg", imgE);
    chargerImageDansImageView("/Images/activite.jpg", imgA);
    chargerImageDansImageView("/Images/personne.png", imgP);
    chargerImageDansImageView("/Images/service.png", imgS);
    }
    private void chargerImageDansImageView(String cheminImage, ImageView imageView) {
        try {
            Image image = new Image(getClass().getResourceAsStream(cheminImage));
            imageView.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
            afficherMessageErreur("Erreur lors du chargement de l'image : " + e.getMessage());
        }
    }

    @FXML
    private void Emploi(ActionEvent event) {
        loadWindow("Emploi.fxml", Emploi);
    }


    @FXML
    private void NosServices(ActionEvent event) {
        loadWindow("Service.fxml", NosServices);
    }


    private void loadWindow(String resource, Node node) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
            Parent root = loader.load();

            Scene scene = new Scene(root, 913, 676);
            Stage primaryStage = (Stage) node.getScene().getWindow();
            primaryStage.setTitle("Centre de Loisir d'enfants HAPPY KIDS");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
            // Gérer les erreurs de chargement de l'interface
        }
    }
    
    @FXML
    private void Personnel(ActionEvent event) {
        
         Employe employe1 = null;
          try {
              employe1 = new Employe(123, "Ben ahmed", "Mohamed", "Ariana", new Date(101, 2, 12), "22222222", "directeur");
          } catch (ParseException ex) {
              Logger.getLogger(InterfaceGeneraleController.class.getName()).log(Level.SEVERE, null, ex);
          }
        Employe employe2 = null;
          try {
              employe2 = new Employe(124, "Ben Ali", "ALI", "Tunis", new Date(100, 11, 6), "22222222", "Enseignant");
          } catch (ParseException ex) {
              Logger.getLogger(InterfaceGeneraleController.class.getName()).log(Level.SEVERE, null, ex);
          }

        Employe employe3 = null;
          try {
              employe3 = new Employe(125, "Ben Mohamed", "Sonia", "sokra", new Date(90, 5, 18), "33333333", "Enseignant");
          } catch (ParseException ex) {
              Logger.getLogger(InterfaceGeneraleController.class.getName()).log(Level.SEVERE, null, ex);
          }

        Employe employe4 = null;
          try {
              employe4 = new Employe(126, "Ben ahmed", "Omar", "ariana", new Date(99, 5, 12), "44444444", "Enseignant");
          } catch (ParseException ex) {
              Logger.getLogger(InterfaceGeneraleController.class.getName()).log(Level.SEVERE, null, ex);
          }

        
        
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


TableColumn<Employe, String> telCol = new TableColumn<>("Téléphone");
telCol.setCellValueFactory(data -> {
    String tel = data.getValue().getTel();
    return new SimpleStringProperty(tel);
});


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
 
 
 //*******
 
        
        VBox root = new VBox(tableViewPersonnel,texteGras,formulaireLayout,boutonsLayout);
        root.getStyleClass().add("root-container");
        Scene scene = new Scene(root, 400, 300);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        
         scene.getStylesheets().add("file:///C:/Users/dorsa/Documents/NetBeansProjects/Notre_Application/src/View/MyStyle.css");
 // Appliquer les styles CSS
        
        primaryStage.setTitle("A propos des Personnels");
        primaryStage.show();
    }
    
    public static void main1(String[] args) {
        
        Application.launch(interface_personnel.class, args);
    }
    

    
    




   @FXML
   private void Enfant(ActionEvent event) {
        

Enfant enfant1 = null;
          try {
              enfant1 = new Enfant(123, "Ben ahmed", "Mohamed", "Ariana", new Date(115, 2, 12), "parent123@gmail.com", "22222222", "alergique");
          } catch (ParseException ex) {
              Logger.getLogger(InterfaceGeneraleController.class.getName()).log(Level.SEVERE, null, ex);
          }
         Enfant enfant2 = null;
          try {
              enfant2 = new Enfant(124, "Ben Ali", "Sirin", "Tunis", new Date(117, 5, 12), "parent124@gmail.com", "22222222", "");
          } catch (ParseException ex) {
              Logger.getLogger(InterfaceGeneraleController.class.getName()).log(Level.SEVERE, null, ex);
          }
        Enfant enfant3 = null;
          try {
              enfant3 = new Enfant(125, "Ben Mohamed", "Eline", "sokra", new Date(118, 5, 18), "parent125@gmail.com", "33333333", "Probleme psychologique");
          } catch (ParseException ex) {
              Logger.getLogger(InterfaceGeneraleController.class.getName()).log(Level.SEVERE, null, ex);
          }
        Enfant enfant4 = null;
          try {
              enfant4 = new Enfant(126, "Ben ahmed", "joud", "ariana", new Date(116, 5, 12), "parent126@gmail.com", "44444444", "");
          } catch (ParseException ex) {
              Logger.getLogger(InterfaceGeneraleController.class.getName()).log(Level.SEVERE, null, ex);
          }

        
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
 
 //**********************
        rootB.setCenter(formulaireLayout); 
        VBox root = new VBox(tableView,texteGras,formulaireLayout,boutonsLayout);
         root.getStyleClass().add("root-container");
        Scene scene = new Scene(root, 400, 300);
        
      
         Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        
       scene.getStylesheets().add("file:///C:/Users/dorsa/Documents/NetBeansProjects/Notre_Application/src/View/MyStyle.css");
 // Appliquer les styles CSS
        primaryStage.setTitle("Apropos des Enfants");
        primaryStage.show();
    }
    
    
     public static void main2(String[] args) {
        Application.launch(interface_enfant.class, args);
    
       
    }

    @FXML
    private void NosActivites(ActionEvent event) {
    }     
}