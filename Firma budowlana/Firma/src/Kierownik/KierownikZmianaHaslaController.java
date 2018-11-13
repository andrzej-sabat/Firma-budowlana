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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author student
 */
public class KierownikZmianaHaslaController implements Initializable {

   @FXML TextField tfStareHaslo;
    @FXML TextField tfNoweHaslo;
    @FXML TextField tfNoweHaslo2;
    @FXML Button bPotwierdz;
    @FXML Button bAnuluj;
    
    @FXML public void bPotwierdz(ActionEvent event) {
        try {
            Connection connection = firma.Oracle.getConnection();
            CallableStatement cstmt = connection.prepareCall("{call ZMIANA_HASLA_KIEROWNIK(?, ?)}");
            cstmt.setInt(1, Login.KierownikLoginController.k.getId());
            cstmt.setString(2, tfNoweHaslo.getText());
            if(tfNoweHaslo.getText().equals(tfNoweHaslo2.getText()) && tfStareHaslo.getText().equals(Login.KierownikLoginController.k.getHaslo())) {
                cstmt.execute();
                
                connection.close();
                
                Parent root = FXMLLoader.load(getClass().getResource("/Kierownik/Kierownik.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
                
            connection.close();
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
        // TODO
    }    
   
}
