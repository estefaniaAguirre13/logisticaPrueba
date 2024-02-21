package com.prueba.logisticaPrueba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.logisticaPrueba.services.interfaces.ILogisticaService;


@CrossOrigin("*")
@RestController
@RequestMapping("/logistica/tipos")
public class LogisticaController {

    @Autowired
    private ILogisticaService logisticaService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> index(){
        return ResponseEntity.ok(this.logisticaService.findAll());
    }

    @GetMapping(value = "/{idLogistica}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByIdLogistica(@PathVariable("idLogistica") int idLogistica) {
        return ResponseEntity.ok(this.logisticaService.findByIdLogistica(idLogistica).getPrecioEnvio());
    }

}

