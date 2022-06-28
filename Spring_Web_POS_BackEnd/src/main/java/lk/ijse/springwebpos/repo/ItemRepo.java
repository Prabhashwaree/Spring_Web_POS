package lk.ijse.springwebpos.repo;

import lk.ijse.springwebpos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, String> {

}
