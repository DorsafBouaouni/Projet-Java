/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Employe;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author dorsa
 */
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ChoiceBox;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javafx.collections.ObservableList;
/*
public class ControllerPersonnelModifier {
private TextField nomField;
    private TextField prenomField;
     private TextField adresseField;
        private    DatePicker dateNaissancePicker;
           private  TextField telField;
            private TextField posteField;
           private  ChoiceBox<String> sexeChoiceBox;
           

    private TableView<Employe> tableViewPersonnel;
    private ObservableList<Employe> employesList;

    public ControllerPersonnelModifier(
            TextField nomField,
            TextField prenomField,
            TextField adresseField,
            DatePicker dateNaissancePicker,
            TextField telField,
            TextField posteField,
            ChoiceBox<String> sexeChoiceBox,
            List<Employe> employes,
            TableView<Employe> tableViewPersonnel
    ) {
        // Initialisation de vos champs existants
    }

   public void modifierEmploye() {
        Employe employeSelectionne = tableViewPersonnel.getSelectionModel().getSelectedItem();
        if (employeSelectionne != null) {
          //  int idRecherche = employeSelectionne.getIdPersonne();
            int idRecherche=126;
            // Utilisation de selectEmployeeById pour récupérer l'employé sélectionné
            Employe employeAModifier = selectEmployeeById(idRecherche);

            // Modification des données de l'employé
            if (employeAModifier != null) {
                employeAModifier.setNom(nomField.getText());
                employeAModifier.setPrenom(prenomField.getText());
                employeAModifier.setAdresse(adresseField.getText());

                // Mise à jour de la date de naissance
                LocalDate dateNaissance = dateNaissancePicker.getValue();
                if (dateNaissance != null) {
                    employeAModifier.setDateNaissance(Date.from(dateNaissance.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                }

                // Mise à jour du numéro de téléphone
                String telText = telField.getText();
                if (!telText.isEmpty()) {
                    try {
                        int tel = Integer.parseInt(telText);
                        employeAModifier.setTel(tel);
                    } catch (NumberFormatException e) {
                        System.out.println("Le numéro de téléphone n'est pas un nombre valide !");
                        // Gérer l'erreur de conversion ici
                    }
                }

                employeAModifier.setPoste(posteField.getText());
                
                tableViewPersonnel.refresh();
            }
        }
    }

    // Méthode pour sélectionner un employé par son ID dans la TableView
    public Employe selectEmployeeById(int idRecherche) {
        Iterable<Employe> employes = null;
        for (Employe employe : employes) {
            if (employe.getIdPersonne() == idRecherche) {
                tableViewPersonnel.getSelectionModel().select(employe);
                break;
            }
        }
     return null;
    }
}
*/
/*
public class ControllerPersonnelModifier {
    private TextField nomField;
    private TextField prenomField;
     private TextField adresseField;
        private    DatePicker dateNaissancePicker;
           private  TextField telField;
            private TextField posteField;
           private  ChoiceBox<String> sexeChoiceBox;
           

    private TableView<Employe> tableViewPersonnel;
    private ObservableList<Employe> employesList;

    private List<Employe> employes;

    public ControllerPersonnelModifier(
            TextField nomField,
            TextField prenomField,
            TextField adresseField,
            DatePicker dateNaissancePicker,
            TextField telField,
            TextField posteField,
            ChoiceBox<String> sexeChoiceBox,
            ObservableList<Employe> employes,
            TableView<Employe> tableViewPersonnel
           
    ) {
        // Initialisation de vos champs existants...
        this.employes = employes; // Initialisation de la liste des employés
    }

    public void modifierEmploye() {
        Employe employeSelectionne = tableViewPersonnel.getSelectionModel().getSelectedItem();
        if (employeSelectionne != null) {
            int idRecherche = employeSelectionne.getIdPersonne();

            Employe employeAModifier = selectEmployeeById(idRecherche);

            if (employeAModifier != null) {
                employeAModifier.setNom(nomField.getText());
                employeAModifier.setPrenom(prenomField.getText());
                employeAModifier.setAdresse(adresseField.getText());

                LocalDate dateNaissance = dateNaissancePicker.getValue();
                if (dateNaissance != null) {
                    employeAModifier.setDateNaissance(Date.from(dateNaissance.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                }

                String telText = telField.getText();
                if (!telText.isEmpty()) {
                    try {
                        int tel = Integer.parseInt(telText);
                        employeAModifier.setTel(tel);
                    } catch (NumberFormatException e) {
                        System.out.println("Le numéro de téléphone n'est pas un nombre valide !");
                        // Gérer l'erreur de conversion ici
                    }
                }

                employeAModifier.setPoste(posteField.getText());

                tableViewPersonnel.refresh();
            }
        }
    }

    public Employe selectEmployeeById(int idRecherche) {
        for (Employe employe : employes) {
            if (employe.getIdPersonne() == idRecherche) {
                tableViewPersonnel.getSelectionModel().select(employe);
                return employe;
            }
        }
        return null;
    }
}
*/