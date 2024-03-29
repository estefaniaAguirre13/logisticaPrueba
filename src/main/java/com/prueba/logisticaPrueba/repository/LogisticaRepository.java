package com.prueba.logisticaPrueba.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.logisticaPrueba.entities.Logistica;

public interface LogisticaRepository extends JpaRepository<Logistica, Integer> {

    @Transactional(readOnly = true)
    Optional<Logistica> findByIdLogistica(int id);
}
