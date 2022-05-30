package com.mkdata.app.repositories;

import java.util.Optional;

import com.mkdata.app.entities.Group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupH2Repository extends JpaRepository<Group, Long> {
  public Optional<Group> findByName(String name);
  
}
