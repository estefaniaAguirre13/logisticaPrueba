package com.prueba.logisticaPrueba.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="almacen")
public class Almacen implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id_almacen")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlmacen;

    @Column(name = "nombre_almacen")
    private String nombreAlmacen;

    @ManyToOne
    @JoinColumn(name="id_logistica_almacen")
    private Logistica idLogisticaAlmacen;

    @ManyToOne
    @JoinColumn(name="id_ciudad_almacen")
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
