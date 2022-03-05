package com.ibm.academia.restapi.fraudes.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.academia.restapi.fraudes.modelos.dtos.FixierResponseDto;
 
 
@FeignClient(value = "fixier", url = "http://data.fixer.io/api/")
public interface FixierClient {
 
   @RequestMapping(method = RequestMethod.GET, value = "/latest", produces = "application/json")
   FixierResponseDto getAll(@RequestParam String access_key, @RequestParam String base );
  
}