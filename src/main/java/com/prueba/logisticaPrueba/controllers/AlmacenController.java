package com.prueba.logisticaPrueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prueba.logisticaPrueba.dto.AlmacenDTO;
import com.prueba.logisticaPrueba.services.interfaces.IAlmacenService;
import com.prueba.logisticaPrueba.services.interfaces.ICiudadService;

@CrossOrigin("*")
@RestController
@RequestMapping("/logistica/almacenes")
public class AlmacenController {

    @Autowired
    private IAlmacenService almacenService;
    @Autowired
    private ICiudadService ciudadService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlmacenDTO>> index(){
        return ResponseEntity.ok(this.almacenService.findAll());
    }

    @GetMapping(value = "/by/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByNombreAlmacen(@PathVariable("nombre") String nombreAlmacen) {
        if(!almacenService.existsByNombreAlmacen(nombreAlmacen))
            return new ResponseEntity<>("No existen datos para el almacen: " + nombreAlmacen,
                    HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(this.almacenService.findByNombreAlmacen(nombreAlmacen));
    }

    @GetMapping(value = "/byAlmacen/{idLogistica}_{idCiudad}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlmacenDTO>> findByAllLogisticaCiudad(@PathVariable("idLogistica") int idLogistica, @PathVariable("idCiudad") int idCiudad) {
        return ResponseEntity.ok(this.almacenService.findAllByLogisticaAndCiudad(idLogistica, idCiudad));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveAlmacen(@RequestBody AlmacenDTO request) {
        if(this.almacenService.existsByNombreAlmacen(request.getNombreAlmacen())) {
            return new ResponseEntity<>("Ya existe el nombre del almacen: "+request.getNombreAlmacen(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        
        if(this.ciudadService.findById(request.getIdCiudadAlmacen().getId()) == null) {
            return new ResponseEntity<>("El id con esa ciudad no existe", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        this.almacenService.save(request);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping(value = "/update/{almacenId}")
    public ResponseEntity<Object> updateAlmacen(@RequestBody AlmacenDTO request, @PathVariable int almacenId) {
        this.almacenService.update(request, almacenId);
        if(this.ciudadService.findById(request.getIdCiudadAlmacen().getId()) == null) {
            return new ResponseEntity<>("El id con esa ciudad no existe", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return ResponseEntity.ok(Boolean.TRUE);
    }
    
    @DeleteMapping(value = "/delete/{almacenId}")
    public ResponseEntity<Object> deleteAlmacen(@PathVariable int almacenId){
        this.almacenService.deleteById(almacenId);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}

