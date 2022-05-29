package com.mkdata.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_GROUP")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Group {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @Column
  @NotEmpty(message = "Name is mandatory")
  private String name;

  @Column
  @NotEmpty(message = "Activated is mandatory")
  private boolean activated;
  
  @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Customer> customers;

  public boolean getActivated() {
    return this.activated;
  }

}
