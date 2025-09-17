package com.example.demo.post.dto;
//데이터 포장함 class와 record중 이용 가능
//class는 getter 와 builder필요
    /*public static class createPost{
        String Content;
    }*/

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class PostRequestDTO {

    //record 불변성이 있어서 변경이 절대 불가능 (데이터의 정확성을 위한 dto는 레코드가 적합함
    public record createPost(
            @Schema(description = "게시글 내용", example = "입력한 게시글 내용")
            String content){}

}

