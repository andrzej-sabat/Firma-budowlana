/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kierownik;

import firma.Pracownik;
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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author student
 */
public class KierownikDodajGodziny2Controller implements Initializable {

    @FXML ListView lvPracownicy;
    @FXML Button bTyl;
    @FXML Button bDalej;
    @FXML Button bAnuluj;
            
    ObservableList<Pracownik> pracownicy = FXCollections.observableArrayList();
    
    protected static Pracownik pracownik;
    
    @FXML public void bTyl(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Kierownik/KierownikDodajGodziny1.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML public void bDalej(ActionEvent event) throws IOException {
        pracownik = (Pracownik) lvPracownicy.getSelectionModel().getSelectedItem();
        
        
        Parent root = FXMLLoader.load(getClass().getResource("/Kierownik/KierownikDodajGodziny3.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        stage.setScene(scene);
        stage.show();
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
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PRACOWNICY WHERE id_dzialu = '" + KierownikDodajGodziny1Controller.DzialId + "'");
            
            while(rs.next()) {
                Pracownik p = new Pracownik(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9));
                pracownicy.add(p);
            }
            
            lvPracownicy.setItems(pracownicy);
            
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
    
    
}
