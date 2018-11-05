package com.example.continente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.continente.entity.CityBean;
import com.example.continente.entity.CountryBean;

public interface CityRepository  extends JpaRepository<CityBean, Integer>{
	public List<CityBean>findByCountryCode(String nazione);
	public List<CityBean>findByNameStartingWith(String citta);
}
