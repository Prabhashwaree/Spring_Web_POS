package lk.ijse.springwebpos.service;

import lk.ijse.springwebpos.dto.OrdersDTO;

import java.util.List;

public interface PurchaseOrderService {

    void purchaseOrder(OrdersDTO entity);
    void deleteOrder(String oid);
    void updateOrder(OrdersDTO entity);
    OrdersDTO searchOrder(String oid);
    List<OrdersDTO> getAllOrders();
}
