package com.controlClientes.ControlClientes.controladores;

import com.controlClientes.ControlClientes.modelo.Persona;
import com.controlClientes.ControlClientes.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private PersonaService personaService;


    @PostMapping("/testAgregar")
    public void testAgregar(){
        Persona p = new Persona("Enrique","a@mail.com","Jose","31231312");
        personaService.save(p);
    }
}
