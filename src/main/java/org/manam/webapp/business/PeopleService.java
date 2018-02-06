package org.manam.webapp.business;

import org.manam.webapp.dao.PeopleRepository;
import org.manam.webapp.dao.domain.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by kasar on 12/21/2017.
 */
@Service
@Transactional
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    public Iterable<People> getPeople(){
       return peopleRepository.findAll();
    }
    public Long savePeople(People people){
     return   peopleRepository.save(people).getId();
    }

}
