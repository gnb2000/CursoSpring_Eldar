package com.HolaSpring.HolaSpring.controladores;

import com.HolaSpring.HolaSpring.daos.IPersonaDAO;
import com.HolaSpring.HolaSpring.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorInicioThymeleaf {

   /* @Value("${index.saludo}")
    private String saludo;*/

    @Autowired
    private IPersonaDAO iPersonaDAO;

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
        Iterable<Persona> personas = iPersonaDAO.findAll();
        model.addAttribute("personas",personas);
        return "index";
    }


}
