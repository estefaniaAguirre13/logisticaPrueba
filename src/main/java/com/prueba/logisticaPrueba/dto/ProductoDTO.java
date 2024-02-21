package com.prueba.logisticaPrueba.dto;

import lombok.Data;

import java.io.Serializable;

import com.prueba.logisticaPrueba.entities.Logistica;

@Data
public class ProductoDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String nombreProducto;
    private Logistica idLogisticaProducto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Logistica getIdLogisticaProducto() {
		return idLogisticaProducto;
	}
	public void setIdLogisticaProducto(Logistica idLogisticaProducto) {
		this.idLogisticaProducto = idLogisticaProducto;
	}

}
