package com.prueba.logisticaPrueba.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prueba.logisticaPrueba.dto.LogisticaDTO;
import com.prueba.logisticaPrueba.entities.Logistica;
import com.prueba.logisticaPrueba.repository.LogisticaRepository;
import com.prueba.logisticaPrueba.services.interfaces.ILogisticaService;
import com.prueba.logisticaPrueba.utils.helpers.MHelpers;

@Component
public class LogisticaImpl implements ILogisticaService {

    @Autowired
    private LogisticaRepository logisticaRepository;

    @Override
    public List<LogisticaDTO> findAll() {

        List<LogisticaDTO> dto = new ArrayList<>();

        Iterable<Logistica> logisticas = this.logisticaRepository.findAll();

        for (Logistica logistica : logisticas){

            LogisticaDTO logisticaDTO = MHelpers.modelMapper().map(logistica, LogisticaDTO.class);
            dto.add(logisticaDTO);

        }

        return dto;

    }

    @Override
    public LogisticaDTO findByIdLogistica(int id) {
        Optional<Logistica> logistica = this.logisticaRepository.findByIdLogistica(id);
        if(!logistica.isPresent()){
            return null;
        }
        return MHelpers.modelMapper().map(logistica.get(), LogisticaDTO.class);
    }
}
