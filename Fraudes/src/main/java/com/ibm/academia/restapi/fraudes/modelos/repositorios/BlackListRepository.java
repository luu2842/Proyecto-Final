package com.ibm.academia.restapi.fraudes.modelos.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.restapi.fraudes.modelos.entidades.BlackList;
 
@Repository
public interface BlackListRepository extends JpaRepository<BlackList,Integer>{
	
   public Optional<BlackList> findByIp(String ip);

}
