package com.prueba.logisticaPrueba.services.interfaces;

import org.springframework.stereotype.Service;

import com.prueba.logisticaPrueba.dto.AlmacenDTO;

import java.util.List;

@Service
public interface IAlmacenService {

    List<AlmacenDTO> findAll();

    AlmacenDTO findById(int id);

    List<AlmacenDTO> findByNombreAlmacen(String nombreAlmacen);

    List<AlmacenDTO> findAllByLogisticaAndCiudad(int idLogistica, int idCiudad);

    void save(AlmacenDTO almacen);

    void update(AlmacenDTO almacen, int id);

    void deleteById(int id);

    boolean existsByNombreAlmacen(String nombreAlmacen);

}
