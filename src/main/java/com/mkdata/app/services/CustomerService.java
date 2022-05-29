package com.mkdata.app.services;

import java.util.List;

import com.mkdata.app.commons.ErroNaoEncontrado;
import com.mkdata.app.entities.Customer;
import com.mkdata.app.repositories.CustomerH2Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired
  CustomerH2Repository h2Repository;

  public Customer create(Customer customer) {
    return h2Repository.save(customer);
  }

  public List<Customer> getAll() {
    return h2Repository.findAll();
  }

  public Customer getById(Long id) throws ErroNaoEncontrado {
    return h2Repository.findById(id).orElseThrow(
      () -> new ErroNaoEncontrado("Usuário nao existe"));
  }

  public Customer update(Customer newCustomer, Long id) throws ErroNaoEncontrado{
    Customer customer = getById(id);

    valitationCustomer(newCustomer);

    customer.setActivated(newCustomer.getActivated());
    customer.setCadastro_Unico(newCustomer.getCadastro_Unico());
    customer.setGroup(newCustomer.getGroup());
    customer.setInscricao_Unica(newCustomer.getInscricao_Unica());
    customer.setName(newCustomer.getName());
    customer.setType(newCustomer.getType());

    return h2Repository.save(customer);
  }

  public void delete(Long id) {
    h2Repository.deleteById(id);
  }

  private void valitationCustomer(Customer customer) {
    customer.getActivated();
    customer.getCadastro_Unico();
    customer.getData_De_Cadastro();
    customer.getGroup();
    customer.getId();
    customer.getInscricao_Unica();
    customer.getName();
    customer.getType();
  }
}
