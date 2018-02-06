package org.manam.webapp.dao;

import org.manam.webapp.dao.domain.People;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kasar on 12/21/2017.
 */
@Repository
public interface PeopleRepository extends CrudRepository<People, Long>{

}
