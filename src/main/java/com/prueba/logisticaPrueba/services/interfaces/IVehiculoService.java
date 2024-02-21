package com.prueba.logisticaPrueba.services.interfaces;

import org.springframework.stereotype.Service;

import com.prueba.logisticaPrueba.dto.VehiculoDTO;

import java.util.List;

@Service
public interface IVehiculoService {

    List<VehiculoDTO> findAll();
    
    VehiculoDTO findById(int id);

    List<VehiculoDTO> findByPlacaVehiculo(String PlacaVehiculo);

    List<VehiculoDTO> findAllByLogistica(int idLogistica);

    void save(VehiculoDTO vehiculo);

    void update(VehiculoDTO vehiculo, int id);

    void saveAll(List<VehiculoDTO> veheiculos);

    void deleteById(int id);

    boolean existsByPlacaVehiculo(String placa);

}
