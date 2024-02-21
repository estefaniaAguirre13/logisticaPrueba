package com.prueba.logisticaPrueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.prueba.logisticaPrueba.entities.Almacen;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Integer> {

    @Transactional(readOnly = true)
    Iterable<Almacen> findByNombreAlmacen(String nombreAlmacen);

    boolean existsByNombreAlmacen(String nombreAlmacen);

}
