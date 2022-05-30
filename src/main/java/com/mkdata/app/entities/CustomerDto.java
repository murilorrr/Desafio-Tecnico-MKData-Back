package com.mkdata.app.entities;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerDto {
  @NotEmpty(message = "Name is mandatory")
  private String name;

  @NotEmpty(message = "type is mandatory")
  private String type;

  @NotEmpty(message = "Registration number is mandatory")
  private String cadastroUnico;

  @NotEmpty(message = "Inscrition number is mandatory")
  private String inscricaoUnica;

  @NotNull(message = "Cadastry date is mandatory")
  private LocalDate dataDeCadastro;

  @NotNull(message = "Activated is mandatory")
  private boolean activated;

  @NotNull(message = "Group is mandatory")
  private String group;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public LocalDate getDataDeCadastro() {
    return dataDeCadastro;
  }

  public void setDataDeCadastro(LocalDate dataDeCadastro) {
    this.dataDeCadastro = dataDeCadastro;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public String getCadastroUnico() {
    return cadastroUnico;
  }

  public void setCadastroUnico(String cadastroUnico) {
    this.cadastroUnico = cadastroUnico;
  }

  public String getInscricaoUnica() {
    return inscricaoUnica;
  }

  public void setInscricaoUnica(String inscricaoUnica) {
    this.inscricaoUnica = inscricaoUnica;
  }

  public boolean isActivated() {
    return activated;
  }

  public void setActivated(boolean activated) {
    this.activated = activated;
  }

}
