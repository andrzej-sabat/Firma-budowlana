/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pracownik;

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
public class PracownikController implements Initializable {

   
    
        @FXML Label labelImie;
        @FXML Label labelDzial;
        
        @FXML Button bSprawdzWynagrodzenie;
        @FXML Button bSprawdzUrlop;
        @FXML Button bSprawdzGodziny;
        @FXML Button bZmienHaslo;
        @FXML Button bWyloguj;
        @FXML Button bWyjscie;
    
    
    private void menu(String s, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(s));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML public void bSprawdzWynagrodzenie(ActionEvent event) throws IOException {
        menu("/Pracownik/PracownikWynagrodzenie.fxml", event);
    }
    
    @FXML public void bSprawdzUrlop(ActionEvent event) throws IOException {
        menu("/Pracownik/PracownikUrlop.fxml", event);
    }
    
    @FXML public void bSprawdzGodziny(ActionEvent event) throws IOException {
        menu("/Pracownik/PracownikGodziny.fxml", event);
    }
    
    @FXML public void bZmienHaslo(ActionEvent event) throws IOException {
        menu("/Pracownik/PracownikZmianaHasla.fxml", event);
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM DZIAL");
            while(rs.next()) {
                if(Login.LoginController.p.getDzialID() == rs.getInt(1)) {
                    labelDzial.setText("Dział: " + rs.getString(2));
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        labelImie.setText(Login.LoginController.p.getImie() + " " + Login.LoginController.p.getNazwisko());
    }    
   
    
}
