package org.example.Entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Personas {
    //region Atributos
    private String _id;
    private int id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String foto;
    private String fechaNacimiento;
    private int idDepartamento;

    private Departamentos departamento;

    //endregion

    //region Constructores
    public Personas(){}
    //endregion

    //region Getters
    public String get_id() {
        return _id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public int getId() {
        return id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFoto() {
        return foto;
    }
    //endregion

    //region Setters
    public void set_id(Object _id) {
        this._id= _id.toString();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
    }

    public void setIdDepartamento(String idDepartamento) {
        try {
            this.idDepartamento = Integer.parseInt(idDepartamento);
        } catch (NumberFormatException e){
            System.err.println("Error con el id del Departamento");
        }
    }
    //endregion

    //region Metodos
    @Override
    public String toString(){
        return this._id + ": " + this.nombre + " " + this.apellidos + " " + this.departamento.
    }
    //endregion
}
