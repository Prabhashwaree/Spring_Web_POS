package lk.ijse.springwebpos.dto;

import lk.ijse.springwebpos.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrdersDTO {
    private String orderID;
    private String  orderDate ;
    private String  orderTime ;
    private Customer customer;

    private List<OrderDetailsDTO> orderDetailsDTO;
}
