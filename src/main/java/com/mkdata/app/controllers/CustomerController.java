package com.mkdata.app.controllers;

import com.mkdata.app.commons.ErroCadastroUnico;
import com.mkdata.app.commons.ErroNaoEncontrado;
import com.mkdata.app.entities.Customer;
import com.mkdata.app.entities.CustomerDto;
import com.mkdata.app.services.CustomerService;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {
  
  @Autowired
  CustomerService service;
  
  @PostMapping("/customers")
  public Customer createCustomer(@Valid @RequestBody CustomerDto customer)
      throws ErroCadastroUnico, ErroNaoEncontrado {
    return service.create(customer);
  }

  @GetMapping("/customers")
  public List<Customer> getAllCustomers() {
    return service.getAll();
  }

  @PutMapping("/customers/{id}")
  public Customer updateCustomer(@Valid @RequestBody CustomerDto customer,@PathVariable Long id)
      throws ErroNaoEncontrado {
    return service.update(customer, id);
  }

  @DeleteMapping("/customers/{id}")
  public void deleteGroup(@PathVariable Long id) {
    service.delete(id);
  }

}
