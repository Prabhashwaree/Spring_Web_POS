package lk.ijse.spingwebpos.repo;

import lk.ijse.springwebpos.config.JPAConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)

public class ItemRepoTest {

    @Test
    public void getAllItem(){}

    @Test
    public void saveItem(){}

    @Test
    public void deleteItem(){}

    @Test
    public void updateItem(){}

    @Test
    public void searchItem(){}
}
