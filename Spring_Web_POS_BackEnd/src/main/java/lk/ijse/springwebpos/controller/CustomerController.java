package lk.ijse.springwebpos.controller;

import lk.ijse.springwebpos.dto.CustomerDTO;
import lk.ijse.springwebpos.service.CustomerService;
import lk.ijse.springwebpos.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil saveCustomer(@ModelAttribute CustomerDTO cusDTO){
        customerService.saveCustomer(cusDTO);
        return new ResponceUtil(200,"save",null);
    }

    @GetMapping
    public ResponceUtil getAllCustomer(){
        return  new ResponceUtil(200,"getAll",customerService.getAllCustomer());
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil deleteCustomer(@RequestParam String id){
        customerService.deleteCustomer(id);
        return new ResponceUtil(200,"deleted",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil updateCustomer(@RequestBody CustomerDTO cusDTO){
        customerService.updateCustomer(cusDTO);
        return new ResponceUtil(200,"updated",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil searchCustomer(@PathVariable String id){
        return new ResponceUtil(200,"search",customerService.searchCustomer(id));
    }

}
