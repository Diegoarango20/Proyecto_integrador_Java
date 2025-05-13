package com.example;

public class Usuario {
    private String nombre;
    private String id;
    private String rol;
    private String ciudad;
    private String contacto;
    private String correo;
    private String contrasena;

    public Usuario(String nombre, String id, String rol, String ciudad, String contacto, String correo, String contrasena) {
        this.nombre = nombre;
        this.id = id;
        this.rol = rol;
        this.ciudad = ciudad;
        this.contacto = contacto;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }
}
