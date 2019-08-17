package com.ua.alex.springboot.domain.entity;

import com.ua.alex.springboot.domain.entity.enums.Category;
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
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToMany(mappedBy = "dishes")
    private List<Order> orders;
}
