package lk.ijse.springwebpos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@IdClass(OrderItem_PK.class)
public class OrderDetails {
    @Id
    private String orderID;
    @Id
    private String ItemCode;
    private String orderqty;
    private double discount;
    private double balance;


    @ManyToOne
    @JoinColumn(name = "orderID",referencedColumnName = "orderID",insertable = false,updatable = false)
    private Order order;


    @ManyToOne
    @JoinColumn(name = "ItemCode",referencedColumnName = "ItemCode",insertable = false,updatable = false)
    private Item Item;
}
