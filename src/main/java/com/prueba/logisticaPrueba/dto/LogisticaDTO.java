package com.prueba.logisticaPrueba.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LogisticaDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idLogistica;
    private String tipoLogistica;
    private int precioEnvio;
	public int getIdLogistica() {
		return idLogistica;
	}
	public void setIdLogistica(int idLogistica) {
		this.idLogistica = idLogistica;
	}
	public String getTipoLogistica() {
		return tipoLogistica;
	}
	public void setTipoLogistica(String tipoLogistica) {
		this.tipoLogistica = tipoLogistica;
	}
	public int getPrecioEnvio() {
		return precioEnvio;
	}
	public void setPrecioEnvio(int precioEnvio) {
		this.precioEnvio = precioEnvio;
	}

}
