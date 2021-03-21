package com.codehunter.khonggiantruyen.peristence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "rating")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductDao product;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDao user;
    @Max(5)
    @NotNull
    private Integer value;
    @Column(name = "rating_at")
    private LocalDateTime ratingAt;
}
