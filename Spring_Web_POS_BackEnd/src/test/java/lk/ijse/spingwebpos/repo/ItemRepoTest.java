package lk.ijse.spingwebpos.repo;

import lk.ijse.springwebpos.config.JPAConfig;
import lk.ijse.springwebpos.entity.Item;
import lk.ijse.springwebpos.repo.ItemRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)

public class ItemRepoTest {

    @Autowired
    ItemRepo itemRepo;

    @Test
    public void getAllItem(){}

    @Test
    public void saveItem(){
        Item item1 = new Item("I001", "blouse", 5000, 2);
        Item item2 = new Item("I002", "Tshirt", 850, 5);
        itemRepo.save(item1);
        itemRepo.save(item2);
    }

    @Test
    public void deleteItem(){
        itemRepo.deleteById("I001");
    }

    @Test
    public void updateItem(){
        if (itemRepo.existsById("I002")) {
            Item item2 = new Item("I002", "saree", 1500, 5);
            itemRepo.save(item2);
        }else{
            throw new RuntimeException("No Such Item To Update");
        }
    }

    @Test
    public void searchItem(){}
}
