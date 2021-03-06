package com.ibm.academia.restapi.fraudes.modelos.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "black_list")
public class BlackList {
 
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
 
   @Column(unique = true)
   private String ip;
  
  
}
