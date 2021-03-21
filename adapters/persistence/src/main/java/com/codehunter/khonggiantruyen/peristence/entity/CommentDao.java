package com.codehunter.khonggiantruyen.peristence.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductDao product;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDao user;
    private String content;
    @Column(name = "commented_at")
    private LocalDateTime commentedAt;
}
