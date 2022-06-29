package lk.ijse.springwebpos.service.serviceImpl;

import lk.ijse.springwebpos.dto.CustomerDTO;
import lk.ijse.springwebpos.dto.ItemDTO;
import lk.ijse.springwebpos.entity.Item;
import lk.ijse.springwebpos.repo.ItemRepo;
import lk.ijse.springwebpos.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ModelMapper modelMapper;

    public void saveItem(ItemDTO item) {
        if(!itemRepo.existsById(item.getItemCode())){
            itemRepo.save(modelMapper.map(item, Item.class));
        }else {
            throw new RuntimeException("Item Already Exist..!");
        }

    }

    public List<ItemDTO> getAllItem() {
        return modelMapper.map(itemRepo.findAll(),new TypeToken<List<ItemDTO>>(){}.getType());
    }

    public void deleteItem(String code) {
        if(itemRepo.existsById(code)){
            itemRepo.deleteById(code);
        }else {
            throw new RuntimeException("Please check the Item Code.. No Such Item..!");
        }
    }


    public void updateItem(ItemDTO itemDTO) {
        if(itemRepo.existsById(itemDTO.getItemCode())){
            itemRepo.save(modelMapper.map(itemDTO,Item.class));
        }else {
            throw new RuntimeException("No Such Item To Update..! Please Check the Item Code..!");
        }
    }

    public ItemDTO searchItem(String code) {
        if(itemRepo.existsById(code)){
            return modelMapper.map(itemRepo.findById(code).get(),ItemDTO.class);
        }else {
            throw new RuntimeException("No Item For "+code+" ..!");
        }
    }
}
