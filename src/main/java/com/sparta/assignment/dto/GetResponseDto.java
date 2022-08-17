package com.sparta.assignment.dto;


import com.sparta.assignment.entity.Post;
import com.sparta.assignment.entity.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@RequiredArgsConstructor
@MappedSuperclass
@EntityListeners(AutoCloseable.class)
@Getter
public class GetResponseDto extends Timestamped {
    private final String title;
    private final String username;

    public GetResponseDto(Post post) {
        super.createdAt = post.getCreatedAt();
        super.modifiedAt = post.getModifiedAt();
        this.title = post.getTitle();
        this.username = post.getUsername();
    }

}
