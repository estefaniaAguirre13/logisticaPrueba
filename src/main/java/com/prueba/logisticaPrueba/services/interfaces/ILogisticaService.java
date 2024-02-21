package com.prueba.logisticaPrueba.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.logisticaPrueba.dto.LogisticaDTO;


@Service
public interface ILogisticaService {

    List<LogisticaDTO> findAll();

    LogisticaDTO findByIdLogistica(int id);

}
