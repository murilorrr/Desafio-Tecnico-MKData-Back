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
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_CUSTOMER")
@AllArgsConstructor
@NoArgsConstructor
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
  private String cadastroUnico;

  @Column
  @NotEmpty(message = "Inscrition number is mandatory")
  private String inscricaoUnica;

  @Column
  @NotNull(message = "Cadastry date is mandatory")
  private LocalDate dataDeCadastro;

  @Column
  @NotNull(message = "Activated is mandatory")
  private boolean activated;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public LocalDate getDataDeCadastro() {
    return dataDeCadastro;
  }

  public void setDataDeCadastro(LocalDate dataDeCadastro) {
    this.dataDeCadastro = dataDeCadastro;
  }

  public boolean isActivated() {
    return activated;
  }

  public void setActivated(boolean activated) {
    this.activated = activated;
  }

  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

}
