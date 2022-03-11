package com.azteca.cajero.dao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "caja")
public class Caja implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private Long cantidad;
	@Column(nullable = false)
	private Double denominacion;
	@ManyToOne
	@JoinColumn(name = "tipo_dinero_id", nullable = false)
	private TipoDinero tipoDinero;
	
	public Caja() { }

	public Caja(Long cantidad, Double denominacion, TipoDinero tipoDinero) {
		super();
		this.cantidad = cantidad;
		this.denominacion = denominacion;
		this.tipoDinero = tipoDinero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public Double getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(Double denominacion) {
		this.denominacion = denominacion;
	}

	public TipoDinero getTipoDinero() {
		return tipoDinero;
	}

	public void setTipoDinero(TipoDinero tipoDinero) {
		this.tipoDinero = tipoDinero;
	}
	
	public void descrementCantidad() {
		this.cantidad -= 1;
	}
	
	public void incrementCantidad() {
		this.cantidad += 1;
	}

	@Override
	public String toString() {
		return "Caja [id=" + id + ", cantidad=" + cantidad + ", denominacion=" + denominacion + ", tipoDinero="
				+ tipoDinero.getName() + "]";
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
