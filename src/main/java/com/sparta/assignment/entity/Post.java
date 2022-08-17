package com.sparta.assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.assignment.dto.GetResponseDto;
import com.sparta.assignment.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Post extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
//    @JsonIgnore 컬럼에서 사라지기는 하는데 상세조회 때도 사라짐..
    private String contents;

    @Column(nullable = false)
//    @JsonIgnore 컬럼에서 사라지기는 하는데 상세조회 때도 사라짐..
    private String password;

    public Post(String title, String username, String contents, String password) {
        this.title = title;
        this.username = username;
        this.contents = contents;
        this.password = password;
    }

    //전체 싹 다 조회
    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }

//    public Post(GetResponseDto responseDto) {
//        this.title = responseDto.
//    }


    public void update(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }
}
