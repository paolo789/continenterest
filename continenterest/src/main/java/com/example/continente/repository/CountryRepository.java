package com.example.continente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.continente.entity.CountryBean;

public interface CountryRepository extends JpaRepository<CountryBean, Integer> {
	@Query(value="select distinct c.continent from CountryBean c")
	public List<String> getContinents();
	
	public List<CountryBean>findByContinent(String continente);
}


