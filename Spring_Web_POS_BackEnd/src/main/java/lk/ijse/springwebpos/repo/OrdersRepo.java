package lk.ijse.springwebpos.repo;

import lk.ijse.springwebpos.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders,String> {

}
