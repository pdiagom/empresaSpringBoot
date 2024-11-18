package com.example.empresaspringboot.service;

import com.example.empresaspringboot.model.Empleado;
import com.example.empresaspringboot.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> obtenerEmpleados(){
        return empleadoRepository.findAll();
    }

    public boolean crear(String dni,
                         String nombre, String sexo,
                         int categoria,
                         int anyos){
            Empleado empleado = new Empleado(dni,nombre,sexo,categoria,anyos);
            empleadoRepository.save(empleado);
            return true;
    }

    public Empleado obtenerEmpleado(String dni){
        Optional<Empleado> empleado= empleadoRepository.findById(dni);
        return empleado.orElse(null);
    }

    public List<Empleado> obtenerEmpleadosFiltrados(String criterio, String valor){
        List<Empleado> listaEmpleados=new ArrayList<>();
        if(criterio.equals("dni")){
            listaEmpleados=empleadoRepository.findByDniContainingIgnoreCase(valor);
        }else if(criterio.equals("nombre")){
           listaEmpleados=empleadoRepository.findByNombreContaining(valor);
        } else if (criterio.equals("sexo")) {
            listaEmpleados=empleadoRepository.findBySexo(valor);
        } else if (criterio.equals("categoria")) {
          listaEmpleados=empleadoRepository.findByCategoria(Integer.valueOf(valor));
        } else if (criterio.equals("anyos_trabajados")) {
            listaEmpleados=empleadoRepository.findByAnyos(Integer.valueOf(valor));
        }
        return listaEmpleados;
    }

    public boolean editar(Empleado empleado){
        Optional<Empleado> empleadoOpt = empleadoRepository.findById(empleado.getDni());
        if (empleadoOpt.isPresent()) {
            Empleado empleadoAct = empleadoOpt.get();
            empleadoAct.setNombre(empleado.getNombre());
            empleadoAct.setSexo(empleado.getSexo());
            empleadoAct.setCategoria(empleado.getCategoria());
            empleadoAct.setAnyos(empleado.getAnyos());
            empleadoRepository.save(empleadoAct);
            return true;  // Devuelve true si se editó con éxito
        } else {
            return false;  // Devuelve false si no se encontró el empleado
        }
    }

    @Transactional
    public void eliminar(String dni) {
    empleadoRepository.deleteByDni(dni);
    }
}
