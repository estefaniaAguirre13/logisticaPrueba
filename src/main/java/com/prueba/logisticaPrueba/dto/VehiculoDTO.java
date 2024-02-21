package com.prueba.logisticaPrueba.dto;

import lombok.Data;

import java.io.Serializable;

import com.prueba.logisticaPrueba.entities.Logistica;

@Data
public class VehiculoDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String placaVehiculo;
    private Logistica idLogisticaVehiculo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlacaVehiculo() {
		return placaVehiculo;
	}
	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}
	public Logistica getIdLogisticaVehiculo() {
		return idLogisticaVehiculo;
	}
	public void setIdLogisticaVehiculo(Logistica idLogisticaVehiculo) {
		this.idLogisticaVehiculo = idLogisticaVehiculo;
	}
}
