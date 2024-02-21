package com.prueba.logisticaPrueba.services.interfaces;

import org.springframework.stereotype.Service;

import com.prueba.logisticaPrueba.dto.ClienteDTO;

import java.util.List;

@Service
public interface IClienteService {

    List<ClienteDTO> findAll();

    List<ClienteDTO> findByIdentificacion(int identificacion);

    ClienteDTO findById(int id);

    void save(ClienteDTO cliente);

    void update(ClienteDTO cliente, int id);

    void deleteById(int id);

    boolean existsByIdentificacion(int identificacion);

    boolean existsByCorreoCliente(String correoCliente);

}
