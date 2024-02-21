package com.prueba.logisticaPrueba.services.implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.prueba.logisticaPrueba.dto.ClienteDTO;
import com.prueba.logisticaPrueba.entities.Cliente;
import com.prueba.logisticaPrueba.repository.ClienteRepository;
import com.prueba.logisticaPrueba.services.interfaces.IClienteService;
import com.prueba.logisticaPrueba.utils.helpers.MHelpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClienteImpl implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

	@Override
	public List<ClienteDTO> findAll() {
		List<ClienteDTO> dto = new ArrayList<>();
        Iterable<Cliente> clients = this.clienteRepository.findAll();
        for (Cliente cliente : clients){
            ClienteDTO clienteDTO = MHelpers.modelMapper().map(cliente, ClienteDTO.class);
            dto.add(clienteDTO);
        }
        return dto;
	}
	
	@Override
    public ClienteDTO findById(int id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        if(!cliente.isPresent()){
            return null;
        }
        return MHelpers.modelMapper().map(cliente.get(), ClienteDTO.class);
    }

	@Override
	public List<ClienteDTO> findByIdentificacion(int identificacion) {
		List<ClienteDTO> dto = new ArrayList<>();
        Iterable<Cliente> clients = this.clienteRepository.findByIdentificacion(identificacion);
        for (Cliente cliente : clients){
            ClienteDTO clienteDTO = MHelpers.modelMapper().map(cliente, ClienteDTO.class);
            dto.add(clienteDTO);
        }

        return dto;
	}

	@Override
	public void save(ClienteDTO cliente) {
		Cliente clientes = MHelpers.modelMapper().map(cliente, Cliente.class);
        this.clienteRepository.save(clientes);		
	}

	@Override
	public void update(ClienteDTO cliente, int id) {
		Optional<Cliente> clientes = this.clienteRepository.findById(id);
        if(!clientes.isEmpty()){
            Cliente clienteAux = clientes.get();
            clienteAux.setIdentificacion(cliente.getIdentificacion());
            clienteAux.setNombreCliente(cliente.getNombreCliente());
            clienteAux.setApellidoCliente(cliente.getApellidoCliente());
            clienteAux.setDireccionCliente(cliente.getDireccionCliente());
            clienteAux.setCorreoCliente(cliente.getCorreoCliente());
            clienteAux.setTelefonoCliente(cliente.getTelefonoCliente());
            this.clienteRepository.save(clienteAux);
        }		
	}

	@Override
	public void deleteById(int id) {
        this.clienteRepository.deleteById(id);
	}

	@Override
	public boolean existsByIdentificacion(int identificacion) {
        return clienteRepository.existsByIdentificacion(identificacion);
	}

	@Override
	public boolean existsByCorreoCliente(String correoCliente) {
        return clienteRepository.existsByCorreoCliente(correoCliente);
	}


}
