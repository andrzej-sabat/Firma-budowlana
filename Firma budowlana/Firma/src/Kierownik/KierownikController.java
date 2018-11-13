/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kierownik;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author student
 */
public class KierownikController implements Initializable {

  
        @FXML Label labelImie;
        
        @FXML Button bDodajGodziny;
        @FXML Button bZmienHaslo;
        @FXML Button bWyloguj;
        @FXML Button bWyjdz;
    
    
    private void menu(String s, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(s));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    @FXML public void bDodajGodziny(ActionEvent event) throws IOException {
        menu("/Kierownik/KierownikDodajGodziny1.fxml", event);
    }
    
    @FXML public void bZmienHaslo(ActionEvent event) throws IOException {
        menu("/Kierownik/KierownikZmianaHasla.fxml", event);
    }
    
    
    
    @FXML public void bWyloguj(ActionEvent event) throws IOException {
        menu("/Login/Login.fxml", event);
    }
    
    @FXML public void bWyjdz(ActionEvent event) {
        javafx.application.Platform.exit();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection connection = firma.Oracle.getConnection();
            Statement stmt = connection.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        labelImie.setText(Login.KierownikLoginController.k.getImie() + " " + Login.KierownikLoginController.k.getNazwisko());
    }     
    
    
}
