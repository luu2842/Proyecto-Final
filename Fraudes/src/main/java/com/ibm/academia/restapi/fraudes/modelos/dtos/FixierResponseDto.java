package com.ibm.academia.restapi.fraudes.modelos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixierResponseDto {
	
	   private String base;
	   //private ArrayList<Map<String,Double>> rates;
	   private Object rates;
	   
}
