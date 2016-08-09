package com.service;

import com.model.Person;
import com.model.Role;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Alexandr on 29.07.2016.
 */
public class PersonAuthenticationService {
    private Person[] personBD = new Person[0];

    public PersonAuthenticationService() throws IOException {
    }

    public Person[] getPersonBD() {
        return personBD;
    }

    public void setPersonBD(Person[] personBD) {
        this.personBD = personBD;
    }

    PropertyService propertyService = new PropertyService();

    public Role getUserRoleVyUserNameAndPassword(String name, String password) {
        if (propertyService.personsWithExistingRolesDB[0].getPersonName().equals(name) & propertyService.personsWithExistingRolesDB[0].
                getPersonPassword().equals(password)) return Role.ADMIN;
        else if (propertyService.personsWithExistingRolesDB[1].getPersonName().equals(name) & propertyService.personsWithExistingRolesDB[1].
                getPersonPassword().equals(password)) return Role.USER;
        else throw new RuntimeException("Wrong name and password");
    }

    public void addNewPerson(Person newPerson) {
        personBD = Arrays.copyOf(personBD, personBD.length + 1);
        personBD[personBD.length - 1] = newPerson;
    }


}
