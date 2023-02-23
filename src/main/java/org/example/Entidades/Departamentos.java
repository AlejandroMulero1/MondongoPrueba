package org.example.Entidades;

public class Departamentos {
    //region Atributos
    private String _id;
    private String nombre;
    //endregion

    //region Constructores
    public Departamentos(){}
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
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //endregion

    //region Metodos
    @Override
    public String toString(){
        return this.nombre;
    }
    //endregion
}
