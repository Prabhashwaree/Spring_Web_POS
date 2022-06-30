package lk.ijse.springwebpos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@IdClass(OrderItem_PK.class)
public class OrderDetails {
    @Id
    private String orderID;
    @Id
    private String itemCode;
    private int orderQty;
    private double discount;
    private int balance;

    @ManyToOne
    @JoinColumn(name = "orderID",referencedColumnName = "orderID",insertable = false,updatable = false)
    private Orders orders;
    //Out-verse
    @ManyToOne
    @JoinColumn(name = "itemCode",referencedColumnName = "itemCode",insertable = false,updatable = false)
    private Item items;


}