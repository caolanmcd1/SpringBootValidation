package com.example.springbootvalidation;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/person")
@RestController
public class PersonController
{
    private final PersonService personService;

    public PersonController(PersonService personService)
    {
        this.personService = personService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getPerson(@PathVariable String employeeId)
    {
        if(employeeId.length() > 5 || employeeId.isBlank())
        {
            return ResponseEntity.badRequest().body("Employee Id is invalid");
        }

        Person person = personService.getPersonByEmployeeId(employeeId);

        if(person==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }

    @PostMapping("/createPerson")
    public ResponseEntity<String>create(@Valid @RequestBody Person person)
    {
        personService.savePerson(person);
        return new ResponseEntity<>("com.example.springbootvalidation.Person Created Successfully", HttpStatus.OK);
    }
}
