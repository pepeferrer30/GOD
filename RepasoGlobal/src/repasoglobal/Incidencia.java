/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoglobal;

/**
 *
 */
public class Incidencia {

    private int id;
    private String nombre;
    private String apellidos;
    private String inci;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getInci() {
        return inci;
    }

    public void setInci(String inci) {
        this.inci = inci;
    }

    public Incidencia() {
    }

    public Incidencia(int id, String nombre, String apellidos, String inci) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.inci = inci;
    }

    @Override
    public String toString() {
        return "Incidencia{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", inci=" + inci + '}';
    }


}