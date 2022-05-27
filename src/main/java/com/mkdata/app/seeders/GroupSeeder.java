package com.mkdata.app.seeders;

import java.util.ArrayList;
import java.util.List;

import com.mkdata.app.entities.Group;
import com.mkdata.app.repositories.GroupH2Repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GroupSeeder implements CommandLineRunner {

  GroupH2Repository repository;

  @Override
  public void run(String... args) throws Exception {
    loadLaboratorioData();
  }

  private void loadLaboratorioData() {
    Group g1 = new Group(null, "Skynet", true, null);
    Group g2 = new Group(null, "Umbrella", true, null);
    Group g3 = new Group(null, "Osborn", true, null);
  
    List<Group> groups = new ArrayList<Group>(List.of(g1, g2, g3));
    
    if (repository.count() == 0) {
      for (Group group : groups) {
        repository.save(group);
      }
    }
  }

}
