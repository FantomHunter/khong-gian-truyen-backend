package com.codehunter.khonggiantruyen.peristence.repository;

import com.codehunter.khonggiantruyen.peristence.entity.AuthorDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorDao, Long> {
}
