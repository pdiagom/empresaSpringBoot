package com.example.empresaspringboot.service;

import com.example.empresaspringboot.model.Nomina;
import com.example.empresaspringboot.repository.NominaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NominaService {
    @Autowired
    private NominaRepository nominaRepository;

    public double obtenerSueldo(String dni){
        Optional<Nomina> nomina= Optional.ofNullable(nominaRepository.findByDni(dni));
        return nomina.map(Nomina::getSueldo).orElse(null);
    }
}
