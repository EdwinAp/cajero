package com.azteca.cajero.dao.services;

import java.util.ArrayList;

import com.azteca.cajero.dao.models.Caja;

public interface ICajaService {
	
	public Boolean validateMount(Double mount);
	
	public ArrayList<Caja> getAllMounts(Double mount);
	

}
