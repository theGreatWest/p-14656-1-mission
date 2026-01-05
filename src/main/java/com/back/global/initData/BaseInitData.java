package com.back.global.initData;

import com.back.domain.post.post.document.Post;
import com.back.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 클래스 지정
@Slf4j // 어노테이션 추가로 로깅 기능 활성화
@RequiredArgsConstructor // 생성자 기반 의존성 주입
public class BaseInitData {

    private final PostService postService;

    // ApplicationRunner Bean을 통해 애플리케이션 시작 시 초기화 로직 실행
    @Bean
    public ApplicationRunner baseInitDataRunner (){
        return args->{
            addSampleData();
        };
    }

    private void addSampleData(){
        log.debug("Post entity 개수: {}", postService.count());

        if(postService.count() > 0) return;

        for(int idx=1; idx<=10; idx++){
            String title = "Sample Post Title " + idx;
            String content = "This is the content of sample post number " + idx + ".";
            String author = "Author "+ idx;

            Post post = postService.create(title, content, author);

            log.debug("Create Post: {}", post.toString());
        }
    }
}