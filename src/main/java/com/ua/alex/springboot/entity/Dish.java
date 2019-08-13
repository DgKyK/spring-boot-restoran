package com.ua.alex.springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Dish {

    @Id
    private long Id;
    private String name;
    private int cost;
    @ManyToMany(mappedBy = "dishes")
    private List<Order> orders;
}
