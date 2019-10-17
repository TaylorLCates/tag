package org.improving.tag.database;

import org.improving.tag.Exit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExitRepository extends CrudRepository<Exit, Long> {

   List<Exit> findAllByOrderByName();
}
