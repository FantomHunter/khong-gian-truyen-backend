package com.codehunter.khonggiantruyen.peristence.repository;

import com.codehunter.khonggiantruyen.peristence.entity.ProductDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDao, Long> {
    @Query(
            value = "SELECT p.*, count(1)  FROM PRODUCT p, comment c where p.id = c.product_id group by p.id order by count(1) desc",
            nativeQuery = true,
            countQuery = "select count(1)  FROM PRODUCT p, comment c where p.id = c.product_id group by p.id"
    )
    Page<ProductDao> findAllProductOrderByCommentCountDesc(Pageable pageable);
}
