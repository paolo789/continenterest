package com.example.continente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.continente.entity.CityBean;
import com.example.continente.repository.CityRepository;

public class CityController {

	@Autowired
	private CityRepository tr;
	
	
	
	@GetMapping("/cercacitta")
	public List<CityBean> cercaCitta(String citta) {
		List<CityBean> cities=tr.findByNameStartingWith(citta);
		return cities;
	}
}
