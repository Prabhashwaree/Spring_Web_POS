package lk.ijse.springwebpos.service.serviceImpl;

import lk.ijse.springwebpos.dto.OrdersDTO;
import lk.ijse.springwebpos.entity.Item;
import lk.ijse.springwebpos.entity.OrderDetails;
import lk.ijse.springwebpos.entity.OrderItem_PK;
import lk.ijse.springwebpos.entity.Orders;
import lk.ijse.springwebpos.repo.ItemRepo;
import lk.ijse.springwebpos.repo.OrderDetailsRepo;
import lk.ijse.springwebpos.repo.OrdersRepo;
import lk.ijse.springwebpos.service.PurchaseOrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    OrdersRepo ordersRepo;
    @Autowired
    OrderDetailsRepo orderDetailsRepo;
    @Autowired
    ModelMapper  modelMapper;

    @Override
    public void purchaseOrder(OrdersDTO ordersDTO) {
        Orders orders = modelMapper.map(ordersDTO, Orders.class);
        if (!ordersRepo.existsById(ordersDTO.getOrderID())) {
            ordersRepo.save(orders);
            if(ordersDTO.getOrderDetailsDTO().size()<1)throw new RuntimeException("No items added for the order..!");


            //Update the Item-----
            for(OrderDetails orderDetails:orders.getOrderDetails()){
                Item item = itemRepo.findById(orderDetails.getItemCode()).get();
                item.setQty(item.getQty()-orderDetails.getOrderQty());
                itemRepo.save(item);
            }

        }else {
            throw new RuntimeException("Purchase Order Failed..!, Order ID " + ordersDTO.getOrderID() + " Already Exist.!");
        }

    }

    @Override
    public void deleteOrder(String oid) {
        if(ordersRepo.existsById(oid)) {
            ordersRepo.deleteById(oid);
        }else {
            throw new RuntimeException("Delete Order Failed..!, Order ID " + oid + " Not Exist..!");
        }
    }

    @Override
    public void updateOrder(OrdersDTO ordersDTO) {
        if(ordersRepo.existsById(ordersDTO.getOrderID())){
            Orders orders = modelMapper.map(ordersDTO, Orders.class);

            if(ordersDTO.getOrderDetailsDTO().size()<1)throw new RuntimeException("No items added for the order..!");{
                for(OrderDetails orderDetails:orders.getOrderDetails()){
                    Item item = itemRepo.findById(orderDetails.getItemCode()).get();
                    OrderDetails orderDetails1 = orderDetailsRepo.findById(String.valueOf(new OrderItem_PK(orderDetails.getOrderID(), orderDetails.getItemCode()))).get();


                    //Update the Item Qty-------
                    int newqty=orderDetails.getOrderQty();
                    int  prevQty = orderDetails1.getOrderQty();

                    if(newqty>prevQty){
                        int dif = newqty - prevQty;
                        item.setQty(item.getQty() - dif);

                    } else if (newqty < prevQty) {
                        int dif = prevQty - newqty;
                        item.setQty(item.getQty() + dif);

                    }
                    itemRepo.save(item);

                }
                //then delete the old order
                ordersRepo.deleteById(ordersDTO.getOrderID());
                //finally update the new order
                ordersRepo.save(orders);
            }

        }else{
            throw new RuntimeException("Update Order Failed..!, Order ID " + ordersDTO.getOrderID() + " Not Exist.!");


        }

    }

    @Override
    public OrdersDTO searchOrder(String oid) {
        return null;
    }

    @Override
    public List<OrdersDTO> getAllOrders() {
        return modelMapper.map(ordersRepo.findAll(),new TypeToken<List<OrdersDTO>>(){}.getType());
    }
}
