package com.sparta.assignment.controller; 


import com.sparta.assignment.dto.GetResponseDto;
import com.sparta.assignment.dto.PostRequestDto;
import com.sparta.assignment.entity.Post;
//import com.sparta.assignment.repository.PostRepository;
import com.sparta.assignment.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    //게시글 생성
    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        return postService.create(requestDto);
    }

    //전체 게시글 조회 (contents와 password 제외한 entity값 불러오기)
    @GetMapping("/api/posts")
    public List<GetResponseDto> readPosts() {
        return postService.getResponseDtoList();
    }

    //상세 조회 (입력된 id값과 일치하는 것만 조회)
    @GetMapping("/api/posts/{id}")
    public Optional<Post> readOnePosts(@PathVariable Long id) {
        return postService.readOne(id);
    }

    //게시글 수정 (게시글 생성시 입력했던 비밀번호와 일치해야만 수정 가능)
    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        postService.update(id, requestDto);
        return id;
    }

    //게시글 삭제 (게시글 생성시 입력했던 비밀번호와 일치해야만 삭제 가능)
    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        postService.delete(id, requestDto);
        return id;
    }

}
