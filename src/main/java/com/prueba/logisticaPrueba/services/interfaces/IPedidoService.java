package com.prueba.logisticaPrueba.services.interfaces;

import org.springframework.stereotype.Service;

import com.prueba.logisticaPrueba.dto.PedidoDTO;

import java.util.List;

@Service
public interface IPedidoService {

    List<PedidoDTO> findAll();
    
    PedidoDTO findById(int id);

    List<PedidoDTO> findAllByCliente(int idCliente);

    void save(PedidoDTO pedido);

    void update(PedidoDTO pedido, int id);

    void saveAll(List<PedidoDTO> pedidos);

    void deleteById(int id);
    
    List<PedidoDTO> findByGuia(String guia);

    boolean existsByGuia(String guia);

}
