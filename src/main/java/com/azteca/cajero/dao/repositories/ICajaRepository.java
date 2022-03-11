package com.azteca.cajero.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.azteca.cajero.dao.models.Caja;

public interface ICajaRepository extends CrudRepository<Caja, Integer> {

	public List<Caja> findByOrderByDenominacionDesc();
	
	@Query("SELECT SUM(cantidad * denominacion)	FROM Caja")
	public Double getMaxValue();
}
