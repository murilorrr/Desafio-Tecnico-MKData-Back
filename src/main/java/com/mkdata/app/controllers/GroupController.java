package com.mkdata.app.controllers;

import com.mkdata.app.commons.ErroNaoEncontrado;
import com.mkdata.app.entities.Group;
import com.mkdata.app.services.GroupService;

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
public class GroupController {

  @Autowired
  GroupService groupService;
  
  @PostMapping("/groups")
  public Group createGroup(@Valid @RequestBody Group group) {
    return groupService.create(group);
  }

  @GetMapping("/groups")
  public List<Group> getGroups() {
    return groupService.getAll();
  }

  @PutMapping("/groups/{id}")
  public Group updateGroup(@Valid @RequestBody Group group,@PathVariable Long id)
      throws ErroNaoEncontrado {
    return groupService.update(group, id);
  }

  @DeleteMapping("/groups/{id}")
  public void deleteGroup(@PathVariable Long id) {
    groupService.delete(id);
  }

}
