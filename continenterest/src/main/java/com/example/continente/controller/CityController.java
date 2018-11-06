package com.example.continente.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.continente.entity.CityBean;
import com.example.continente.entity.CountryBean;
import com.example.continente.repository.CityRepository;
import com.example.continente.repository.CountryRepository;

@RestController
@RequestMapping("/citta")
public class CityController {

	@Autowired
	private CityRepository tr;
	
	@GetMapping("/listacitta/{nazione}")
	public List<CityBean> getCity(@PathVariable("nazione") String nazione) {
		List<CityBean> cities=tr.findByCountryCode(nazione);
		return cities;
	}
	
	@GetMapping("/cercacitta")
	public List<CityBean> cercaCitta(@RequestParam("citta") String citta) {
		List<CityBean> cities=tr.findByNameStartingWith(citta);
		return cities;
	}
	@PostMapping("/add-modify")
	public CityBean aggiungimodifica(@RequestBody CityBean city) {
		city=tr.save(city);
		return city;
	}
	@PostMapping("/elimina/{id}")
	public void elimina(@PathVariable("id") Integer id) {
		Optional<CityBean> cityOptional=tr.findById(id);
		CityBean city=cityOptional.get();
		tr.delete(city);
	}
}
