/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dorsa
 */
public class InterfaceLoginController implements Initializable {

    @FXML
    private Button btn;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void actionLogin(ActionEvent event)  {
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
}
