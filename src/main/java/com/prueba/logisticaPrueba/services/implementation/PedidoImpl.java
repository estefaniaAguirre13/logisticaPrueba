package com.prueba.logisticaPrueba.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prueba.logisticaPrueba.dto.PedidoDTO;
import com.prueba.logisticaPrueba.entities.Pedido;
import com.prueba.logisticaPrueba.repository.PedidoRepository;
import com.prueba.logisticaPrueba.services.interfaces.IPedidoService;
import com.prueba.logisticaPrueba.utils.helpers.MHelpers;
import com.prueba.logisticaPrueba.utils.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PedidoImpl implements IPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

	@Override
	public List<PedidoDTO> findAll() {
	 List<PedidoDTO> dto = new ArrayList<>();
	    Iterable<Pedido> pedidos = this.pedidoRepository.findAll();
	    
	    for (Pedido pedido : pedidos){
	        PedidoDTO pedidoDTO = MHelpers.modelMapper().map(pedido, PedidoDTO.class);
	        dto.add(pedidoDTO);
	    }
	    return dto;
	}

	@Override
	public PedidoDTO findById(int id) {
		Optional<Pedido> pedido = this.pedidoRepository.findById(id);
        if(!pedido.isPresent()){
            return null;
        }
        return MHelpers.modelMapper().map(pedido.get(), PedidoDTO.class);
	}

	@Override
	public List<PedidoDTO> findAllByCliente(int idCliente) {
		List<PedidoDTO> dto = new ArrayList<>();

        List<Pedido> pedidos = this.pedidoRepository.findAll();

        for (int i = 0; i < pedidos.size(); i++){

            if(pedidos.get(i).getIdCliente().getId() == idCliente){
                PedidoDTO pedidoDTO = MHelpers.modelMapper().map(pedidos.get(i), PedidoDTO.class);
                dto.add(pedidoDTO);
            }
        }
        return dto;
	}

	 @Override
    public void save(PedidoDTO pedido) {
        Pedido pedidos = MHelpers.modelMapper().map(pedido, Pedido.class);
        this.pedidoRepository.save(pedidos);
    }

	@Override
    public void update(PedidoDTO pedido, int id) {
        Optional<Pedido> pedidos = this.pedidoRepository.findById(id);
        Utils generator = new Utils();

        if(!pedidos.isEmpty()){
            Pedido pedidoAux = pedidos.get();
            pedidoAux.setIdCliente(pedido.getIdCliente());
            pedidoAux.setIdProducto(pedido.getIdProducto());
            pedidoAux.setIdLogistica(pedido.getIdLogistica());
            pedidoAux.setIdVehiculo(pedido.getIdVehiculo());
            pedidoAux.setIdCiudad(pedido.getIdCiudad());
            pedidoAux.setIdCentro(pedido.getIdCentro());
            pedidoAux.setCantidad(pedido.getCantidad());
            pedidoAux.setCostoEnvio(generator.getCosto(pedido.getIdLogistica().getIdLogistica()));
            pedidoAux.setCostoPagar(generator.getCostoPagar(pedido.getIdLogistica().getIdLogistica(), pedido.getCantidad()));
            this.pedidoRepository.save(pedidoAux);
        }
    }

	@Override
	public void saveAll(List<PedidoDTO> pedidos) {
		 List<Pedido> p = new ArrayList<>();
		    for (PedidoDTO pedido : pedidos){
		        Pedido pedidoAux = MHelpers.modelMapper().map(pedido, Pedido.class);
		        p.add(pedidoAux);
		    }
		    this.pedidoRepository.saveAll(p);
	}

	@Override
	public void deleteById(int id) {
        this.pedidoRepository.deleteById(id);		
	}

	@Override
	public List<PedidoDTO> findByGuia(String guia) {
		 List<PedidoDTO> dto = new ArrayList<>();
	        Iterable<Pedido> pedidos = this.pedidoRepository.findByGuia(guia);
	        for (Pedido pedido : pedidos){
	            PedidoDTO pedidoDTO = MHelpers.modelMapper().map(pedido, PedidoDTO.class);
	            dto.add(pedidoDTO);
	        }
	        return dto;
	}

	@Override
	public boolean existsByGuia(String guia) {
        return this.pedidoRepository.existsByGuia(guia);
	}
}
