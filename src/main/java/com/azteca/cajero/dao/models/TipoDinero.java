package com.azteca.cajero.dao.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_dinero")
public class TipoDinero implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String name;
	@OneToMany(mappedBy = "tipoDinero")
	private List<Caja> cajas;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Caja> getCaja() {
		return cajas;
	}

	public void setCaja(List<Caja> cajas) {
		this.cajas = cajas;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
