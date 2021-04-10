package com.codehunter.khonggiantruyen.peristence.entity;

import com.codehunter.khonggiantruyen.domain.EProductStatus;
import com.codehunter.khonggiantruyen.domain.EProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "publish_date")
    private LocalDateTime publishDate;
    @Column(name = "total_chapter")
    private Integer totalChapter;
    @Column(columnDefinition = "varchar(25) default 'PUBLISHING'")
    @Enumerated(EnumType.STRING)
    private EProductStatus status = EProductStatus.PUBLISHING;
    @Column(columnDefinition = "varchar(25) default 'TRANSLATED'")
    @Enumerated(EnumType.STRING)
    private EProductType type = EProductType.TRANSLATED;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorDao author;
    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryDao> categoryList = new ArrayList<>();
    @OneToMany(mappedBy = "product")
    private List<ResourceDownloadDao> resourceDownloadList = new ArrayList<>();
    @OneToMany(mappedBy = "product")
    private List<LikedDao> likedList = new ArrayList<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentDao> commentedList = new ArrayList<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RatingDao> ratingList = new ArrayList<>();
}
