package com.back.global.initData;

import com.back.domain.post.document.Post;
import com.back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration // 설정 클래스 지정
@Slf4j // 어노테이션 추가로 로깅 기능 활성화
@RequiredArgsConstructor // 생성자 기반 의존성 주입
public class BaseInitData {

    private final PostService postService;

    // ApplicationRunner Bean을 통해 애플리케이션 시작 시 초기화 로직 실행
    @Bean
    public ApplicationRunner baseInitDataRunner (){
        return args->{
            work1();
            work2();
            work3();
        };
    }

    // 개수 0개이면 Post 데이터 10개 생성
    private void work1(){
        log.debug("Post entity 개수: {}", postService.count());

        if(postService.count() > 0) return;

        log.debug("샘플 Post 데이터 생성");
        for(int idx=1; idx<=10; idx++){
            String title = "Sample Post Title " + idx;
            String content = "This is the content of sample post number " + idx + ".";
            String author = "Author "+ idx;

            Post post = postService.create(title, content, author);

            log.debug("Create Post: {}", post.toString());
        }
    }

    // 기존 Post 전체 조회 및 로깅으로 저장된 데이터 확인
    private void work2(){
        log.debug("기존 Post 데이터 전체 조회");

        for (Post post : postService.findAll()){
            log.debug("Existing Post: {}", post);
        }
    }

    // Post 단건 조회 테스트 로직 추가
    private void work3(){
        log.debug("Post 단건 조회");

        for (Post post : postService.findAll()){
            Optional<Post> opPost = postService.findById(post.getId());

            if(opPost.isEmpty()){
                log.debug("Post ID {}는 존재하지 않습니다.", post.getId());
                continue;
            }

            log.debug("조회된 Post: {}", opPost.get());
        }
    }
}