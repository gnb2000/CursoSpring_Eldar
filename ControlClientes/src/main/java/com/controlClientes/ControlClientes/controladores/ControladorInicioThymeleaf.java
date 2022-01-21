package com.controlClientes.ControlClientes.controladores;

import com.controlClientes.ControlClientes.modelo.Persona;
import com.controlClientes.ControlClientes.repository.PersonaRepository;
import com.controlClientes.ControlClientes.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorInicioThymeleaf {


    @Autowired
    private PersonaService personaService;

    @GetMapping("/test")
    public String inicioThymeleaf(Model model){
        String msg = "Hola mundo prueba";
        model.addAttribute("msg",msg);
        //model.addAttribute("saludo",saludo);

        //Modelo persona
        List<Persona> personas = new ArrayList<>();
        //Persona persona1 = new Persona("Jose","Perez","jose@gmail.com","4123-1312");
        //Persona persona2 = new Persona("Luis","Perez","jose@gmail.com","4123-1312");
       // personas.add(persona1);
        //personas.add(persona2);
        model.addAttribute("personas",personas);
        return "index";
    }



    @GetMapping("/personas")
    public String getPersonas(Model model){
        List<Persona> personas = personaService.getAll();
        model.addAttribute("personas",personas);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregarPersona(Persona persona){
        return "modificar";
    }

    @PostMapping("/guardar")
    public String save(@Valid Persona persona, Errors errors){
        if (errors.hasErrors()){
            return "modificar";
        }
        personaService.save(persona);
        return "redirect:/personas";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.findById(persona);
        model.addAttribute("persona",persona);
        return "modificar";
    }

    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona){
        personaService.delete(persona);
        return "redirect:/personas";
    }




}
