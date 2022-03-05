package com.ibm.academia.restapi.fraudes.servicios;

import com.ibm.academia.restapi.fraudes.modelos.dtos.CountryResponseDto;

public interface CountryServiceI {
	
	public CountryResponseDto getinfo(String ip);

}
