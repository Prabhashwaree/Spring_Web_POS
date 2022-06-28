package lk.ijse.spingwebpos.repo;

import lk.ijse.springwebpos.config.JPAConfig;
import lk.ijse.springwebpos.entity.Customer;
import lk.ijse.springwebpos.repo.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)

public class CustomerRepoTest {
    @Autowired
    CustomerRepo customerRepo;

    @Test
    public void getAllCustomer(){
    }

    @Test
    public void saveCustomer(){
        Customer customer1 = new Customer("C001", "Neth", "Galle", 1000);
        Customer customer2 = new Customer("C002", "Gaya", "Kaluthara", 2000.00);
        customerRepo.save(customer1);
        customerRepo.save(customer2);
    }

    @Test
    public void deleteCustomer(){
        customerRepo.deleteById("C001");
    }

    @Test
    public void updateCustomer(){
        if (customerRepo.existsById("C002")) {
            Customer customer1 = new Customer("C002", "Silva", "Panadura", 1000.00);
            customerRepo.save(customer1);
        }else{
            throw new RuntimeException("No Such Customer To Update");
        }
    }

    @Test
    public void searchCustomer(){}


}
