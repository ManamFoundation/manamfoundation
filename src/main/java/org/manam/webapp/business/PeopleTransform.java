package org.manam.webapp.business;

import org.manam.webapp.dao.domain.People;
import org.manam.webapp.rest.dto.PeopleDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kasar on 12/21/2017.
 */
@Component
public class PeopleTransform {

    public PeopleDTO savePeople(People people){
        PeopleDTO peopleDTO = new PeopleDTO();
        peopleDTO.setFirstName(people.getFirstName());
        peopleDTO.setId(people.getId());
        peopleDTO.setLastName(people.getLastName());
        peopleDTO.setMailId(people.getMailId());
        peopleDTO.setNumber(people.getNumber());
        return peopleDTO;
    }

    public People savePeople(PeopleDTO peopleDTO){
        People people = new People();
        people.setFirstName(peopleDTO.getFirstName());
        people.setId(peopleDTO.getId());
        people.setLastName(peopleDTO.getLastName());
        people.setMailId(peopleDTO.getMailId());
        people.setNumber(peopleDTO.getNumber());
        return people;
    }

    public List<PeopleDTO> getAllPeople(Iterable<People> peoples){

        List<PeopleDTO> peopleDTOS = new ArrayList<>();
        for(People people: peoples){
            PeopleDTO ptd = savePeople(people);
            peopleDTOS.add(ptd);
        }
        return peopleDTOS;
    }
}
