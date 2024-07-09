package org.example.splitwise.Repositorys;

import org.example.splitwise.Models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group ,Long> {

    Optional<Group> findAllById(Long groupId);
}
