package com.prueba.logisticaPrueba.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prueba.logisticaPrueba.dto.PedidoDTO;
import com.prueba.logisticaPrueba.services.interfaces.IPedidoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/logistica/pedidos")
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> index(){
        return ResponseEntity.ok(this.pedidoService.findAll());
    }
    
    @GetMapping(value = "/byPedido/{guia}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByGuiaPedido(@PathVariable("guia") String guia) {
        if(!pedidoService.existsByGuia(guia)) {
            return ResponseEntity.badRequest().body("No existen datos para la guía: " + guia);
        }
        return ResponseEntity.ok(this.pedidoService.findByGuia(guia));
    }
    
    @GetMapping(value = "/byCliente/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByAllCliente(@PathVariable("idCliente") int idCliente) {
        return ResponseEntity.ok(this.pedidoService.findAllByCliente(idCliente));
    }
    
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@RequestBody PedidoDTO request) {
		if (request.getCantidad() == 0) {
			return ResponseEntity.unprocessableEntity().body("Se debe ingresar una cantidad superior a 0");
		}

    	this.pedidoService.save(request);
        return ResponseEntity.ok(Boolean.TRUE);
    }
    
    @DeleteMapping(value = "/delete/{pedidoId}")
    public ResponseEntity<Object> deletePedido(@PathVariable int pedidoId){
        this.pedidoService.deleteById(pedidoId);
        return ResponseEntity.ok(Boolean.TRUE);
    }
    
    @PutMapping(value = "/update/{pedidoId}")
    public ResponseEntity<Object> updatePedido(@RequestBody PedidoDTO request, @PathVariable int pedidoId) {
    	
        this.pedidoService.update(request, pedidoId);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
