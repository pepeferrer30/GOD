/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package repasoglobal;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class Examen1Controller implements Initializable {

    @FXML
    private TextArea textAreaMostrar;
    @FXML
    private TextField textfieldRuta;
    @FXML
    private Button botonCrear;
    @FXML
    private TextField textFieldCantDirectorios;
    @FXML
    private TextField textFieldCantFicheros;
    @FXML
    private TextField textFieldBorrar;
    @FXML
    private Button botonBorrar;
    @FXML
    private Button botonListar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void crearDirectoriosFicheros(ActionEvent event) throws IOException {
        File f = new File(textfieldRuta.getText());
        if (f.exists()) {
            f.delete();
            f.mkdirs();

        }
        if (!textFieldCantDirectorios.getText().isEmpty()) {

            int cant = Integer.parseInt(textFieldCantDirectorios.getText());
            for (int i = 0; i < cant; i++) {
                File direct = new File(textfieldRuta.getText() + "Joan Ruiz" + i + 1);
                direct.mkdirs();
            }
        }
        if (!textFieldCantFicheros.getText().isEmpty()) {

            int cant = Integer.parseInt(textFieldCantDirectorios.getText());
            for (int i = 0; i < cant; i++) {
                File file = new File(textfieldRuta.getText() + "Joan Ruiz" + i + 1 + ".txt");
                file.createNewFile();
            }
        }

    }

    @FXML
    private void borrarTodo(ActionEvent event) {
        this.borrar(textfieldRuta.getText());

    }

    private void borrar(String ruta) {
        File f = new File(ruta);
        File[] alma = f.listFiles();
        for (int i = 0; i < alma.length; i++) {
            if (alma[i].isFile()) {
                alma[i].delete();
            } else {
                this.borrar(alma[i].getAbsolutePath());
                alma[i].delete();
            }

            
        }
        f.delete();
    }

    @FXML
    private void listar(ActionEvent event) {
        File f = new File(textfieldRuta.getText());
        if (f.exists()) {
            File[] almaArchivos = f.listFiles();
            for (File fi : almaArchivos) {
                textAreaMostrar.setText(textAreaMostrar.getText() + fi.getName() + "\n");
                textAreaMostrar.setText(textAreaMostrar.getText() + fi.getPath() + "\n");
                if (fi.isDirectory()) {
                    textAreaMostrar.setText(textAreaMostrar.getText() + "Es un directorio" + "\n");

                } else if (fi.isFile()) {
                    textAreaMostrar.setText(textAreaMostrar.getText() + "Es un archivo" + "\n");
                }
                if (fi.isHidden()) {
                    textAreaMostrar.setText(textAreaMostrar.getText() + "Está oculto" + "\n");

                } else {
                    textAreaMostrar.setText(textAreaMostrar.getText() + "No está oculto" + "\n");
                }

            }

        }

    }

}
