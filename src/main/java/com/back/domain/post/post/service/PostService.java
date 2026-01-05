package com.back.domain.post.post.service;

import com.back.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // 어노테이션으로 서비스 컴포넌트 지정
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public long count(){
        return postRepository.count();
    }

}
