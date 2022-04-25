package com.example.dto.service;

import com.example.model.service.RentType;
import com.example.model.service.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;

public class ServiceDto implements Validator {
    private Integer serviceId;
    @Pattern(regexp = "^(DV)-\\d{4}$", message = "Wrong format! Format should be DV-XXXX")
    private String serviceCode;
    private String serviceName;
    @Pattern(regexp = "^[1-9]\\d*$", message = "Must be number and greater than 0")
    private String serviceArea;
    @Pattern(regexp = "^[1-9]\\d*(.?\\d+)?$", message = "Must be number and greater than 0")
    private String serviceCost;
    @Pattern(regexp = "^[1-9]\\d*$", message = "Must be number and greater than 0")
    private String serviceMaxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private String poolArea;
    private String numberOfFloors;
    private ServiceType serviceType;
    private RentType rentType;

    public ServiceDto() {
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        final String regexDoubleNumber = "^[1-9]\\d*.\\d*$";
        final String regexIntNumber = "^[1-9]$";

        ServiceDto serviceDto = (ServiceDto) target;

        if ((serviceDto.getServiceType().getServiceTypeId() == 1)) {
            if (!serviceDto.poolArea.matches(regexDoubleNumber)) {
                errors.rejectValue("poolArea", "", "Must be number and greater than 0");
            }
            if (!serviceDto.numberOfFloors.matches(regexIntNumber)) {
                errors.rejectValue("numberOfFloors", "", "Must be number and greater than 0");
            }
        }

        if (serviceDto.getServiceType().getServiceTypeId() == 2){
            if (!serviceDto.numberOfFloors.matches(regexIntNumber)) {
                errors.rejectValue("numberOfFloors", "", "Must be number and greater than 0");
            }
        }
    }
}
