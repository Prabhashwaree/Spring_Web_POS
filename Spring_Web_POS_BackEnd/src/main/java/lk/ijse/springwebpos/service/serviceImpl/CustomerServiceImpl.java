package lk.ijse.springwebpos.service.serviceImpl;

import lk.ijse.springwebpos.dto.CustomerDTO;
import lk.ijse.springwebpos.repo.CustomerRepo;
import lk.ijse.springwebpos.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;

    public void saveCustomer(CustomerDTO cusDTO) {
        (!customerRepo.){

        }

    }

    public List<CustomerDTO> getAllCustomer() {
        return null;
    }

    public void deleteCustomer(String id) {

    }

    public void updateCustomer(CustomerDTO entity) {

    }

    public CustomerDTO searchCustomer(String id) {
        return null;
    }
}
