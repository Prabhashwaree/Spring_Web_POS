package lk.ijse.springwebpos.service.serviceImpl;

import lk.ijse.springwebpos.dto.CustomerDTO;
import lk.ijse.springwebpos.entity.Customer;
import lk.ijse.springwebpos.repo.CustomerRepo;
import lk.ijse.springwebpos.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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

    @Override
    public void saveCustomer(CustomerDTO cusDTO) {
        if(!customerRepo.existsById(cusDTO.getCustID())){
            customerRepo.save(modelMapper.map(cusDTO,Customer.class));
        }else {
            throw new RuntimeException("Customer Already Exist..!");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return modelMapper.map(customerRepo.findAll(),new TypeToken<List<CustomerDTO>>(){}.getType());
    }


    @Override
    public void deleteCustomer(String id) {
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }else {
            throw new RuntimeException("Please check the Customer ID.. No Such Customer..!");
        }
    }


    @Override
    public void updateCustomer(CustomerDTO cusDTO) {
        if(customerRepo.existsById(cusDTO.getCustID())){
            customerRepo.save(modelMapper.map(cusDTO,Customer.class));
        }else {
            throw new RuntimeException("No Such Customer To Update..! Please Check the ID..!");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if(customerRepo.existsById(id)){
            return modelMapper.map(customerRepo.findById(id).get(),CustomerDTO.class);
        }else {
            throw new RuntimeException("No Customer For "+id+" ..!");
        }
    }
}
