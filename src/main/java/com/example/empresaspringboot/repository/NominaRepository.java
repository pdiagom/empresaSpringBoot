package com.example.empresaspringboot.repository;

import com.example.empresaspringboot.model.Nomina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NominaRepository extends JpaRepository<Nomina, String> {
    Nomina findByDni(String dni);
}
