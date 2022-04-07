package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class UserDto implements Validator {

    @NotBlank(message = "Please input firstname")
    @Pattern(regexp = "^([A-Z])[A-Za-z ]+$", message = "Wrong format firstname!")
    private String firstname;

    @NotBlank(message = "Please input lastname")
    @Pattern(regexp = "[A-Za-z ]+", message = "Wrong format name!")
    private String lastname;

    @NotBlank(message = "Please input phone number")
    @Pattern(regexp = "^(0)[0-9]{9}$", message = "Length form 10 and start number 0!")
    private String phoneNumber;

    private String dateOfBirth;

    @NotBlank(message = "Please input email")
    @Email(message = "Wrong format!")
    private String email;

    public UserDto() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        Integer yearUser = Integer.parseInt(userDto.getDateOfBirth().substring(0, 4));

        // Get current year
        Integer yearCur = LocalDate.now().getYear();

        if (yearCur - yearUser <18){
            errors.rejectValue("dateOfBirth", "user.not18", "Not age 18!");
        }
    }

}
