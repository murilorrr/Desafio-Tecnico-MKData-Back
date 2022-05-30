package com.mkdata.app.seeders;

import com.mkdata.app.entities.Customer;
import com.mkdata.app.entities.Group;
import com.mkdata.app.repositories.CustomerH2Repository;
import com.mkdata.app.repositories.GroupH2Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class InitialSeeders implements CommandLineRunner {
  
  CustomerH2Repository repository;

  GroupH2Repository groupH2Repository;

  @Override
  public void run(String... args) throws Exception {
    loadGroupData();
    loadCustomerData();
  }

  private void loadGroupData() {
    Group g1 = new Group(null, "Skynet", true, null);
    Group g2 = new Group(null, "Umbrella", true, null);
    Group g3 = new Group(null, "Osborn", true, null);
  
    List<Group> groups = new ArrayList<Group>(List.of(g1, g2, g3));
    
    if (repository.count() == 0) {
      for (Group group : groups) {
        groupH2Repository.save(group);
      }
    }
  }

  private void loadCustomerData() {
    List<Group> groups = groupH2Repository.findAll();

    Customer c1 = new Customer(null, "Jorge", "cpf",
        "254.241.332-32", "32.332.332-22", LocalDate.now(), true, groups.get(0));
    Customer c2 = new Customer(null, "Fernanda",
        "cpf", "333.525.737-22", "12.231.425-41", LocalDate.now(), true, groups.get(1));
    Customer c3 = new Customer(null, "Klaus",
        "cpf", "515.647.858-65", "55.775.325-66", LocalDate.now(), false, groups.get(2));

    List<Customer> customers = new ArrayList<Customer>(List.of(c1, c2, c3));

    if (repository.count() == 0) {
      for (Customer customer : customers) {
        repository.save(customer);
      }
    }
  }


}
