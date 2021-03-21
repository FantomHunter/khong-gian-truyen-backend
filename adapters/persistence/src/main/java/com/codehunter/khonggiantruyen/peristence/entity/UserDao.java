package com.codehunter.khonggiantruyen.peristence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDao {
    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy = "user")
    private List<LikedDao> likedList = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<CommentDao> commentedList = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<DownloadDao> downloadList = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<RatingDao> ratingList = new ArrayList<>();
}
