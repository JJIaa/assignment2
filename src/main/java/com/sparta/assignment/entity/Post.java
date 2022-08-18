package com.sparta.assignment.entity; 

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.assignment.dto.GetResponseDto;
import com.sparta.assignment.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Entity 부분
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

    //contents와 password에 jsonignore어노테이션 넣어봤었으나, 컬럼에서 아예 제외되어 삭제
    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String password;

    public Post(String title, String username, String contents, String password) {
        this.title = title;
        this.username = username;
        this.contents = contents;
        this.password = password;
    }

    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }

    public void update(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }
}
