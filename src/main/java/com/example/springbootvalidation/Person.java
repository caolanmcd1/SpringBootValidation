package com.example.springbootvalidation;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person
{
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Employee Id cannot be blank")
    //@Max(value = 10, message = "Employee Id cannot be bigger than 5 numbers long")
    private String employeeId;

    @NotBlank(message = "Age cannot be blank")
    @Min(value = 1, message = "Age cannot be less than 1")
    private String age;

    @NotBlank(message = "Position cannot be blank")
    private String position;

    @NotBlank(message = "Department cannot be blank")
    private String department;
}
