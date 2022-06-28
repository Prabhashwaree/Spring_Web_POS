package lk.ijse.springwebpos.service;

import lk.ijse.springwebpos.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO entity);

    List<CustomerDTO> getAllCustomer();

    void deleteCustomer(String id);

    void updateCustomer(CustomerDTO entity);

    CustomerDTO searchCustomer(String id);
}
