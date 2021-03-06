package com.ibm.academia.restapi.fraudes.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
 
@FeignClient(value = "currency", url = "https://ipapi.co/")
public interface CurrencyClient {
 
   @RequestMapping(method = RequestMethod.GET, value = "/{ipsend}/currency")
   String getInfo(@PathVariable("ipsend") String ipsend );
  
}
