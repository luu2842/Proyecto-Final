package com.ibm.academia.restapi.fraudes.modelos.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
	 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryInfoDto {
	 
	private String name;
	private String iso;
	private String currency;
	//private Double currencytoDollar;
	private Double currencyToEuro;   

}
