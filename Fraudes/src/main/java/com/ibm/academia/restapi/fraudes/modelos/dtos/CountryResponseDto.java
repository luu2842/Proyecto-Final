package com.ibm.academia.restapi.fraudes.modelos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryResponseDto {
	
	private String countryCode3;
	private String countryName;
}
