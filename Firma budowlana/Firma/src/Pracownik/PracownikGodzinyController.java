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
public class PracownikGodzinyController implements Initializable {

    @FXML ListView lvGodziny;
    @FXML Button bPowrot;
    
    ObservableList<String> pracownik = FXCollections.observableArrayList();
    
    @FXML public void bPowrot(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Pracownik/Pracownik.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(Login.LoginController.p.getId());
        try {
            Connection connection = firma.Oracle.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT P.IMIE, P.NAZWISKO, C.LICZBA_GODZIN, C.DATA  FROM PRACOWNICY P, CZAS_PRACY C  WHERE P.id_pracownika = C.id_pracownika AND C.id_pracownika = '" + Login.LoginController.p.getId()+"'");
            
            while(rs.next()) {
                String p = rs.getString(1) + " " + rs.getString(2) + ", liczba godzin: " + rs.getInt(3) + ", data: " + rs.getDate(4);
                pracownik.add(p);
            }
            
            lvGodziny.setItems(pracownik);
            
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
    
}
