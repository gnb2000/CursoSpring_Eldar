package com.controlClientes.ControlClientes.service;

import com.controlClientes.ControlClientes.modelo.Persona;
import com.controlClientes.ControlClientes.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> getAll() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Persona p) {
        personaRepository.save(p);

    }

    @Override
    @Transactional
    public void delete(Persona p) {
        personaRepository.delete(p);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findById(Persona persona) {
        return personaRepository.findById(persona.getIdPersona()).orElse(null);
    }
}
