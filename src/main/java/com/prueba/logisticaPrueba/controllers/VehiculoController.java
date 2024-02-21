package com.prueba.logisticaPrueba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prueba.logisticaPrueba.dto.VehiculoDTO;
import com.prueba.logisticaPrueba.services.interfaces.IVehiculoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/logistica/vehiculos")
public class VehiculoController {

    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> index(){
        return ResponseEntity.ok(this.vehiculoService.findAll());
    }

    @GetMapping(value = "/by/{placaVehiculo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByPlacaVehiculo(@PathVariable("placaVehiculo") String placaVehiculo) {
        if (!this.vehiculoService.existsByPlacaVehiculo(placaVehiculo)) {
            return new ResponseEntity<>("No existen datos para la Placa: " + placaVehiculo,
                    HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(this.vehiculoService.findByPlacaVehiculo(placaVehiculo));
    }

    @GetMapping(value = "/byLogistica/{idLogistica}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByAllLogistica(@PathVariable("idLogistica") int idLogistica) {
        return ResponseEntity.ok(this.vehiculoService.findAllByLogistica(idLogistica));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@RequestBody VehiculoDTO request) {
        if (this.vehiculoService.existsByPlacaVehiculo(request.getPlacaVehiculo())) {
            return new ResponseEntity<>("La placa ingresada ya existe", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (request.getIdLogisticaVehiculo().getIdLogistica() == 1) {
            String placa = request.getPlacaVehiculo();
            if (!placa.matches("[A-Z]{3}[0-9]{3}")) {
                return new ResponseEntity<>("La placa debe contener tres letras y tres números.", HttpStatus.BAD_REQUEST);
            }
        } else if (request.getIdLogisticaVehiculo().getIdLogistica() == 2) {
            String placa = request.getPlacaVehiculo();
            if (!placa.matches("[A-Z]{3}[0-9]{4}[A-Z]{1}")) {
                return new ResponseEntity<>("La placa debe contener tres letras, cuatro números y una letra.", HttpStatus.BAD_REQUEST);
            }
        }
        this.vehiculoService.save(request);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @DeleteMapping(value = "/delete/{vehiculoId}")
    public ResponseEntity<Object> deleteVehiculo(@PathVariable int vehiculoId){
        this.vehiculoService.deleteById(vehiculoId);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping(value = "/update/{vehiculoId}")
    public ResponseEntity<Object> updateVehiculo(@RequestBody VehiculoDTO request, @PathVariable int vehiculoId) {
        this.vehiculoService.update(request, vehiculoId);
        if (request.getIdLogisticaVehiculo().getIdLogistica() == 1) {
            String placa = request.getPlacaVehiculo();
            if (!placa.matches("[A-Z]{3}[0-9]{3}")) {
                return new ResponseEntity<>("La placa debe contener tres letras y tres números.", HttpStatus.BAD_REQUEST);
            }
        } else if (request.getIdLogisticaVehiculo().getIdLogistica() == 2) {
            String placa = request.getPlacaVehiculo();
            if (!placa.matches("[A-Z]{3}[0-9]{4}[A-Z]{1}")) {
                return new ResponseEntity<>("La placa debe contener tres letras, cuatro números y una letra.", HttpStatus.BAD_REQUEST);
            }
        }
        return ResponseEntity.ok(Boolean.TRUE);
    }


}
