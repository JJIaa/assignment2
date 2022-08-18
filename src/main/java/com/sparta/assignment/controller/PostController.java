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

//    private final PostRepository postRepository;
    private final PostService postService;

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        return postService.create(requestDto);
    }

//    @GetMapping("/api/posts")
//    public List<Post> readPosts() {
//        return postService.readAll();
//    }

    @GetMapping("/api/posts")
    public List<GetResponseDto> readPosts() {
        return postService.getResponseDtoList();
    }

    @GetMapping("/api/posts/{id}")
    public Optional<Post> readOnePosts(@PathVariable Long id) {
        return postService.readOne(id);
    }

    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        postService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        postService.delete(id, requestDto);
        return id;
    }

}
