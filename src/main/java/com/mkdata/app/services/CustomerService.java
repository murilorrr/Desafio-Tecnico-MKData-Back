package com.mkdata.app.services;

import java.util.List;

import com.mkdata.app.commons.ErroCadastroUnico;
import com.mkdata.app.commons.ErroNaoEncontrado;
import com.mkdata.app.entities.Customer;
import com.mkdata.app.entities.CustomerDTO;
import com.mkdata.app.entities.Group;
import com.mkdata.app.repositories.CustomerH2Repository;
import com.mkdata.app.repositories.GroupH2Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired
  CustomerH2Repository h2Repository;

  @Autowired
  GroupH2Repository groupH2Repository;

  public Customer create(CustomerDTO customerDTO) throws ErroCadastroUnico, ErroNaoEncontrado {
    Customer customer = new Customer();

    Customer customerValidation = h2Repository.findByCadastro_Unico(customerDTO.getCadastro_Unico());
    if (customerValidation != null) {
      throw new ErroCadastroUnico();
    }

    Group group = groupH2Repository
      .findById((long) customerDTO.getGroup_id())
      .orElseThrow(()-> new ErroNaoEncontrado("Grupo nao existe"));
    
    customer.setName(customerDTO.getName());
    customer.setType(customerDTO.getType());
    customer.setCadastro_Unico(customerDTO.getCadastro_Unico());
    customer.setInscricao_Unica(customerDTO.getInscricao_Unica());
    customer.setData_De_Cadastro(customerDTO.getData_De_Cadastro());
    customer.setActivated(customerDTO.getActivated());
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

  public Customer update(CustomerDTO newCustomer, Long id) throws ErroNaoEncontrado {
    Customer customer = getById(id);

    Group group = groupH2Repository
      .findById((long) newCustomer.getGroup_id())
      .orElseThrow(()-> new ErroNaoEncontrado("Grupo nao existe"));

    customer.setActivated(newCustomer.getActivated());
    customer.setCadastro_Unico(newCustomer.getCadastro_Unico());
    customer.setGroup(group);
    customer.setInscricao_Unica(newCustomer.getInscricao_Unica());
    customer.setName(newCustomer.getName());
    customer.setType(newCustomer.getType());

    return h2Repository.save(customer);
  }

  public void delete(Long id) {
    h2Repository.deleteById(id);
  }
}
