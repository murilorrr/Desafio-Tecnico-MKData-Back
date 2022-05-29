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
import javax.validation.constraints.NotEmpty;

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
  @NotEmpty(message = "Name is mandatory")
  private String name;

  @Column
  @NotEmpty(message = "type is mandatory")
  private String type;

  @Column
  @NotEmpty(message = "Registration number is mandatory")
  private String cadastro_Unico; //cpf - cnpj

  @Column
  @NotEmpty(message = "Inscrition number is mandatory")
  private String inscricao_Unica; // rg - ie

  @Column
  @NotEmpty(message = "Cadastry date is mandatory")
  private LocalDate data_De_Cadastro;
  
  @Column
  @NotEmpty(message = "Activated is mandatory")
  private boolean activated;

  @ManyToOne
  @JoinColumn(name = "group_id")
  @NotEmpty(message = "Group is mandatory")
  private Group group;

  public boolean getActivated() {
    return this.activated;
  }

}
