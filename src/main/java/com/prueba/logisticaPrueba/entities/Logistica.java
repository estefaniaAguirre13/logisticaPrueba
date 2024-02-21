package com.prueba.logisticaPrueba.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="logistica")
public class Logistica implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id_logistica")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLogistica;

    @Column(name = "tipo_logistica")
    private String tipoLogistica;

    @Column(name = "precio_envio")
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