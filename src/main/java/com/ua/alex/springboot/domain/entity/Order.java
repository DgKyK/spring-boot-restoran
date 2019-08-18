package com.ua.alex.springboot.domain.entity;

import com.ua.alex.springboot.domain.entity.enums.Status;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    private long user_id;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    private int sumOfOrder;
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "Order_Dish",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "dish_id")}
    )
    private List<Dish> dishes;

}
