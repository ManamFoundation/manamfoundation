package org.manam.webapp.rest;

import org.manam.webapp.business.PeopleService;
import org.manam.webapp.business.PeopleTransform;
import org.manam.webapp.dao.domain.People;
import org.manam.webapp.rest.dto.PeopleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kasar on 12/21/2017.
 */
@RestController
public class PeopleController {

    @Autowired
    PeopleService peopleService;
    @Autowired
    PeopleTransform peopleTransform;

    @RequestMapping(value = "/api/people")
    public List<PeopleDTO> getPeople(){
    Iterable<People> people = peopleService.getPeople();
   return  peopleTransform.getAllPeople(people);

    }

    @RequestMapping(value="/api/people", method = RequestMethod.POST)
    public Long savePeople(@RequestBody PeopleDTO peopleDTO){
       People people = peopleTransform.savePeople(peopleDTO);
        return  peopleService.savePeople(people);
    }
}
