package com.example.demo.post.controller;

import com.example.demo.post.dto.PostRequestDTO;
import com.example.demo.post.dto.PostResponseDTO;
import com.example.demo.post.entity.Post;
import com.example.demo.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@RestController//Rest가 붙기에 자동으로 @Responsebody 어노테이션 적용됨
@RequiredArgsConstructor

public class PostController {


    private final PostService postService;

    @GetMapping("/time")
    public String time(){
        return "현재 시각은 "+ZonedDateTime.now().toString();}

    @Tag(name = "테스트", description = "테스트용 API")
    @Operation(summary = "테스트용입니다.", description = "기능 미구현")
    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @Tag(name = "게시판", description = "게시판 관련 API")
    @Operation(summary = "업로드", description = "게시글 업로드")
    @ApiResponse(responseCode = "200", description = "Successful Access",
    content = @Content (
            mediaType = "application/json",
           schema = @Schema(implementation = PostResponseDTO.class)
    )
    )
    @ApiResponse(responseCode = "400", description = "Bad Request",
    content = @Content (
            mediaType = "application/json",
            examples =
                    @ExampleObject(


            value = "잘못된 요청입니다."
    )
    )
    )
    @PostMapping("/posts")
    public ResponseEntity<String> posts(
            @RequestBody(description = "게시글 업로드 내용", required = true)
            PostRequestDTO.createPost dto
    ){
        Post result = postService.createPost(dto);
        return ResponseEntity.ok().body(result.getContent());
    }

}
