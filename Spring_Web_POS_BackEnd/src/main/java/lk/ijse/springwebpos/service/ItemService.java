package lk.ijse.springwebpos.service;

import lk.ijse.springwebpos.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO entity);

    List<ItemDTO> getAllItem();

    void deleteItem(String code);

    void updateItem(ItemDTO entity);

    ItemDTO searchItem(String code);
}
