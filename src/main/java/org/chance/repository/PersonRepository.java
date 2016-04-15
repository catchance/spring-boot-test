package org.chance.repository;

import org.chance.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by wqg on 2016/3/12.
 */

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {

}

