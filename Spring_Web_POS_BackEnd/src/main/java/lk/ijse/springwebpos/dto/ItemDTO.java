package lk.ijse.springwebpos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ItemDTO {
    private String itemCode;
    private String ItemName;
    private double Price;
    private int  Qty;
}
