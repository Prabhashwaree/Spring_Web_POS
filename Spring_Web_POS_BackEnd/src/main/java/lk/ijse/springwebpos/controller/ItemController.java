package lk.ijse.springwebpos.controller;


import lk.ijse.springwebpos.dto.ItemDTO;
import lk.ijse.springwebpos.service.ItemService;
import lk.ijse.springwebpos.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Item")
@CrossOrigin

public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil saveItem(@ModelAttribute ItemDTO itemDTO){
        itemService.saveItem(itemDTO);
        return new ResponceUtil(200,"saved",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil getAllItem(){
        return new ResponceUtil(200,"getAll",itemService.getAllItem());

    }

    @DeleteMapping(params = {"code"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil deleteItem(@RequestParam String code){
        itemService.deleteItem(code);
        return new ResponceUtil(200,"delete",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil updateItem(@RequestBody ItemDTO itemDTO){
        itemService.updateItem(itemDTO);
        return new ResponceUtil(200,"updated",null);
    }

    @GetMapping(path = "/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil searchItem(@PathVariable String code){
        return  new ResponceUtil(200,"search",itemService.searchItem(code));
    }
}
