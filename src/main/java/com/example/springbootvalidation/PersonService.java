package com.example.springbootvalidation;

import com.example.springbootvalidation.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService
{
    public void savePerson(Person person)
    {
        System.out.println("com.example.springbootvalidation.Person saved: " + person);
    }

    public Person getPersonByEmployeeId(String employeeId)
    {
        return new Person();
    }
}
