package lk.ijse.springwebpos.controller;

import lk.ijse.springwebpos.dto.OrdersDTO;
import lk.ijse.springwebpos.service.PurchaseOrderService;
import lk.ijse.springwebpos.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("PurchaseOrder")
@CrossOrigin
public class PurchaseOrderController {
    @Autowired
    PurchaseOrderService purchaseOrderService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil getAllPurchaseOrder(){
        return new ResponceUtil(200,"getAllPurchase Order..",purchaseOrderService.getAllOrders());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil savePurchaseOrder(@RequestBody OrdersDTO ordersDTO){
        System.out.println(ordersDTO.toString());
        purchaseOrderService.purchaseOrder(ordersDTO);
        return new ResponceUtil(200,"savePurchase Order..",null);

    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil updateOrder(@RequestBody OrdersDTO ordersDTO) {
        purchaseOrderService.updateOrder(ordersDTO);
        return new ResponceUtil(200, "Updated Order..", null);
    }

    @DeleteMapping(params = {"oid"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponceUtil deleteOrder(@RequestParam String oid) {
        purchaseOrderService.deleteOrder(oid);
        return new ResponceUtil(200, "Deleted Order...", null);
    }


}
