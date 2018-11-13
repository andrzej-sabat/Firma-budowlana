/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import firma.Pracownik;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author student
 */
public class LoginController implements Initializable {




    
   
    
        @FXML TextField tfLogin;
        @FXML PasswordField tfHaslo;
        @FXML Button bPracownik;
        @FXML Button bKierownik;
        @FXML Button bAdministrator;
        @FXML Button bWyjscie;
    
        
        
        public static Pracownik p; 
        public static boolean isLoggedIn = false;
        Connection connection;
    
    
    
    @FXML public void buttonPracpwnikLoginClick(ActionEvent event) {
        p.setLogin(tfLogin.getText());
        p.setHaslo(tfHaslo.getText());
        
        try {
            Connection connection = firma.Oracle.getConnection();

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PRACOWNICY");
            while(rs.next()) {
                if(p.getLogin().equals(rs.getString(8)) && p.getHaslo().equals(rs.getString(9))) {
                    isLoggedIn = true;
                    
                    p.setId(rs.getInt(1));
                    p.setImie(rs.getString(2));
                    p.setNazwisko(rs.getString(3));
                    p.setStanowisko(rs.getString(4));
                    p.setWynagrodzenie(rs.getInt(5));
                    p.setPremia(rs.getInt(6));
                    p.setDzialID(rs.getInt(7));
                    p.setLogin(rs.getString(8));
                    p.setHaslo(rs.getString(9));

                    break;
                } else {
                    isLoggedIn = false;
                }
            }

            if(isLoggedIn) {
                Parent root = FXMLLoader.load(getClass().getResource("/Pracownik/Pracownik.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setTitle("Pracownik");
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Login: błąd logowania");
            }
                     
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML public void buttonKierownikLoginClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Login/KierownikLogin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Kierownik");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML public void buttonAdminLoginClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Login/AdminLogin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Administrator");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML public void buttonWyjscieClick(ActionEvent event) {
        javafx.application.Platform.exit();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p = new Pracownik();
    }    
    
}


