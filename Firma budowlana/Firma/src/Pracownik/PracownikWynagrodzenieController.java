/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pracownik;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author student
 */
public class PracownikWynagrodzenieController implements Initializable {

    @FXML Label lWynagrodzenie;
    @FXML Label lPremia;
    @FXML Label lWynagrodzenieExtra;
    
    @FXML Button bPowrot;
    
    @FXML public void bPowrot(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Pracownik/Pracownik.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lWynagrodzenie.setText(Login.LoginController.p.getWynagrodzenie() + "PLN");
        lPremia.setText(Login.LoginController.p.getPremia()+ "PLN");
        lWynagrodzenieExtra.setText(Login.LoginController.p.getWynagrodzenieExtra() + "PLN");
    }    
    
    
}
