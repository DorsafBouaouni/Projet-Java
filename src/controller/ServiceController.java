/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Model.Alimentaire;
import Model.Employe;
import Model.Evenement;
import Model.Voiture;
import View.InterfaceLoginController;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.util.StringConverter;


/**
 * FXML Controller class
 *
 * @author jihen
 */
public class ServiceController implements Initializable {

    
    @FXML
    private Button AjouterVoiture;
    @FXML
    private Button supprimerVoiture;
    @FXML
    private Button AjouterMoniteur;
    @FXML
    private Button SupprimerMoniteur;
    @FXML
    private Button AjouterRepas;
    @FXML
    private Button SupprimerRepas;
    @FXML
    private TableView<Employe> TabMoniteurs;
    @FXML
    private ImageView image;
    @FXML
    private TableColumn<Voiture, String> ClMatricule;
    @FXML
    private TableColumn<Voiture, String> ClCouleur;
    @FXML
    private TableColumn<Voiture, String> ClCapacite;
    @FXML
    private TableColumn<Voiture, String> ClMarque;
    @FXML
    private TableColumn<Employe,String> ClNom;
    @FXML
    private TableColumn<Employe,String> ClPrenom;
    @FXML
    private TableColumn<Employe,String> ClCIN;
    @FXML
    private TableColumn<Employe,String> ClTlf;
    @FXML
    private TableColumn<Employe, String> ClMail;
    @FXML
    private TableColumn<Employe, String> ClAdresse;
    @FXML
    private ComboBox<EvenementComboItem> service1;
    @FXML
    private ComboBox<EvenementComboItem> service2;
    @FXML
    private DatePicker DateEvenement;
    @FXML
    private TextField NomEvenement;
    @FXML
    private Button AjouterEvenement;
    @FXML
    private GridPane TabRepas;
    @FXML
    private RowConstraints LigneRepas;
    @FXML
    private Button retour;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Définir les cellValueFactory pour chaque colonne
        ClMatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        ClCouleur.setCellValueFactory(new PropertyValueFactory<>("couleur"));
        ClCapacite.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        ClMarque.setCellValueFactory(new PropertyValueFactory<>("marque"));

         // Créer une liste d'exemple (vous devez remplacer cela par vos propres données)
    ObservableList<Voiture> voitureList;
        voitureList = FXCollections.observableArrayList(
                new Voiture("123", "Rouge", "5", "Toyota"),
                new Voiture("456", "Bleu", "4", "Honda")
                
                );
    // Initialiser la TableView avec les données
    TabVoitures.setItems(voitureList);
    
    
     // Définir les cellValueFactory pour chaque colonne
    ClNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
    ClPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    ClCIN.setCellValueFactory(new PropertyValueFactory<>("cin"));
    ClTlf.setCellValueFactory(new PropertyValueFactory<>("telephone"));
    ClMail.setCellValueFactory(new PropertyValueFactory<>("email"));
    ClAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));

    // Créer une liste d'exemple pour les employés (à remplacer par vos propres données)
    ObservableList<Employe> employeList = null ;
        try {
            employeList = FXCollections.observableArrayList(
                    new Employe("John", "Doe", "123456", "55512346", "john.doe@example.com", "123 Main St"),
                    new Employe("Jane", "Smith", "789012", "55556786", "jane.smith@example.com", "456 Oak St")
            ); 
                    // Initialiser la TableView avec les données
                    } catch (ParseException ex) {
            Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    // Initialiser la TableView avec les données
    TabMoniteurs.setItems(employeList);
       
     // Convertisseur pour afficher les dates dans le DatePicker
        StringConverter<LocalDate> converter = new StringConverter<>() {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            @Override
            public String toString(LocalDate object) {
                if (object != null) {
                    return sdf.format(java.sql.Date.valueOf(object));
                }
                return null;
            }

            @Override
            public LocalDate fromString(String string) {
                try {
                    Date date = sdf.parse(string);
                    return new java.sql.Date(date.getTime()).toLocalDate();
                } catch (Exception e) {
                    return null;
                }
            }
        };

        DateEvenement.setConverter(converter);

        // Personnaliser l'affichage des cellules du ComboBox
        service1.setCellFactory(lv -> new EvenementComboListCell());
        service2.setCellFactory(lv -> new EvenementComboListCell());

        // Action du bouton AjouterEvenement
        AjouterEvenement.setOnAction(event -> AjouterEvenement());
        
        //Repas
         // Initialiser la grille avec des cellules vides
        
            for (int col = 0; col <= JOURS_PAR_SEMAINE; col++) {
                TabRepas.add(new TextField(), col, 1);
            }
    }
    
    @FXML
    private void service1(ActionEvent event) {
    }

    @FXML
    private void service2(ActionEvent event) {
    }


    @FXML
    private void AjouterRepas(ActionEvent event) {
    }

    @FXML
    private void SupprimerRepas(ActionEvent event) {
    }
    
     @FXML
    private TableView<Voiture> TabVoitures;
     
  @FXML
private void AjouterMoniteur(ActionEvent event) {
    // Créer un nouvel objet Moniteur avec les attributs saisis par l'utilisateur
    Employe nouveauMoniteur = new Employe();

    // Saisir l'entrée de l'utilisateur pour le nom
    TextInputDialog nomDialog = new TextInputDialog();
    nomDialog.setTitle("Nom Input");
    nomDialog.setHeaderText("Entrez le nom du moniteur:");
    nomDialog.setContentText("Nom:");
    nomDialog.showAndWait().ifPresent(nouveauMoniteur::setNom);

    // Saisir l'entrée de l'utilisateur pour le prénom
    TextInputDialog prenomDialog = new TextInputDialog();
    prenomDialog.setTitle("Prénom Input");
    prenomDialog.setHeaderText("Entrez le prénom du moniteur:");
    prenomDialog.setContentText("Prénom:");
    prenomDialog.showAndWait().ifPresent(nouveauMoniteur::setPrenom);
    
    
     // Saisir l'entrée de l'utilisateur pour le CIN
    TextInputDialog cinDialog = new TextInputDialog();
    cinDialog.setTitle("CIN Input");
    cinDialog.setHeaderText("Entrez le CIN du moniteur:");
    cinDialog.setContentText("CIN:");
    cinDialog.showAndWait().ifPresent(nouveauMoniteur::setCIN);


    // Saisir l'entrée de l'utilisateur pour le téléphone
    TextInputDialog telDialog = new TextInputDialog();
    telDialog.setTitle("Téléphone Input");
    telDialog.setHeaderText("Entrez le téléphone du moniteur:");
    telDialog.setContentText("Téléphone:");
    telDialog.showAndWait().ifPresent(tel -> {
        // Valider le numéro de téléphone
        nouveauMoniteur.setTel(tel);
    });
    
    // Saisir l'entrée de l'utilisateur pour le mail
    TextInputDialog mailDialog = new TextInputDialog();
    mailDialog.setTitle("Mail Input");
    mailDialog.setHeaderText("Entrez le mail du moniteur:");
    mailDialog.setContentText("Mail:");
    mailDialog.showAndWait().ifPresent(nouveauMoniteur::setMail);
    
    // Saisir l'entrée de l'utilisateur pour l'adresse
    TextInputDialog adresseDialog = new TextInputDialog();
    adresseDialog.setTitle("Adresse Input");
    adresseDialog.setHeaderText("Entrez l'adresse du moniteur:");
    adresseDialog.setContentText("Adresse:");
    adresseDialog.showAndWait().ifPresent(nouveauMoniteur::setAdresse);
    
   
   // Set the attributes of the newVoiture object
    nouveauMoniteur.setNom(nouveauMoniteur.getNom());
    nouveauMoniteur.setPrenom(nouveauMoniteur.getPrenom());
    nouveauMoniteur.setCIN(nouveauMoniteur.getCIN());
    nouveauMoniteur.setTel(nouveauMoniteur.getTel());  
    nouveauMoniteur.setMail(nouveauMoniteur.getMail());
    nouveauMoniteur.setAdresse(nouveauMoniteur.getAdresse());

    // Ajouter le nouveau Moniteur à la TableView
    TabMoniteurs.getItems().add(nouveauMoniteur);
}

@FXML
private void SupprimerMoniteur(ActionEvent event) {
    // Saisir l'entrée de l'utilisateur pour le CIN à supprimer
    TextInputDialog cinDialog = new TextInputDialog();
    cinDialog.setTitle("Supprimer Moniteur");
    cinDialog.setHeaderText("Entrez le CIN du moniteur à supprimer:");
    cinDialog.setContentText("CIN:");

    cinDialog.showAndWait().ifPresent(cin -> {
        // Loop à travers les éléments de la TableView et trouver celui avec le CIN spécifié
        for (Employe moniteur : TabMoniteurs.getItems()) {
            if (moniteur.getCIN().equals(cin)) {
                // Supprimer le moniteur trouvé
                TabMoniteurs.getItems().remove(moniteur);
                break; // Arrêter la boucle une fois que le moniteur est supprimé
            }
        }
    });
}

@FXML
private void AjouterVoiture(ActionEvent event) {
    // Create a new Voiture object with user input attributes
    Voiture newVoiture = new Voiture();

    // Get user input for matricule
    TextInputDialog matriculeDialog = new TextInputDialog();
    matriculeDialog.setTitle("Matricule Input");
    matriculeDialog.setHeaderText("Enter Matricule:");
    matriculeDialog.setContentText("Matricule:");
    matriculeDialog.showAndWait().ifPresent(newVoiture::setMatricule);

    // Get user input for couleur
    TextInputDialog couleurDialog = new TextInputDialog();
    couleurDialog.setTitle("Couleur Input");
    couleurDialog.setHeaderText("Enter Couleur:");
    couleurDialog.setContentText("Couleur:");
    couleurDialog.showAndWait().ifPresent(newVoiture::setCouleur);

    // Get user input for capacite
    TextInputDialog capaciteDialog = new TextInputDialog();
    capaciteDialog.setTitle("Capacite Input");
    capaciteDialog.setHeaderText("Enter Capacite:");
    capaciteDialog.setContentText("Capacite:");
    capaciteDialog.showAndWait().ifPresent(newVoiture::setCapacite);

    // Get user input for marque
    TextInputDialog marqueDialog = new TextInputDialog();
    marqueDialog.setTitle("Marque Input");
    marqueDialog.setHeaderText("Enter Marque:");
    marqueDialog.setContentText("Marque:");
    marqueDialog.showAndWait().ifPresent(newVoiture::setMarque);

     // Set the attributes of the newVoiture object
    newVoiture.setMatricule(newVoiture.getMatricule());
    newVoiture.setCouleur(newVoiture.getCouleur());
    newVoiture.setCapacite(newVoiture.getCapacite());
    newVoiture.setMarque(newVoiture.getMarque());

    // Add the new Voiture to the TableView
    TabVoitures.getItems().add(newVoiture);
}


 
    
    
    @FXML
    private void supprimerVoiture(ActionEvent event) {
    // Get user input for matricule to delete
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Supprimer Voiture");
    dialog.setHeaderText("Entrez le matricule de la voiture à supprimer:");
    dialog.setContentText("Matricule:");

    dialog.showAndWait().ifPresent(matricule -> {
        // Loop through the items in the TableView and find the one with the specified matricule
        for (Voiture voiture : TabVoitures.getItems()) {
            if (voiture.getMatricule().equals(matricule)) {
                // Remove the found voiture
                TabVoitures.getItems().remove(voiture);
                break; // Stop the loop once the voiture is removed
            }
        }
    });
}



//////////////////////////////////////////////////

    
    @FXML
    private void AjouterEvenement() {
    String nomEvenement = NomEvenement.getText();
    LocalDate dateEvenement = DateEvenement.getValue();

    if (nomEvenement != null && dateEvenement != null) {
        LocalDate currentDate = LocalDate.now();
        LocalDate currentDatePlus7Days = currentDate.plusDays(7);

        // Vérifier la condition
        if (dateEvenement.isBefore(currentDatePlus7Days)) {
            ajouterElementComboBox(service1, nomEvenement, dateEvenement);
            retirerElementComboBox(service2, nomEvenement);
        } else {
            ajouterElementComboBox(service2, nomEvenement, dateEvenement);
            retirerElementComboBox(service1, nomEvenement);
        }
    }
}


    private void ajouterElementComboBox(ComboBox<EvenementComboItem> comboBox, String nomEvenement, LocalDate dateEvenement) {
        EvenementComboItem evenementComboItem = new EvenementComboItem(nomEvenement, dateEvenement);
        comboBox.getItems().add(evenementComboItem);
        comboBox.getSelectionModel().select(evenementComboItem);
    }

    private void retirerElementComboBox(ComboBox<EvenementComboItem> comboBox, String nomEvenement) {
        EvenementComboItem evenementComboItemToRemove = null;
        for (EvenementComboItem item : comboBox.getItems()) {
            if (item.getNomEvenement().equals(nomEvenement)) {
                evenementComboItemToRemove = item;
                break;
            }
        }

        if (evenementComboItemToRemove != null) {
            comboBox.getItems().remove(evenementComboItemToRemove);
        }
    }

    @FXML
    private void Retour(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceGenerale.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root, 913, 676); // Adjust the size as needed
            Stage primaryStage=(Stage)((Node)event.getSource()).getScene().getWindow();
            primaryStage.setTitle("Centre de Loisir d'enfants HAPPY KIDS");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceLoginController.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
    // Classe pour représenter les éléments du ComboBox avec un affichage personnalisé
    public static class EvenementComboItem {
        private String nomEvenement;
        private LocalDate dateEvenement;

        public EvenementComboItem(String nomEvenement, LocalDate dateEvenement) {
            this.nomEvenement = nomEvenement;
            this.dateEvenement = dateEvenement;
        }

        public String getNomEvenement() {
            return nomEvenement;
        }

        public LocalDate getDateEvenement() {
            return dateEvenement;
        }

        @Override
        public String toString() {
            // Format du texte affiché dans le ComboBox
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return nomEvenement + "   " + sdf.format(java.sql.Date.valueOf(dateEvenement));
        }
    }

    // Classe pour personnaliser l'affichage des cellules du ComboBox
   public static class EvenementComboListCell extends ListCell<EvenementComboItem> {
    @Override
    protected void updateItem(EvenementComboItem item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
        } else {
            setText(item.toString());
        }
    }
}
  
    ///////////////////////////////////////

//private int colonneChoisie = ; // Initialiser avec la colonne par défaut

private TextField nomRepasTextField;
private static final int JOURS_PAR_SEMAINE = 5; // Nombre de jours par semaine

private void ajouterRepas() {
    String nomRepas = nomRepasTextField.getText();
    
    if (nomRepas != null && !nomRepas.isEmpty()) {
         Label labelRepas = new Label(nomRepas);
            TabRepas.add(labelRepas, JOURS_PAR_SEMAINE , 1);
    }
}
    
 

}