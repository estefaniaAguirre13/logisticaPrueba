package com.prueba.logisticaPrueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.logisticaPrueba.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Transactional(readOnly = true)
    Iterable<Producto> findByNombreProducto(String nombreProducto);

    boolean existsByNombreProducto(String nombreProducto);

}
