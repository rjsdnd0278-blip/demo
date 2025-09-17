package com.example.demo.post.controller;

import com.example.demo.post.dto.PostRequestDTO;
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

    @GetMapping("/test")
    public String test(){
        return "test";
    }


    @PostMapping("/posts")
    public ResponseEntity<String> posts(
            PostRequestDTO.createPost dto
    ){
        Post result = postService.createPost(dto);
        return ResponseEntity.ok().body(result.getContent());
    }

}
