package com.codehunter.khonggiantruyen.peristence.repository;

import com.codehunter.khonggiantruyen.peristence.entity.CommentDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentDao, Long> {
}
