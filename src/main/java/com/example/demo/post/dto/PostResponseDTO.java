package com.example.demo.post.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter

public class PostResponseDTO {
    @Schema(description = "작성된 게시글", example = "작성된 게시글 내용")
    String content;
}
