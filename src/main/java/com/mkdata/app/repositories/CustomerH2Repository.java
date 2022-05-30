package com.mkdata.app.repositories;

import com.mkdata.app.entities.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerH2Repository extends JpaRepository<Customer, Long> {
  public Customer findByName(String name);

  public Customer findByCadastroUnico(String cadastroUnico);
}
