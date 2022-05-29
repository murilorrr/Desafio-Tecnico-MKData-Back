package com.mkdata.app.entities;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerDTO {
  @NotEmpty(message = "Name is mandatory")
  private String name;

  @NotEmpty(message = "type is mandatory")
  private String type;

  @NotEmpty(message = "Registration number is mandatory")
  private String cadastro_Unico; //cpf - cnpj

  @NotEmpty(message = "Inscrition number is mandatory")
  private String inscricao_Unica; // rg - ie

  @NotEmpty(message = "Cadastry date is mandatory")
  private LocalDate data_De_Cadastro;

  @NotEmpty(message = "Activated is mandatory")
  private boolean activated;

  @NotEmpty(message = "Group is mandatory")
  private int group_id;

  public boolean getActivated() {
    return this.activated;
  }
}
