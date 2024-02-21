package com.prueba.logisticaPrueba.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prueba.logisticaPrueba.dto.AlmacenDTO;
import com.prueba.logisticaPrueba.dto.CiudadDTO;
import com.prueba.logisticaPrueba.entities.Almacen;
import com.prueba.logisticaPrueba.entities.Ciudad;
import com.prueba.logisticaPrueba.repository.CiudadRepository;
import com.prueba.logisticaPrueba.utils.helpers.MHelpers;


@Component
public class CiudadImpl implements com.prueba.logisticaPrueba.services.interfaces.ICiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public List<CiudadDTO> findAll() {

        List<CiudadDTO> dto = new ArrayList<>();

        Iterable<Ciudad> ciudades = this.ciudadRepository.findAll();

        for (Ciudad ciudad : ciudades){

            CiudadDTO ciudadDTO = MHelpers.modelMapper().map(ciudad, CiudadDTO.class);
            dto.add(ciudadDTO);
        }
        return dto;
    }

	@Override
	public CiudadDTO findById(int id) {
		Optional<Ciudad> ciudad = this.ciudadRepository.findById(id);
        if(!ciudad.isPresent()){
            return null;
        }
        return MHelpers.modelMapper().map(ciudad.get(), CiudadDTO.class);
	}
}
