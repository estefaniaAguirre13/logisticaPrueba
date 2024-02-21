package com.prueba.logisticaPrueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.logisticaPrueba.entities.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    @Transactional(readOnly = true)
    Iterable<Vehiculo> findByPlacaVehiculo(String placaVehiculo);

    boolean existsByPlacaVehiculo(String placa);


}
