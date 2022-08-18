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

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    //게시글 생성
    @Transactional
    public Post create(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return post;
    }

    //게시글 전체 조회. stream().map() 사용하려다 실패하고 해당 방식 사용.
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

    //게시글 상세 조회. 입력받은 Id값과 일치하는 것만 조회
    @Transactional
    public Optional<Post> readOne(@PathVariable Long id) {
        return postRepository.findById(id);
    }

    //게시글 수정. 생성시 입력했던 비밀번호와 일치해야만 수정 가능
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

    //게시글 삭제. 생성시 입력했던 비밀번호와 일치해야만 삭제 가능
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
