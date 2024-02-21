package com.prueba.logisticaPrueba.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="vehiculo")
public class Vehiculo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id_vehiculo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "placa_vehiculo")
    private String placaVehiculo;

    @ManyToOne
    @JoinColumn(name="id_logistica_vehiculo")
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
