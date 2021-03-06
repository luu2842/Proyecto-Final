package com.ibm.academia.restapi.fraudes.controladores;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.restapi.fraudes.modelos.dtos.CountryInfoDto;
import com.ibm.academia.restapi.fraudes.modelos.dtos.IpDto;
import com.ibm.academia.restapi.fraudes.modelos.repositorios.BlackListRepository;
import com.ibm.academia.restapi.fraudes.servicios.IpServiceI;
import com.ibm.academia.restapi.fraudes.servicios.RequestService;

@RestController
@RequestMapping("/ip")
public class IpController {

	private final static Logger logger = LoggerFactory.getLogger(IpController.class);
	
	   @Autowired
	   private RequestService requestService;
	   @Autowired
	   private IpServiceI ipService;
	 
	   @Autowired
	   private BlackListRepository blackListRepository;
	 
	   /**
	    * 
	    * @param dto
	    * @param request
	    * @return
	    */
	   @PostMapping
	   public ResponseEntity<CountryInfoDto> getInfo(@RequestBody IpDto dto, HttpServletRequest request){
	       String clientIp = requestService.getClientIp(request);   
	       System.out.println(clientIp);
	       if(blackListRepository.findByIp(clientIp).isPresent()){
	           return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);   
	       }
	       return new ResponseEntity<>(
	           ipService.processIp(dto), HttpStatus.ACCEPTED);
	   }
	  

}
