package com.mkdata.app.services;

import com.mkdata.app.commons.ErroCadastroUnico;
import com.mkdata.app.commons.ErroNaoEncontrado;
import com.mkdata.app.entities.Customer;
import com.mkdata.app.entities.CustomerDto;
import com.mkdata.app.entities.Group;
import com.mkdata.app.repositories.CustomerH2Repository;
import com.mkdata.app.repositories.GroupH2Repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired
  CustomerH2Repository h2Repository;

  @Autowired
  GroupH2Repository groupH2Repository;

  /**
   * .
   */
  public Customer create(CustomerDto customerDto)
      throws ErroCadastroUnico, ErroNaoEncontrado {
    
    Customer customerValidation = h2Repository.findByCadastroUnico(customerDto.getCadastroUnico());
    if (customerValidation != null) {
      throw new ErroCadastroUnico();
    }
    
    Group group;
    group = groupH2Repository
    .findByName(customerDto.getGroup())
    .orElseThrow(() -> new ErroNaoEncontrado("Grupo nao existe"));
    
    Customer customer = new Customer();
    customer.setName(customerDto.getName());
    customer.setType(customerDto.getType());
    customer.setCadastroUnico(customerDto.getCadastroUnico());
    customer.setInscricaoUnica(customerDto.getInscricaoUnica());
    customer.setDataDeCadastro(customerDto.getDataDeCadastro());
    customer.setActivated(customerDto.isActivated());
    customer.setGroup(group);

    return h2Repository.save(customer);
  }

  public List<Customer> getAll() {
    return h2Repository.findAll();
  }

  public Customer getById(Long id) throws ErroNaoEncontrado {
    return h2Repository.findById(id).orElseThrow(
      () -> new ErroNaoEncontrado("Usuário nao existe"));
  }

  /**
   * .
  */
  public Customer update(CustomerDto newCustomer, Long id) throws ErroNaoEncontrado {
    Customer customer = getById(id);

    Group group = groupH2Repository
        .findByName(newCustomer.getGroup())
        .orElseThrow(() -> new ErroNaoEncontrado("Grupo nao existe"));

    customer.setActivated(newCustomer.isActivated());
    customer.setCadastroUnico(newCustomer.getCadastroUnico());
    customer.setGroup(group);
    customer.setInscricaoUnica(newCustomer.getInscricaoUnica());
    customer.setName(newCustomer.getName());
    customer.setType(newCustomer.getType());

    return h2Repository.save(customer);
  }

  public void delete(Long id) {
    h2Repository.deleteById(id);
  }
}
