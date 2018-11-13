/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kierownik;

import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author student
 */
public class KierownikDodajGodziny3Controller implements Initializable {

    @FXML Label lImie;
    @FXML Label lDzial;
    @FXML TextField tfGodziny;
    @FXML DatePicker datapicker;
    
    
    @FXML Button bTyl;
    @FXML Button bPotwierdz;
    @FXML Button bAnuluj;
   
    @FXML public void bTyl(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Kierownik/KierownikDodajGodziny2.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML public void bPotwierdz(ActionEvent event) {
        try {
            Connection connection = firma.Oracle.getConnection();
            CallableStatement cstmt = connection.prepareCall("{call DODAJ_GODZINY(?, ?, ?, ?)}");
            java.util.Date date = 
            java.util.Date.from(datapicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            cstmt.setDate(1,sqlDate );
            cstmt.setString(2, tfGodziny.getText());
            cstmt.setInt(3, KierownikDodajGodziny2Controller.pracownik.getId());
            cstmt.setInt(4, Login.KierownikLoginController.k.getId());
            
            
            cstmt.execute();
            
            
            connection.close();
            
            Parent root = FXMLLoader.load(getClass().getResource("/Kierownik/Kierownik.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @FXML public void bAnuluj(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Kierownik/Kierownik.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      
        stage.setScene(scene);
        stage.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lImie.setText(KierownikDodajGodziny2Controller.pracownik.getImie() + " " + KierownikDodajGodziny2Controller.pracownik.getNazwisko());
        lDzial.setText(KierownikDodajGodziny1Controller.Dzial);
        
        
    }   
     
    
}
