package com.HolaSpring.HolaSpring.modelo;

import lombok.Data;

@Data
public class Persona {

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }
}
