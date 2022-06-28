package lk.ijse.springwebpos.repo;

import lk.ijse.springwebpos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {
}
