package com.example.empresaspringboot.controller;

import com.example.empresaspringboot.model.Empleado;
import com.example.empresaspringboot.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empresa/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/listar")
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.obtenerEmpleados();
        model.addAttribute("empleados", empleados);
        return "listar";
    }

    @GetMapping("/crear")
    public String crearEmpleado(){
        return "crear";
    }

    @PostMapping("/registrado")
    public String registrarEmpleado(@RequestParam("dni") String dni,
                                    @RequestParam("nombre") String nombre,
                                    @RequestParam("sexo") String sexo,
                                    @RequestParam("categoria") String categoria,
                                    @RequestParam("anyos") String anyos, Model model){
        if(categoria=="" && anyos==""){
            empleadoService.crear(dni, nombre, sexo,1, 0);
        }else if(anyos==""){
            empleadoService.crear(dni, nombre, sexo,Integer.parseInt(categoria), 0);
        }else if(categoria==""){
            empleadoService.crear(dni, nombre, sexo,1, Integer.parseInt(anyos));
        }else {
            empleadoService.crear(dni, nombre, sexo, Integer.parseInt(categoria), Integer.parseInt(anyos));
        }
        return listarEmpleados(model);
    }

    @GetMapping("/filtrar")
    public String buscarEmpleados() {
        return "buscarEmpleados";
    }

    @PostMapping("/empleadosFiltrados")
    public String mostrarFiltrados(@RequestParam String criterio, @RequestParam String valor
            ,Model model) {
        List<Empleado> empleados = empleadoService.obtenerEmpleadosFiltrados(criterio, valor);
        model.addAttribute("empleados",empleados);
        return "listar";
    }

    @GetMapping("/editar/{dni}")
    public String editarEmpleado(@PathVariable("dni") String dni, Model model){
        Empleado empleado=empleadoService.obtenerEmpleado(dni);
        model.addAttribute("empleado", empleado);
        return "editar";
    }

    @PostMapping("/empleadoEditado")
    public String guardarCambios(@ModelAttribute Empleado empleado, Model model){
        empleadoService.editar(empleado);
        model.addAttribute("exito", true);
    return listarEmpleados(model);
    }

    @GetMapping("/eliminar/{dni}")
    public String eliminarEmpleado(@PathVariable("dni") String dni, Model model){
        empleadoService.eliminar(dni);
        return listarEmpleados(model);
    }
}
