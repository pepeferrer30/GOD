/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package repasoglobal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button buttonFile1;
    @FXML
    private Button buttonFile2;
    @FXML
    private Button buttonXML;
    @FXML
    private Button buttonMYSQL;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void llevaFile1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Examen1.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void llevalecturaFile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Examen2.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void llavaXML(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Examen3.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
    

    @FXML
    private void llevaMSQL(ActionEvent event) {

    }
    
}
