package lk.ijse.springwebpos.service.serviceImpl;

import lk.ijse.springwebpos.dto.ItemDTO;
import lk.ijse.springwebpos.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    public void saveItem(ItemDTO entity) {

    }

    public List<ItemDTO> getAllItem() {
        return null;
    }

    public void deleteItem(String id) {

    }

    public void updateItem(ItemDTO entity) {

    }

    public ItemDTO searchItem(String id) {
        return null;
    }
}
