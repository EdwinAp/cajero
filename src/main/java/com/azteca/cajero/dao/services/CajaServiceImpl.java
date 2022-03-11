package com.azteca.cajero.dao.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azteca.cajero.dao.models.Caja;
import com.azteca.cajero.dao.repositories.ICajaRepository;

@Service
public class CajaServiceImpl implements ICajaService {
	
	@Autowired
	private ICajaRepository iCajaRepository;
	
	@Override
	public ArrayList<Caja> getAllMounts(Double mount){
		ArrayList<Caja> caja = (ArrayList<Caja>) iCajaRepository.findByOrderByDenominacionDesc();
		caja.forEach(System.out::println);
		ArrayList<Caja> retiro = new ArrayList<>();
		int counter = 0;
		while (counter < caja.size()) {
			if (caja.get(counter).getCantidad() > 0 && mount >= caja.get(counter).getDenominacion()) {
				if (retiro.size() == 0) {
					retiro.add(new Caja(1L, caja.get(counter).getDenominacion(), caja.get(counter).getTipoDinero()));
				} else {
					boolean existente = true;
					for (int i = 0; i < retiro.size(); i++) {
						if (retiro.get(i).getDenominacion().equals(caja.get(counter).getDenominacion())) {
							retiro.get(i).incrementCantidad();
							existente = true;
							break;
						} else existente = false;
					}
					if (!existente) {
						retiro.add(new Caja(1L, caja.get(counter).getDenominacion(), caja.get(counter).getTipoDinero()));
					}
				}
				mount = mount - caja.get(counter).getDenominacion();
				caja.get(counter).descrementCantidad();
			} else counter++;
		}
		iCajaRepository.saveAll(caja);
		return retiro;
	}
	
	@Override
	public Boolean validateMount(Double mount) {
		Double maxValue = iCajaRepository.getMaxValue();
		System.out.println("Max Value: " + maxValue);
		return mount <= maxValue;
	}

}
