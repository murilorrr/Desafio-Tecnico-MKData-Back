package com.mkdata.app.services;

import java.util.List;

import com.mkdata.app.commons.ErroNaoEncontrado;
import com.mkdata.app.entities.Group;
import com.mkdata.app.repositories.GroupH2Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

  @Autowired
  GroupH2Repository h2Repository;

  public Group create(Group group) {
    return h2Repository.save(group);
  }

  public List<Group> getAll() {
    return h2Repository.findAll();
  }

  public Group getById(Long id) throws ErroNaoEncontrado {
    return h2Repository.findById(id).orElseThrow(
      () -> new ErroNaoEncontrado("Grupo nao existe"));
  }

  public Group update(Group newGroup, Long id) throws ErroNaoEncontrado{
    Group group = getById(id);

    group.setName(newGroup.getName());
    group.setActivated(newGroup.getActivated());

    return h2Repository.save(group);
  }

  public void delete(Long id) {
    h2Repository.deleteById(id);
  }
}
