package lk.ijse.springwebpos.service.serviceImpl;

import lk.ijse.springwebpos.dto.OrdersDTO;
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
        }else {
            throw new RuntimeException("Purchase Order Failed..!, Order ID " + ordersDTO.getOrderID() + " Already Exist.!");
        }

    }

    @Override
    public void deleteOrder(String oid) {

    }

    @Override
    public void updateOrder(OrdersDTO entity) {

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
