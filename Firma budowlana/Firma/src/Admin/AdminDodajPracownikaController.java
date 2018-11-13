/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author student
 */
public class AdminDodajPracownikaController implements Initializable {

   
        @FXML TextField tfImie;
        @FXML TextField tfNazwisko;
        @FXML TextField tfStanowisko;
        @FXML TextField tfWynagrodzenie;
        @FXML ComboBox cbDzial;
        @FXML TextField tfLogin;
        @FXML TextField tfHaslo;
        
        @FXML Button bDodajPracownika;
        @FXML Button bAnuluj;
        
       
        ObservableList<String> dzialLista = FXCollections.observableArrayList();;
        
    
    
        
    @FXML public void bDodajPracownika(ActionEvent event) {
            try {
                Connection connection = firma.Oracle.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id_dzialu FROM DZIAL WHERE NAZWA = '" + cbDzial.getSelectionModel().getSelectedItem()+ "'" );
                rs.next(); 
                int prac = rs.getInt(1);
                
                CallableStatement cstmt = connection.prepareCall("{call DODAJ_PRACOWNIKA(?, ?, ?, ?, ?,?,?,?)}");
                cstmt.setString(1,tfImie.getText());
                cstmt.setString(2,tfNazwisko.getText());
                cstmt.setString(3,tfStanowisko.getText());
                cstmt.setString(4,tfWynagrodzenie.getText());
                cstmt.setInt(5,0);
                cstmt.setInt(6,prac);
                cstmt.setString(7,tfLogin.getText());
                cstmt.setString(8,tfHaslo.getText());
                cstmt.execute();

                
                connection.close();
                
                Parent root = FXMLLoader.load(getClass().getResource("/Admin/AdminDodajPracownika.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
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
            
           
            Statement stmt1 = connection.createStatement();
            ResultSet rs1 = stmt1.executeQuery("SELECT nazwa FROM DZIAL GROUP BY nazwa ORDER BY NAZWA ASC");
            
            
            while(rs1.next()) {
                dzialLista.add(rs1.getString(1));
            }
            
            
                
            cbDzial.setItems(dzialLista);
            
            
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
   
}
