package com.sparta.assignment.repository;

import com.sparta.assignment.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//repository 내장 함수 사용 위해 생성.
public interface PostRepository extends JpaRepository<Post, Long> {

    //게시글 전체 조회때 사용할 마지막 수정 시간 기준 전체 내림차순 정렬 함수
    List<Post> findAllByOrderByModifiedAtDesc();
}



