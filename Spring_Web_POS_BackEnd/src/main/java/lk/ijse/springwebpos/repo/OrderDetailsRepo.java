package lk.ijse.springwebpos.repo;

import lk.ijse.springwebpos.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails,String> {
}
