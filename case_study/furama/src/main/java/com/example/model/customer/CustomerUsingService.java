package com.example.model.customer;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "customer_using_service")
public class CustomerUsingService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "customer_code")
    private String customerCode;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "contract_id")
    private Integer contractId;
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "attach_service_name")
    private String attachServiceName;
    @Column(name = "quantity")
    private Integer quantity;

    public CustomerUsingService() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
