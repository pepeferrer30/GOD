/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package repasoglobal;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 */
public class Examen3Controller implements Initializable {

    @FXML
    private TextField inputId;
    @FXML
    private TextField inputNombre;
    @FXML
    private TextField inputApellidos;
    @FXML
    private TextField inputIncidencia;
    XMLModel xmlmodel;
    ArrayList<Incidencia> almainci = new ArrayList();
    int parteListado = 0;
    String idTEMP = "";
    String nombreTEMP = "";
    String apellidosTEMP = "";
    String inciTEMP = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        almainci = xmlmodel.leerFichero();
        inputId.setText(String.valueOf(almainci.get(0).getId()));
        inputNombre.setText(almainci.get(0).getNombre());
        inputApellidos.setText(almainci.get(0).getApellidos());
        inputIncidencia.setText(almainci.get(0).getInci());
        
        idTEMP=(String.valueOf(almainci.get(0).getId()));
        nombreTEMP=(almainci.get(0).getNombre());
        inputApellidos.setText(almainci.get(0).getApellidos());
        inputIncidencia.setText(almainci.get(0).getInci());
    }

    @FXML
    private void accionButtonConf(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Examen.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void accionButtonAtras(ActionEvent event) {
        parteListado--;

        if (parteListado >= 0) {
            inputId.setText(Integer.toString(almainci.get(parteListado).getId()));
            inputNombre.setText(almainci.get(parteListado).getNombre());
            inputApellidos.setText(almainci.get(parteListado).getApellidos());
            inputIncidencia.setText(almainci.get(parteListado).getInci());

        } else {
            parteListado = 0;
        }
        idTEMP = (inputId.getText());
        nombreTEMP = inputNombre.getText();
        apellidosTEMP = inputApellidos.getText();
        inciTEMP = inputIncidencia.getText();
    }

    @FXML
    private void accionButtonAdelante(ActionEvent event) {

        if (!nombreTEMP.equals(inputNombre.getText()) || !apellidosTEMP.equals(inputApellidos.getText()) || !inciTEMP.equals(inputIncidencia.getText())) {
            if (!nombreTEMP.equals("") && !inputNombre.equals("") && !apellidosTEMP.equals("") && !inputApellidos.equals("")) {//l falta esta condicion y si esta no se cumple tambien falla
                System.out.println("update");
                for (int i = 0; i < almainci.size(); i++) {
                    if (idTEMP.equals(almainci.get(i).getId())) {
                        almainci.get(i).setNombre(inputNombre.getText());
                        almainci.get(i).setNombre(inputApellidos.getText());
                        almainci.get(i).setNombre(inputIncidencia.getText());
                        xmlmodel.actualizarfichero(almainci);

                    }

                }

            }

        }
        if (inputId.getText().equals("") && !idTEMP.equals("")) {
            System.out.println("delete");//el delete no lo tiene aqui y tiene que estar aqui y le falta la segunda condicion(lo tenia el el else del afterlast)
            Incidencia inc = new Incidencia();
            for (int i = 0; i < almainci.size(); i++) {
                if (idTEMP.equals(almainci.get(i).getId())) {
                    inc.setId(almainci.get(i).getId());
                    inc.setNombre(almainci.get(i).getNombre());
                    inc.setApellidos(almainci.get(i).getApellidos());
                    inc.setInci(almainci.get(i).getInci());
                }

            }
            almainci.remove(inc);
            xmlmodel.actualizarfichero(almainci);
        }
        if (idTEMP.equals("") && !inputNombre.getText().equals(""))/* && pulsarIzquierda == 0)*/ {
            Integer idMas = almainci.get(almainci.size() - 1).getId() + 1;
            Incidencia inc = new Incidencia();
            System.out.println("insert");
            inc.setNombre(inputNombre.getText());
            inc.setApellidos(inputApellidos.getText());
            inc.setInci(inputIncidencia.getText());
            inc.setId(idMas);
            almainci.add(inc);
            xmlmodel.actualizarfichero(almainci);

        }

        parteListado++;
        if (parteListado < almainci.size()) {
            inputId.setText(Integer.toString(almainci.get(parteListado).getId()));
            inputNombre.setText(almainci.get(parteListado).getNombre());
            inputApellidos.setText(almainci.get(parteListado).getApellidos());
            inputIncidencia.setText(almainci.get(parteListado).getInci());

        } else {
            inputId.setText("");
            inputNombre.setText("");
            inputApellidos.setText("");
            inputIncidencia.setText("");

        }
        idTEMP = (inputId.getText());
        nombreTEMP = inputNombre.getText();
        apellidosTEMP = inputApellidos.getText();
        inciTEMP = inputIncidencia.getText();

    }

}
