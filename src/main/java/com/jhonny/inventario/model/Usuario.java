package com.jhonny.inventario.model;

public class Usuario {

    private int id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;
    private String telefono;
    private String correoElectronico;

    //Constructor vacio para crear Usuario  e ir agregados datos
    public Usuario() {}

    //Conmstrutor Completo
    public Usuario (int id, String nombre, String apellido, String usuario, String contrasena,
                    String correoElectronico, String telefono){

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
    }

    //Getters

    public int getId() {
        return id;
    }

    public String getnombre() {
        return nombre;
    }

    public String getapellido() {
        return apellido;
    }

    public String getusuario() {
        return usuario;
    }

    public String getcontrasena() {
        return contrasena;
    }

    public String gettelefono() {
        return telefono;
    }

    public String getcorreoElectronico() {
        return correoElectronico;
    }

    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public void setapellido(String apellido) {
        this.apellido = apellido;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    public void setcontrasena(String contrasena) {
        this.contrasena = contrasena;

    }

    public void settelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setcorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

}
