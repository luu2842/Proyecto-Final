package com.ibm.academia.restapi.fraudes.modelos.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.restapi.fraudes.modelos.entidades.Exchange;
	 
@Repository
public interface ExchangeRepository extends JpaRepository<Exchange,Integer>{

	public Optional<Exchange> findByName(String name);

}
