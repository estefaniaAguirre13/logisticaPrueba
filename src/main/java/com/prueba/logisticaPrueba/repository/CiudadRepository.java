package com.prueba.logisticaPrueba.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.logisticaPrueba.entities.Ciudad;


@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

    @Transactional(readOnly = true)
    Optional<Ciudad> findById(int id);

}
