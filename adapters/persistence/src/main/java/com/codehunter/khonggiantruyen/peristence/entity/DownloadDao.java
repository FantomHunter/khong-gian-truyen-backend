package com.codehunter.khonggiantruyen.peristence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "download")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownloadDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private ResourceDownloadDao resourceDownload;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDao user;
    @Column(name = "download_at")
    private LocalDateTime downloadAt;
}
