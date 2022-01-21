package com.controlClientes.ControlClientes.service;

import com.controlClientes.ControlClientes.modelo.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> getAll();
    void save(Persona p);
    void delete(Persona p);
    Persona findById(Persona persona);
}
