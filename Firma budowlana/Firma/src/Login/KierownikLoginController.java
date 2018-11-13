/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

 import firma.Kierownik;
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
public class KierownikLoginController implements Initializable {

  



        @FXML TextField tfLogin;
        @FXML PasswordField tfHaslo;
        @FXML Button buttonLogin;
        @FXML Button buttonAnuluj;
    
       
        public static Kierownik k;
        public static boolean isKierownik = false;
        Connection connection;
    
    
    
    @FXML public void bLogin(ActionEvent event) {
        String login = tfLogin.getText();
        String haslo = tfHaslo.getText();
        
        try {
            Connection connection = firma.Oracle.getConnection();
            

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM KIEROWNICY");
            while(rs.next()) {
                if(login.equals(rs.getString(4)) && haslo.equals(rs.getString(5))) {
                    k.setId(rs.getInt(1));
                    k.setImie(rs.getString(2));
                    k.setNazwisko(rs.getString(3));
                    k.setLogin(rs.getString(4));
                    k.setHaslo(rs.getString(5));
                    

                    isKierownik = true;
                    break;
                } else {
                    isKierownik = false;
                }
            }

            if(isKierownik) {
                

                Parent root = FXMLLoader.load(getClass().getResource("/Kierownik/Kierownik.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Kierownik : Bład logoawani");
            }
                    
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML public void bAnuluj(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Login/Login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        k = new Kierownik();
        isKierownik = false;
    }    
}

