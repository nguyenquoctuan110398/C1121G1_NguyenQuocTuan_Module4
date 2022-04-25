package com.example.dto.contract;

import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.service.Services;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContractDto implements Validator {
    private Integer contractId;
    private String contractStartDate;
    private String contractEndDate;
    @Pattern(regexp = "^[1-9]\\d*$")
    private String contractDeposit;
    private Employee employee;
    private Customer customer;
    private Services services;

    public ContractDto() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(String contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        final String REGEX_DATE = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";
        ContractDto contractDTO = (ContractDto) target;
        if (!contractDTO.getContractEndDate().matches(REGEX_DATE)) {
            errors.rejectValue("endDate", "err.start.day", "invalid date");
        } else {
            if (contractDTO.getContractStartDate().matches(REGEX_DATE)) {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dayStart = LocalDate.parse(contractDTO.getContractStartDate(), dateTimeFormatter);
                LocalDate dayEnd = LocalDate.parse(contractDTO.getContractEndDate(), dateTimeFormatter);
                if (dayEnd.isBefore(dayStart)) {
                    errors.rejectValue("endDate", "err.day.before", "End date must be after Start date");
                }
            }
        }
    }
}
