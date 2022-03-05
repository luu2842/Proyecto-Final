package com.ibm.academia.restapi.fraudes.clientes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.academia.restapi.fraudes.modelos.dtos.CountryResponseDto; 
 
@FeignClient(value = "country", url = "https://api.ip2country.info/")
public interface CountryClient {
 
   @GetMapping("/ip?{ipsend}")
   CountryResponseDto getInfo(@PathVariable("ipsend") String ipsend );
  
}
