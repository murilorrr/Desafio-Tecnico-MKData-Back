package com.mkdata.app.controllers;

import java.util.List;

import com.mkdata.app.commons.ErroNaoEncontrado;
import com.mkdata.app.entities.Group;
import com.mkdata.app.services.GroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

  @Autowired
  GroupService groupService;
  
  @PostMapping("/groups")
  public Group createGroup(@RequestBody Group group) {
    return groupService.create(group);
  }

  @GetMapping("/groups")
  public List<Group> getGroups() {
    return groupService.getAll();
  }

  @PutMapping("/groups")
  public Group updateGroup(Group group, Long id) throws ErroNaoEncontrado {
    return groupService.update(group, id);
  }

  @DeleteMapping("/groups")
  public void deleteGroup(Long id) {
    groupService.delete(id);
  }

}
