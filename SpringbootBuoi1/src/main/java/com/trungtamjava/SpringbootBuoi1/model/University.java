package com.trungtamjava.SpringbootBuoi1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class University {
   private int id;
   private String tentruong;
   private String vitri;
   private int xephang;
   private String loaidaotao;
}
