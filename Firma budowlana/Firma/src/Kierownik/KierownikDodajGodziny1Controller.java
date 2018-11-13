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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author student
 */
public class KierownikDodajGodziny1Controller implements Initializable {

   @FXML ComboBox cbDzial;
        protected static String Dzial;
    
    
    @FXML Button bDalej;
    @FXML Button bAnuluj;
    
    protected static int DzialId;
    
    ObservableList<String> DzialList = FXCollections.observableArrayList();;
    
    
    @FXML public void bDalej(ActionEvent event) {
        Dzial = (String) cbDzial.getSelectionModel().getSelectedItem();
        
        
        try {
            Connection connection = firma.Oracle.getConnection();
            
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_dzialu FROM DZIAL WHERE Nazwa = '" + Dzial + "'");
            rs.next(); 
            DzialId = rs.getInt(1);
            
            
            
            
            Parent root = FXMLLoader.load(getClass().getResource("/Kierownik/KierownikDodajGodziny2.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
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
        try {
            Connection connection = firma.Oracle.getConnection();
            
           
            Statement stmt1 = connection.createStatement();
            
            ResultSet rs1 = stmt1.executeQuery("SELECT NAZWA FROM DZIAL GROUP BY NAZWA ORDER BY NAZWA ASC");
            
            
            while(rs1.next()) {
                DzialList.add(rs1.getString(1));
            }
            
            
                
            cbDzial.setItems(DzialList);
            
            
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
