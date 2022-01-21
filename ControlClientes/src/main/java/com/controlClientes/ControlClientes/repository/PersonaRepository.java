package com.controlClientes.ControlClientes.repository;

import com.controlClientes.ControlClientes.modelo.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona,Long> {
}
