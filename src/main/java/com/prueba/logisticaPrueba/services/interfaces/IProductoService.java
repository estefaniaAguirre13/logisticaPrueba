package com.prueba.logisticaPrueba.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.logisticaPrueba.dto.ProductoDTO;


@Service
public interface IProductoService {
	List<ProductoDTO> findAll();
	
	ProductoDTO findById(int id);
	
	List<ProductoDTO> findByNombreProducto(String nombreProducto);
	
	List<ProductoDTO> findAllByLogistica(int idLogistica);
	
	void save(ProductoDTO producto);
	
	void update(ProductoDTO producto, int id);
	
	void saveAll(List<ProductoDTO> productos);
	
	void deleteById(int id);
	
	boolean existsByNombreProducto(String nombreProducto);
}
