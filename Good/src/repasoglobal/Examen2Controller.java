/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package repasoglobal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 */
public class Examen2Controller implements Initializable {
    
    @FXML
    private TextArea textAreaMostrar;
    @FXML
    private TextField cantVocales;
    @FXML
    private TextField textfieldArchivo;
    @FXML
    private TextField cantVecesPalabra;
    @FXML
    private TextField textFieldPalabraBuscar;
    @FXML
    private Button botonBuscar;
    @FXML
    private TextField textfieldArchivo1;
    @FXML
    private Button CrearNuevo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            int caracterleido = 0;
            int contA = 0;
            int contE = 0;
            int contI = 0;
            int contO = 0;
            int contU = 0;
            char caracter;
            String contenido = "";
            File f = new File(textfieldArchivo.getText());
            FileReader fim = new FileReader(f);
            
            while ((caracterleido = fim.read()) != -1) {
                char c = (char) caracterleido;
                contenido += c;
                if (c == 'a' || c == 'A') {
                    contA++;
                } else if (c == 'e' || c == 'E') {
                    contE++;
                } else if (c == 'i' || c == 'I') {
                    contI++;
                    
                } else if (c == 'o' || c == 'O') {
                    contO++;
                    
                } else if (c == 'u' || c == 'U') {
                    contU++;
                }
                
            }
            textAreaMostrar.setText( contenido);
            cantVocales.setText("Cantidad A: " + contA + "Cantidad E: " + contE+"Cantidad I: "+contI+"Cantidad O: "+contO + "Cantidad U: " + contU  );
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Examen2Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Examen2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    @FXML
    private void BuscarPalabra(ActionEvent event) {
        int contpalabra=0;
        String contCorrejido=textAreaMostrar.getText().replaceAll(",", "");
        contCorrejido= contCorrejido.replaceAll("\\.", "");
        
        String[] almapalabra=contCorrejido.split(" ");
        for(String s:almapalabra){
            if(s.equalsIgnoreCase(textFieldPalabraBuscar.getText())){
                contpalabra++;
                
            }
        }
        cantVecesPalabra.setText(String.valueOf(contpalabra));
        textAreaMostrar.setText(textAreaMostrar.getText().replaceAll(textFieldPalabraBuscar.getText(),"<<"+ textFieldPalabraBuscar.getText()+">>"));
    }
    
    @FXML
    private void crearNuevoArchivo(ActionEvent event) throws IOException {
        File f=new File(textfieldArchivo1.getText());
        FileWriter fw=new FileWriter(f);
        fw.write(textAreaMostrar.getText());
        fw.close();
    }
    
}
