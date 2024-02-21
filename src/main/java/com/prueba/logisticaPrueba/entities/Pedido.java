package com.prueba.logisticaPrueba.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import com.prueba.logisticaPrueba.utils.utils.Utils;
@Data
@Entity
@Table(name="pedido")
public class Pedido implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id_plan")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlan;

    @ManyToOne
    @JoinColumn(name = "id_cliente_entrega")
    private Cliente idCliente;

    @ManyToOne
    @JoinColumn(name = "id_producto_entrega")
    private Producto idProducto;

    @ManyToOne
    @JoinColumn(name = "id_logistica_entrega")
    private Logistica idLogistica;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo_entrega")
    private Vehiculo idVehiculo;

    @ManyToOne
    @JoinColumn(name = "id_ciudad_entrega")
    private Ciudad idCiudad;

    @ManyToOne
    @JoinColumn(name = "id_almacen_entrega")
    private Almacen idCentro;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_envio")
    private int costoEnvio;

    @Column(name = "precio_pagar")
    private int costoPagar;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Column(name = "fecha_entrega")
    private Date fechaEntrega;

    @Column(name = "guia")
    private String guia;

    @PrePersist
    public void prePersist() {

        Utils generator = new Utils();

        this.fechaRegistro = new Date();
        this.fechaEntrega = generator.dateEntrega(this.fechaRegistro);
        this.guia = generator.generateGuia();
        int id = this.idLogistica.getIdLogistica();
        this.costoPagar = generator.getCostoPagar(id, this.cantidad);
        this.costoEnvio = generator.getCosto(id);
    }

	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public Producto getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}

	public Logistica getIdLogistica() {
		return idLogistica;
	}

	public void setIdLogistica(Logistica idLogistica) {
		this.idLogistica = idLogistica;
	}

	public Vehiculo getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Vehiculo idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Ciudad getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Ciudad idCiudad) {
		this.idCiudad = idCiudad;
	}

	public Almacen getIdCentro() {
		return idCentro;
	}

	public void setIdCentro(Almacen idCentro) {
		this.idCentro = idCentro;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCostoEnvio() {
		return costoEnvio;
	}

	public void setCostoEnvio(int costoEnvio) {
		this.costoEnvio = costoEnvio;
	}

	public int getCostoPagar() {
		return costoPagar;
	}

	public void setCostoPagar(int costoPagar) {
		this.costoPagar = costoPagar;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getGuia() {
		return guia;
	}

	public void setGuia(String guia) {
		this.guia = guia;
	}
    

}
