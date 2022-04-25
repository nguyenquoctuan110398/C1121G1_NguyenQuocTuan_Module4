package com.example.dto.employee;

import com.example.model.employee.Division;
import com.example.model.employee.EducationDegree;
import com.example.model.employee.Position;

import javax.validation.constraints.Pattern;

public class EmployeeDto {
    private Integer employeeId;
    @Pattern(regexp = "^[\\p{Lu}\\p{Ll}]+( [\\p{Lu}\\p{Ll}]+)*$")
    private String employeeName;
    private String employeeBirthday;
    @Pattern(regexp = "^\\d{9}|\\d{12}", message = "Wrong format! Format should be XXXXXXXXX(123123123)")
    private String employeeIdCard;
    @Pattern(regexp = "^[1-9]\\d*(.?\\d+)?$", message = "Must be number and greater than 0")
    private String employeeSalary;
    @Pattern(regexp = "^((090)|(091)|(\\((84)\\)\\+((90)|(91))))\\d{7}$",
            message = "Wrong format! Format should be 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx")
    private String employeePhone;
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,}){1,}$")
    private String employeeEmail;
    private String employeeAddress;
    private Boolean deleteFlag;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;

    public EmployeeDto() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
