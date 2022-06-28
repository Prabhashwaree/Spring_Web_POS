package lk.ijse.spingwebpos.repo;

import lk.ijse.springwebpos.config.JPAConfig;
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
    public void saveCustomer(){}

    @Test
    public void deleteCustomer(){}

    @Test
    public void updateCustomer(){}

    @Test
    public void searchCustomer(){}


}
