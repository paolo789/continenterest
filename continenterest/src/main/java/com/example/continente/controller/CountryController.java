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
public class CountryController {

	@Autowired
	private CountryRepository cr;
	
	
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
}
