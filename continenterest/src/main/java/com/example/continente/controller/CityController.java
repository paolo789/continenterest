package com.example.continente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.continente.entity.CityBean;
import com.example.continente.entity.CountryBean;
import com.example.continente.repository.CityRepository;
import com.example.continente.repository.CountryRepository;

@RestController
public class CityController {

	@Autowired
	private CityRepository tr;
	
	@GetMapping("/listacitta")
	public List<CityBean> getCity(String nazione) {
		List<CityBean> cities=tr.findByCountryCode(nazione);
		return cities;
	}
	
	@GetMapping("/cercacitta")
	public List<CityBean> cercaCitta(String citta) {
		List<CityBean> cities=tr.findByNameStartingWith(citta);
		return cities;
	}
	@PostMapping("/addmodify")
	public CityBean aggiungimodifica(@RequestBody CityBean city) {
		city=tr.save(city);
		return city;
	}
	@PostMapping("/elimina")
	public void elimina(@RequestBody CityBean city) {
		tr.delete(city);
	}
	
	
}
