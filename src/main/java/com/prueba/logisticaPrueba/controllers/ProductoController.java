package com.prueba.logisticaPrueba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.logisticaPrueba.dto.ProductoDTO;
import com.prueba.logisticaPrueba.services.interfaces.IProductoService;


@CrossOrigin("*")
@RestController
@RequestMapping("/logistica/productos")
public class ProductoController {

	@Autowired
    private IProductoService productoService;
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> index(){
        return ResponseEntity.ok(this.productoService.findAll());
    }
	
	@GetMapping(value = "/byLogistica/{idLogistica}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByAllLogistica(@PathVariable("idLogistica") int idLogistica) {
		return ResponseEntity.ok(this.productoService.findAllByLogistica(idLogistica));
    }
	
	@GetMapping(value = "/by/{nombreProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findByNombreProducto(@PathVariable("nombreProducto") String nombreProducto) {
	    if (!this.productoService.existsByNombreProducto(nombreProducto)) {
	        return new ResponseEntity<>("No existen datos para el producto: " + nombreProducto,
	                HttpStatus.BAD_REQUEST);
	    }
	    return ResponseEntity.ok(this.productoService.findByNombreProducto(nombreProducto));
	}
	
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveProducto(@RequestBody ProductoDTO request) {
        this.productoService.save(request);
        return ResponseEntity.ok(Boolean.TRUE);
    }

	@PutMapping(value = "/update/{productioId}")
    public ResponseEntity<Object> updateProducto(@RequestBody ProductoDTO request, @PathVariable int productioId) {
        this.productoService.update(request, productioId);
        return ResponseEntity.ok(Boolean.TRUE);
    }
	
    @DeleteMapping(value = "/delete/{productioId}")
    public ResponseEntity<Object> deleteProducto(@PathVariable int productioId){
        this.productoService.deleteById(productioId);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
