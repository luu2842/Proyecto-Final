package com.ibm.academia.restapi.fraudes.servicios;

import com.ibm.academia.restapi.fraudes.modelos.dtos.CountryInfoDto;
import com.ibm.academia.restapi.fraudes.modelos.dtos.IpDto;

public interface IpServiceI {
	
	   public CountryInfoDto processIp(IpDto dto);
}
