package com.example.empresaspringboot.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * La clase {@code Nomina} representa los datos de una nómina
 * generada para un empleado, incluyendo su sueldo y la fecha.
 */
@Entity
@Table(name = "nominas")
@Data
@NoArgsConstructor
public class Nomina implements Serializable {

    /**
     * Identificador único de la nómina, autogenerado.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nomina")
    private Long idNomina;

    /**
     * Relación con el empleado asociado a esta nómina (por DNI).
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dni", referencedColumnName = "dni", nullable = false)
    private Empleado empleado;

    /**
     * Sueldo total del empleado.
     */
    @Column(name = "sueldo", nullable = false)
    private int sueldo;

    /**
     * Fecha de la nómina, generada automáticamente al insertarla.
     */
    @Column(name = "fecha_nomina", nullable = false, updatable = false)
    private LocalDate fechaNomina;

    /**
     * Constructor que crea una nueva nómina asociada a un empleado.
     *
     * @param empleado El empleado al que pertenece la nómina.
     * @param sueldo   El sueldo del empleado.
     */
    public Nomina(Empleado empleado, int sueldo) {
        this.empleado = empleado;
        this.sueldo = sueldo;
        this.fechaNomina = LocalDate.now(); // Asignar la fecha actual.
    }
}