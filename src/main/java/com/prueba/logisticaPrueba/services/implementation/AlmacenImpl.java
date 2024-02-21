package com.prueba.logisticaPrueba.services.implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prueba.logisticaPrueba.dto.AlmacenDTO;
import com.prueba.logisticaPrueba.entities.Almacen;
import com.prueba.logisticaPrueba.repository.AlmacenRepository;
import com.prueba.logisticaPrueba.services.interfaces.IAlmacenService;
import com.prueba.logisticaPrueba.utils.helpers.MHelpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AlmacenImpl implements IAlmacenService {

    @Autowired
    private AlmacenRepository almacenRepository;

    @Override
    public List<AlmacenDTO> findAll() {
        List<AlmacenDTO> dto = new ArrayList<>();
        Iterable<Almacen> almacens = this.almacenRepository.findAll();
        for (Almacen almacen : almacens){
            AlmacenDTO almacenDTO = MHelpers.modelMapper().map(almacen, AlmacenDTO.class);
            dto.add(almacenDTO);
        }
        return dto;
    }
    
    @Override
    public AlmacenDTO findById(int id) {
        Optional<Almacen> almacen = this.almacenRepository.findById(id);
        if(!almacen.isPresent()){
            return null;
        }
        return MHelpers.modelMapper().map(almacen.get(), AlmacenDTO.class);
    }


    @Override
    public List<AlmacenDTO> findByNombreAlmacen(String nombreAlmacen) {
        List<AlmacenDTO> dto = new ArrayList<>();
        Iterable<Almacen> almacens = this.almacenRepository.findByNombreAlmacen(nombreAlmacen);
        for (Almacen almacen : almacens){
            AlmacenDTO almacenDTO = MHelpers.modelMapper().map(almacen, AlmacenDTO.class);
            dto.add(almacenDTO);
        }
        return dto;
    }

    @Override
    public List<AlmacenDTO> findAllByLogisticaAndCiudad(int idLogistica, int idCiudad) {
        List<AlmacenDTO> dto = new ArrayList<>();
        List<Almacen> almacenes = this.almacenRepository.findAll();
        for (int i = 0; i < almacenes.size(); i++){
            if(almacenes.get(i).getIdLogisticaAlmacen().getIdLogistica() == idLogistica &&
                almacenes.get(i).getIdCiudadAlmacen().getId() == idCiudad){
                AlmacenDTO almacenDTO = MHelpers.modelMapper().map(almacenes.get(i), AlmacenDTO.class);
                dto.add(almacenDTO);
            }
        }
        return dto;
    }

    @Override
    public void save(AlmacenDTO almacen) {
        Almacen almacenes = MHelpers.modelMapper().map(almacen, Almacen.class);
        this.almacenRepository.save(almacenes);
    }

    @Override
    public void update(AlmacenDTO almacen, int id) {
        Optional<Almacen> almacenes = this.almacenRepository.findById(id);
        if(!almacenes.isEmpty()){
            Almacen almacenAux = almacenes.get();
            almacenAux.setNombreAlmacen(almacen.getNombreAlmacen());
            almacenAux.setIdLogisticaAlmacen(almacen.getIdLogisticaAlmacen());
            almacenAux.setIdCiudadAlmacen(almacen.getIdCiudadAlmacen());
            this.almacenRepository.save(almacenAux);
        }
    }

    @Override
    public void deleteById(int id) {
        this.almacenRepository.deleteById(id);
    }

    @Override
    public boolean existsByNombreAlmacen(String nombreAlmacen) {
        return this.almacenRepository.existsByNombreAlmacen(nombreAlmacen);
    }
}
