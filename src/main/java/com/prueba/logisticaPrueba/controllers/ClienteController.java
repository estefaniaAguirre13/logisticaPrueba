package com.prueba.logisticaPrueba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prueba.logisticaPrueba.dto.ClienteDTO;
import com.prueba.logisticaPrueba.services.interfaces.IClienteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/logistica/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> index(){
        return ResponseEntity.ok(this.clienteService.findAll());
    }

    @GetMapping(value = "/by/{identificacion}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByIdentificacion(@PathVariable("identificacion") int identificacion) {
        if(!clienteService.existsByIdentificacion(identificacion)) {
            return new ResponseEntity<>("No existen datos para la identificación: " + identificacion,
                    HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(this.clienteService.findByIdentificacion(identificacion));
    }


    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveCliente(@RequestBody ClienteDTO request) {
    	
        if(clienteService.existsByIdentificacion(request.getIdentificacion())) {
            return new ResponseEntity<>("La identificación ingresada ya existe", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if(clienteService.existsByCorreoCliente(request.getCorreoCliente())) {
            return new ResponseEntity<>("El correo ingresado ya existe", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        this.clienteService.save(request);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping(value = "/update/{clienteId}")
    public ResponseEntity<Object> updateCliente(@RequestBody ClienteDTO request, @PathVariable int clienteId) {
        this.clienteService.update(request, clienteId);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @DeleteMapping(value = "/delete/{clienteId}")
    public ResponseEntity<Object> deleteCliente(@PathVariable int clienteId){
        this.clienteService.deleteById(clienteId);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}