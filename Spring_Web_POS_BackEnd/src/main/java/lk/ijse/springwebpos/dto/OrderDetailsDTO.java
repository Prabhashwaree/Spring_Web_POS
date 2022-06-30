package lk.ijse.springwebpos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderDetailsDTO {
    private String orderID;
    private String itemCode;
    private int orderQty;
    private double discount;
    private int balance;
}
