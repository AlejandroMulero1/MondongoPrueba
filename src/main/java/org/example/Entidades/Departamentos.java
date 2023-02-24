package org.example.Entidades;

import org.example.Utilidades;

public class Departamentos {
    //region Atributos
    private String _id;
    private String nombre;
    //endregion

    //region Constructores
    public Departamentos(){}

    public Departamentos(String nombre){
        this.nombre=nombre;
    }
    //endregion

    //region Getters
    public String get_id() {
        return _id;
    }

    public String getNombre() {
        return nombre;
    }
    //endregion

    //region Setters
    public void set_id(Object _id) {
        this._id= Utilidades.obtenerIdMongo(_id.toString());
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //endregion

    //region Metodos
    @Override
    public String toString(){
        return this.nombre+ " " + this.get_id();
    }
    //endregion
}
