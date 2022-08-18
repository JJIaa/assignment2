package com.sparta.assignment.dto; 

import lombok.Getter;

//게시글 상세 조회를 제외한 다른 기능때 사용되는 DTO
@Getter
public class PostRequestDto {
    private String title;
    private String username;
    private String contents;
    private String password;

}
