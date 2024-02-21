package com.prueba.logisticaPrueba.dto;
import lombok.Data;

import java.io.Serializable;

import com.prueba.logisticaPrueba.entities.Ciudad;
import com.prueba.logisticaPrueba.entities.Logistica;

@Data
public class AlmacenDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAlmacen;
    private String nombreAlmacen;
    private Logistica idLogisticaAlmacen;
    private Ciudad idCiudadAlmacen;
	public int getIdAlmacen() {
		return idAlmacen;
	}
	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	public String getNombreAlmacen() {
		return nombreAlmacen;
	}
	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}
	public Logistica getIdLogisticaAlmacen() {
		return idLogisticaAlmacen;
	}
	public void setIdLogisticaAlmacen(Logistica idLogisticaAlmacen) {
		this.idLogisticaAlmacen = idLogisticaAlmacen;
	}
	public Ciudad getIdCiudadAlmacen() {
		return idCiudadAlmacen;
	}
	public void setIdCiudadAlmacen(Ciudad idCiudadAlmacen) {
		this.idCiudadAlmacen = idCiudadAlmacen;
	}
}
