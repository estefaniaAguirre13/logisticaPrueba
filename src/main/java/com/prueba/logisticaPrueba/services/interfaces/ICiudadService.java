package com.prueba.logisticaPrueba.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.logisticaPrueba.dto.CiudadDTO;

@Service
public interface ICiudadService {
    List<CiudadDTO> findAll();
    
    CiudadDTO findById(int id);

}
