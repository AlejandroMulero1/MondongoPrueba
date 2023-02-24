package org.example.Entidades;

import org.example.Utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Personas {
    //region Atributos
    private String _id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String foto;
    private String nombreDepartamento;

    //endregion

    //region Constructores
    public Personas(){}

        public Personas(String nombre, String apellidos, String telefono, String direccion, String foto, String departamento){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.telefono=telefono;
        this.direccion=direccion;
        this.foto=foto;
        this.nombreDepartamento=departamento;
    }
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

    public String getApellidos() {
        return apellidos;
    }

    public String getFoto() {
        return foto;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    //endregion

    //region Setters
    public void set_id(Object _id) {
        this._id= Utilidades.obtenerIdMongo(_id.toString());
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

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    //endregion

    //region Metodos
    @Override
    public String toString(){
        return this._id + ": " + this.nombre + " " + this.apellidos + " " + this.nombreDepartamento;
    }
    //endregion
}
