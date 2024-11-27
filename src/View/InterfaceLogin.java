/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import View.InterfaceLoginController;
import java.io.IOException;
import java.lang.System.Logger.Level;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


/**
 *
 * @author dorsa
 */
public class InterfaceLogin extends Application {

   
    
      @Override
    public void start(Stage primaryStage)  {
          try {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceLogin.fxml"));
              Parent root = loader.load();
              
              Scene scene = new Scene(root, 913, 676); // Adjust the size as needed
              primaryStage.setTitle("Centre de Loisir d'enfants HAPPY KIDS");
              primaryStage.setScene(scene);
              primaryStage.show();
          } catch (IOException ex) {
              Logger.getLogger(InterfaceLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
    }

    public static void main(String[] args) {
        launch(args);
    }

    
}