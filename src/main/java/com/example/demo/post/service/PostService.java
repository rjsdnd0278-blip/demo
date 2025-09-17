package com.example.demo.post.service;

import com.example.demo.post.dto.PostRequestDTO;
import com.example.demo.post.entity.Post;
import com.example.demo.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post createPost(PostRequestDTO.createPost dto) {
        //요청받은 데이터 추출
        String content = dto.content(); // content 뽑아옴
        // 데이터 -> 엔티티
        Post post = Post.builder()
                .content(content)
                .build();
        //저장
        postRepository.save(post);
        //성공적으로 저장했다는 신호 보내기
        return post;
    }
}
