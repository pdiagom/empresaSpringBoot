package com.example.empresaspringboot.repository;


import com.example.empresaspringboot.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
    List<Empleado> findByNombreContaining(String nombre);

    List<Empleado> findByDniContaining(String dni);

    List<Empleado> findBySexo(Character sexo);

    List<Empleado> findByCategoria(Integer categoria);

    List<Empleado> findByAnyos_trabajados(int anyos);

    List<Empleado> findByDniContainingIgnoreCase(String dni);

    List<Empleado> findByNombreContainingIgnoreCase(String nombre);
}