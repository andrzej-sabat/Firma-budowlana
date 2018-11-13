/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

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
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author student
 */
public class AdminLoginController implements Initializable {

    
        
        @FXML TextField tfLogin;
        @FXML PasswordField tfHaslo;
        @FXML Button bLoginAdmin;
        @FXML Button bAnuluj;
    
       
        public static String login;
        public static String haslo;
        public static boolean isAdmin = false;
    
    
    
    @FXML public void buttonLoginAdmin(ActionEvent event) {
        login = tfLogin.getText();
        haslo = tfHaslo.getText();
        
        try {
            Connection connection = firma.Oracle.getConnection();
           

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ADMINISTRATORZY");
            while(rs.next()) {
                if(login.equals(rs.getString(1)) && haslo.equals(rs.getString(2))) {
                    isAdmin = true;
                    break;
                } else {
                    isAdmin = false;
                }
            }

            if(isAdmin) {
                System.out.println("Admin: Zalogowany");

                Parent root = FXMLLoader.load(getClass().getResource("/Admin/Admin.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Admin: Błąd logowania");
            }
                    
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML public void buttonAnuluj(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Login/Login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        isAdmin = false;
    }   
    
    
}
