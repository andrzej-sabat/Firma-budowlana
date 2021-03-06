/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import firma.Pracownik;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class AdminUsunPracownikaController implements Initializable {

    
        @FXML ListView lvPracownicy;
        @FXML Button bUsun;
        @FXML Button bAnuluj;
        
        
        ObservableList<Pracownik> pracownicy = FXCollections.observableArrayList();
    
    
        
    @FXML public void bUsun(ActionEvent event) {
        try {
            Connection connection = firma.Oracle.getConnection();
            Pracownik u = (Pracownik) lvPracownicy.getSelectionModel().getSelectedItem();
            
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Pracownicy WHERE id_pracownika = ?");
            pstmt.setInt(1, u.getId());
            pstmt.executeUpdate();
            
            
            Parent root = FXMLLoader.load(getClass().getResource("/Admin/AdminUsunPracownika.fxml"));
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
        Parent root = FXMLLoader.load(getClass().getResource("/Admin/Admin.fxml"));
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM Pracownicy");
            while(rs.next()) {
                Pracownik u = new Pracownik(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9));
                pracownicy.add(u);
            }
            
            lvPracownicy.setItems(pracownicy);
            
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    
       
    
}
