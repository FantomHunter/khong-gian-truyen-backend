package com.codehunter.khonggiantruyen.peristence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "liked_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikedDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductDao product;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDao user;
    @Column(name = "like_at")
    private LocalDateTime likedAt;
}
