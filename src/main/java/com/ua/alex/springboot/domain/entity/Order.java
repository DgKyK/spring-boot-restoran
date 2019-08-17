package com.ua.alex.springboot.domain.entity;

import com.ua.alex.springboot.domain.entity.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    private long id;
    private long user_id;
    private Status status;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Order_Dish",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "dish_id")}
    )
    private List<Dish> dishes;
}
