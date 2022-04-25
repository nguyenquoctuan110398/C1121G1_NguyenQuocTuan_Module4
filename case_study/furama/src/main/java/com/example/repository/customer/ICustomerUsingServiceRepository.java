package com.example.repository.customer;

import com.example.model.customer.CustomerUsingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerUsingServiceRepository extends JpaRepository<CustomerUsingService, Integer> {
//    @Query(value = "select concat(c.customerId, co.contractId, s.serviceId, " +
//            "nullif(ats.attachServiceId, 0)) as id, c.customerCode, c.customerName, " +
//            "co.contractId, s.serviceName, ats.attachServiceName, cd.quantity " +
//            "from Customer c " +
//            "join Contract co on c.customerId = co.customer.customerId " +
//            "join Services s on co.services.serviceId = s.serviceId " +
//            "left join ContractDetail cd on co.contractId = cd.contract.contractId " +
//            "left join AttachService ats on cd.attachService.attachServiceId = ats.attachServiceId")
    @Query(value = "select concat(customer.customer_id, contract.contract_id, services.service_id, ifnull(attach_service.attach_service_id,0)) as id, \n" +
            "\tcustomer.customer_code, customer.customer_name, contract.contract_id, services.service_name, \n" +
            "            attach_service.attach_service_name, contract_detail.quantity \n" +
            "            from customer \n" +
            "            join contract on customer.customer_id = contract.customer_id \n" +
            "            join services on contract.service_id = services.service_id \n" +
            "            left join contract_detail on contract.contract_id = contract_detail.contract_id \n" +
            "            left join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id", nativeQuery = true)
    List<CustomerUsingService> findAll();
//    Page<CustomerUsingService> findAll(Pageable pageable);
}

