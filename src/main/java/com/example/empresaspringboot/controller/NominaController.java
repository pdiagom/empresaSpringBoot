package com.example.empresaspringboot.controller;


import com.example.empresaspringboot.service.NominaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/empresa/nominas")
public class NominaController {
    @Autowired
    private NominaService nominaService;

    @GetMapping("/buscarSueldo")
    public String buscarSueldo(){
        return "buscarSueldo";
    }

    @PostMapping("/mostrarSueldo")
    public String mostrarSueldo(@RequestParam("dni") String dni, Model model){
        Double sueldo=nominaService.obtenerSueldo(dni);
        model.addAttribute("sueldo", sueldo);
        model.addAttribute("dni",dni);
        return "mostrarSueldo";
    }
}
