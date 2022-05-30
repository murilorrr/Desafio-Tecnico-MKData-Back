package com.mkdata.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_GROUP")
@AllArgsConstructor
@NoArgsConstructor
public class Group {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  @NotEmpty(message = "Name is mandatory")
  private String name;

  @Column
  @NotNull(message = "Activated is mandatory")
  private boolean activated;

  @OneToMany(mappedBy = "group", cascade = CascadeType.ALL,
      orphanRemoval = true, fetch = FetchType.LAZY)
  @JsonIgnore
  private List<Customer> customers;

  public boolean getActivated() {
    return this.activated;
  }

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

  public boolean isActivated() {
    return activated;
  }

  public void setActivated(boolean activated) {
    this.activated = activated;
  }

  public List<Customer> getCustomers() {
    return customers;
  }

  public void setCustomers(List<Customer> customers) {
    this.customers = customers;
  }

}
