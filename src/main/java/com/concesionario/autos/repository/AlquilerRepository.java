package com.concesionario.autos.repository;

import com.concesionario.autos.entity.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlquilerRepository extends JpaRepository<Alquiler, Integer> {
}
