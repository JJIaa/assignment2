package com.sparta.assignment.repository;

import com.sparta.assignment.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByModifiedAtDesc();
//  List<Post> findAllByOrderByModifiedAtDesc();
}



