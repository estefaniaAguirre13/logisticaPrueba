package com.prueba.logisticaPrueba.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="producto")
public class Producto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id_producto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @ManyToOne
    @JoinColumn(name="id_logistica_producto")
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