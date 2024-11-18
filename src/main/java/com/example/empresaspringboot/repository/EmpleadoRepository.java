package com.example.empresaspringboot.repository;


import com.example.empresaspringboot.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
    List<Empleado> findByNombreContaining(String nombre);

    List<Empleado> findByDniContaining(String dni);

    List<Empleado> findBySexo(String sexo);

    List<Empleado> findByCategoria(Integer categoria);

    List<Empleado> findByAnyos(int anyos);

    List<Empleado> findByDniContainingIgnoreCase(String dni);

    void deleteByDni(String dni);

    List<Empleado> findByNombreContainingIgnoreCase(String nombre);

}
