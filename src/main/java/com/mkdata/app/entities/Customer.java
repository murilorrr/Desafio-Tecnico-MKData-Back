package com.mkdata.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_CUSTOMER")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String name;

  @Column
  private String type;

  @Column
  private String cadastro_Unico; //cpf - cnpj

  @Column
  private String inscricao_Unica; // rg - ie

  @Column
  private LocalDate data_De_Cadastro;
  
  @Column
  private boolean activated;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;

  public boolean getActivated() {
    return this.activated;
  }

}
