package com.sparta.assignment.service;

import com.sparta.assignment.dto.GetResponseDto;
import com.sparta.assignment.dto.PostRequestDto;
import com.sparta.assignment.entity.Post;
import com.sparta.assignment.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post create(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return post;
    }

//    @Transactional
//    public List<Post> readAll() {
//        return postRepository.findAllByOrderByModifiedAtDesc();
////        return postList.stream()
////                .map(p -> new GetReponseDto(
////                        p.getTitle(),
////                        p.getUsername()))
////                .collect(Collectors.toList());
//    }

    @Transactional
    public List<GetResponseDto> getResponseDtoList() {
        List<Post> postList = postRepository.findAllByOrderByModifiedAtDesc();
        List<GetResponseDto> getResponseDtoList = new ArrayList<>();
        for (int i = 0; i < postList.size(); i++) {
            Post post = postList.get(i);
            GetResponseDto getResponseDto = new GetResponseDto(post);
            getResponseDtoList.add(getResponseDto);
        }
        return getResponseDtoList;
    }

    @Transactional
    public Optional<Post> readOne(@PathVariable Long id) {
        return postRepository.findById(id);
    }

    @Transactional
    public Boolean update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (post.getPassword().equals(requestDto.getPassword())){
            System.out.println("수정이 완료되었습니다.");
            post.update(requestDto);
            return true;
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return false;
        }
    }

    @Transactional
    public Boolean delete(@PathVariable Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (post.getPassword().equals(requestDto.getPassword())){
            System.out.println("삭제가 완료되었습니다.");
            postRepository.deleteById(id);
            return true;
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return false;
        }
    }


}
