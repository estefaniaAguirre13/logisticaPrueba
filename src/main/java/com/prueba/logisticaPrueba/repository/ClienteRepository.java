package com.prueba.logisticaPrueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.logisticaPrueba.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Transactional(readOnly = true)
    Iterable<Cliente> findByIdentificacion(int identificacion);

    boolean existsByIdentificacion(int identificacion);

    boolean existsByCorreoCliente(String correoCliente);

}
