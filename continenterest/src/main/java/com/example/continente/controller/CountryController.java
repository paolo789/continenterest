package com.example.continente.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.continente.entity.CityBean;
import com.example.continente.entity.CountryBean;
import com.example.continente.repository.CityRepository;
import com.example.continente.repository.CountryRepository;


@RestController
public class CountryController {

	@Autowired
	private CountryRepository cr;
	
	@Autowired
	private CityRepository tr;
	
	@GetMapping("/listacontinenti")
	public List<String> getContinents() {
		List<String> continentList=cr.getContinents();
		return continentList;
	}
	
	@GetMapping("/listanazioni")
	public List<CountryBean> getNations(String continente) {
		List<CountryBean> nations=cr.findByContinent(continente);
		return nations;
	}
	
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
