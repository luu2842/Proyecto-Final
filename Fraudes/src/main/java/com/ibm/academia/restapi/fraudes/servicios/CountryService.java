package com.ibm.academia.restapi.fraudes.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.restapi.fraudes.clientes.CountryClient;
import com.ibm.academia.restapi.fraudes.modelos.dtos.CountryResponseDto;

@Service
public class CountryService implements CountryServiceI {

	@Autowired
	CountryClient countryClient;
	
	@Override
	public CountryResponseDto getinfo(String ip) {
		return countryClient.getInfo(ip);
	}

}
