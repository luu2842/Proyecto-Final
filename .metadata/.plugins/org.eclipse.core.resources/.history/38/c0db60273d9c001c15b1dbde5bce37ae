package com.ibm.academia.restapi.fraudes;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.ibm.academia.restapi.fraudes.clientes.FixierClient;
import org.springframework.beans.factory.annotation.Value;
import com.ibm.academia.restapi.fraudes.modelos.dtos.FixierResponseDto;
import com.ibm.academia.restapi.fraudes.modelos.entidades.Exchange;
import com.ibm.academia.restapi.fraudes.modelos.repositorios.ExchangeRepository;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class FraudesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FraudesApplication.class, args);
	}
	
	@Autowired
	private ExchangeRepository exchangeRepository;

	@Autowired
	private FixierClient fixierClient;

	@Value("${fixier.key}")
	private String accessKey;

	@Override
	public void run(String... arg0) throws Exception {
    FixierResponseDto fixierResponseDto = fixierClient.getAll(accessKey, "EUR");
    System.out.println( fixierResponseDto.getBase() );
    String s = fixierResponseDto.getRates().toString();
    s = s.substring(1, s.length()-1);
    List<String> l = Arrays.asList(s.split(", "));
    for (String st : l) {
        String[] splt = st.split("=");
        Exchange exchange = Exchange.builder()
        .name(splt[0])
        .amount( Double.valueOf(splt[1]) )
        .build();
        exchangeRepository.save(exchange);        
    }
    System.out.println("total save: "+exchangeRepository.count());
	}
}