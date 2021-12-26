package com.example.swagger.model;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(description = "Employee Model")
public class Employee {
    @Id
    @ApiModelProperty(notes = "ID of the Employee", name = "id", required = true, value = "14524")
    private Long id;

    @ApiModelProperty(notes = "Name of the Employee", name = "name", required = true, value = "Luc")
    @NotNull
    private String name;

    @ApiModelProperty(notes = "Department of the Employee", name = "department", required = true, value = "Direction")
    @NotEmpty(message = "Department cannot be empty")
    private String department;

    @ApiModelProperty(notes = "Phone Number of the Employee", name = "phoneNumber", required = true, value = "12345678")
    @Min(value = 18, message = "should not be less than 10")
    @Max(value = 150, message = " should not be greater than 15")
    @Positive
    private long phoneNumber;

    @ApiModelProperty(notes = "Email of the Employee", name = "email", required = true, value = "email@person.com")
    @Email(regexp=".*@.*\\..*", message = "Email should be valid")
    private String email;

}
