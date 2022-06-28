package lk.ijse.springwebpos.controller;


import lk.ijse.springwebpos.service.CustomerService;
import lk.ijse.springwebpos.service.ItemService;
import lk.ijse.springwebpos.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Item")
@CrossOrigin

public class ItemController {

    @Autowired
    ItemService itemService;

    @
    public ResponceUtil saveItem(){

    }
}
