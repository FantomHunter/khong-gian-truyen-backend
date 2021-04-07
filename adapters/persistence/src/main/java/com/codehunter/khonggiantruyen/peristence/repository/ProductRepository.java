package com.codehunter.khonggiantruyen.peristence.repository;

import com.codehunter.khonggiantruyen.peristence.entity.ProductDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDao, Long> {
}
