package com.prueba.logisticaPrueba.services.implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prueba.logisticaPrueba.dto.VehiculoDTO;
import com.prueba.logisticaPrueba.entities.Vehiculo;
import com.prueba.logisticaPrueba.repository.VehiculoRepository;
import com.prueba.logisticaPrueba.services.interfaces.IVehiculoService;
import com.prueba.logisticaPrueba.utils.helpers.MHelpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class VehiculoImpl implements IVehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

	@Override
	public List<VehiculoDTO> findAll() {
		List<VehiculoDTO> dto = new ArrayList<>();
        Iterable<Vehiculo> vehiculos = this.vehiculoRepository.findAll();
        for (Vehiculo vehiculo : vehiculos){
            VehiculoDTO vehiculoDTO = MHelpers.modelMapper().map(vehiculo, VehiculoDTO.class);
            dto.add(vehiculoDTO);
        }
        return dto;
	}

	@Override
	public VehiculoDTO findById(int id) {
		Optional<Vehiculo> vehiculo = this.vehiculoRepository.findById(id);
	    if(!vehiculo.isPresent()){
	        return null;
	    }
	    return MHelpers.modelMapper().map(vehiculo.get(), VehiculoDTO.class);
	}
	
	@Override
	public List<VehiculoDTO> findByPlacaVehiculo(String PlacaVehiculo) {
		List<VehiculoDTO> dto = new ArrayList<>();
        Iterable<Vehiculo> vehiculos = this.vehiculoRepository.findByPlacaVehiculo(PlacaVehiculo);
        for (Vehiculo vehiculo : vehiculos){
            VehiculoDTO vehiculoDTO = MHelpers.modelMapper().map(vehiculo, VehiculoDTO.class);
            dto.add(vehiculoDTO);
        }
        return dto;
	}

	@Override
	public List<VehiculoDTO> findAllByLogistica(int idLogistica) {
		List<VehiculoDTO> dto = new ArrayList<>();
        List<Vehiculo> vehiculos = this.vehiculoRepository.findAll();
        for (int i = 0; i < vehiculos.size(); i++){

            if(vehiculos.get(i).getIdLogisticaVehiculo().getIdLogistica() == idLogistica){
                VehiculoDTO vehiculoDTO = MHelpers.modelMapper().map(vehiculos.get(i), VehiculoDTO.class);
                dto.add(vehiculoDTO);
            }
        }
        return dto;
	}

	@Override
	public void save(VehiculoDTO vehiculo) {
		Vehiculo vehiculos = MHelpers.modelMapper().map(vehiculo, Vehiculo.class);
        this.vehiculoRepository.save(vehiculos);
	}

	@Override
	public void update(VehiculoDTO vehiculo, int id) {
		Optional<Vehiculo> vehiculos = this.vehiculoRepository.findById(id);
        if(!vehiculos.isEmpty()){
            Vehiculo vehiculoAux = vehiculos.get();
            vehiculoAux.setPlacaVehiculo(vehiculo.getPlacaVehiculo());
            vehiculoAux.setIdLogisticaVehiculo(vehiculo.getIdLogisticaVehiculo());
            this.vehiculoRepository.save(vehiculoAux);
        }
	}

	@Override
	public void saveAll(List<VehiculoDTO> vehiculos) {
		List<Vehiculo> vehiculoAux = new ArrayList<>();
        for (VehiculoDTO vehiculo : vehiculos){
            Vehiculo vehAux = MHelpers.modelMapper().map(vehiculo, Vehiculo.class);
            vehiculoAux.add(vehAux);
        }
        this.vehiculoRepository.saveAll(vehiculoAux);		
	}

	@Override
	public void deleteById(int id) {
        this.vehiculoRepository.deleteById(id);
	}

	@Override
	public boolean existsByPlacaVehiculo(String placa) {
        return this.vehiculoRepository.existsByPlacaVehiculo(placa);
	}

 
}
