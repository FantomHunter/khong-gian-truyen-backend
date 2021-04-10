package com.codehunter.khonggiantruyen.peristence.entity;

import com.codehunter.khonggiantruyen.domain.EFormatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "resource_download")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDownloadDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    @Column(columnDefinition = "varchar(25) default 'PRC'")
    @Enumerated(EnumType.STRING)
    private EFormatType format = EFormatType.PRC;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductDao product;
    @OneToMany(mappedBy = "resourceDownload", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DownloadDao> downloadList = new ArrayList<>();
}
