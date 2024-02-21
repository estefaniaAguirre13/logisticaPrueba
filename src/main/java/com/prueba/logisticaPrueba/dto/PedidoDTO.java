package com.prueba.logisticaPrueba.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import com.prueba.logisticaPrueba.entities.Almacen;
import com.prueba.logisticaPrueba.entities.Ciudad;
import com.prueba.logisticaPrueba.entities.Cliente;
import com.prueba.logisticaPrueba.entities.Logistica;
import com.prueba.logisticaPrueba.entities.Producto;
import com.prueba.logisticaPrueba.entities.Vehiculo;

@Data
public class PedidoDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPlan;
    private Cliente idCliente;
    private Producto idProducto;
    private Logistica idLogistica;
    private Vehiculo idVehiculo;
    private Ciudad idCiudad;
    private Almacen idCentro;
    private int cantidad;
    private int costoEnvio;
    private int costoPagar;
    private Date fechaRegistro;
    private Date fechaEntrega;
    private String guia;
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
