package com.ibm.academia.restapi.fraudes.servicios;

import java.util.Optional;
	 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.academia.restapi.fraudes.clientes.CountryClient;
import com.ibm.academia.restapi.fraudes.clientes.CurrencyClient;
import com.ibm.academia.restapi.fraudes.modelos.dtos.CountryInfoDto;
import com.ibm.academia.restapi.fraudes.modelos.dtos.CountryResponseDto;
import com.ibm.academia.restapi.fraudes.modelos.dtos.IpDto;
import com.ibm.academia.restapi.fraudes.modelos.entidades.BlackList;
import com.ibm.academia.restapi.fraudes.modelos.entidades.Exchange;
import com.ibm.academia.restapi.fraudes.modelos.repositorios.BlackListRepository;
import com.ibm.academia.restapi.fraudes.modelos.repositorios.ExchangeRepository;
	 
@Service
public class IpService implements IpServiceI{
	 
	@Autowired
	private CountryClient countryClient;
	
	@Autowired
	private CurrencyClient currencyClient;
	
	@Autowired
	private ExchangeRepository exchangeRepository;
	
	@Autowired
	private BlackListRepository blackListRepository;
	
	@Override
	public CountryInfoDto processIp(IpDto ipdto) {
	      
		CountryResponseDto countryResponse = countryClient.getInfo(ipdto.getIp());
		String currency = currencyClient.getInfo(ipdto.getIp());
		Optional<Exchange> oExchange = exchangeRepository.findByName(currency);
		Double exchange = oExchange.isPresent()?1/oExchange.get().getAmount():Double.NaN;

		 if(!blackListRepository.findByIp(ipdto.getIp()).isPresent()){
			 blackListRepository.save(BlackList.builder().ip(ipdto.getIp()).build());  
	       }
		
		
	       	return CountryInfoDto.builder()
	       	.name(!countryResponse.getCountryName().isEmpty()?countryResponse.getCountryName():"name empty")
	       	.iso(!countryResponse.getCountryCode3().isEmpty()?countryResponse.getCountryCode3():"iso empty")
	       	.currency(!currency.isEmpty()?currency:"currency empty")
	       	.currencyToEuro(exchange)
	       	.build();       
	   }
	 

}
