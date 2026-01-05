package com.back.domain.post.repository;

import com.back.domain.post.document.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/*

ElasticsearchRepository<Post, String> 상속
* 첫 번째 제네릭: 엔티티 타입
* 두 번째 제네릭: ID 타입 (Elasticsearch는 String ID 사용)
* JPA의 JpaRepository<Post, Long>에 해당

제공: save(entity), findById(id), findAll(), delete(entity), count(), existsById(id)
제공X(JPA만 제공): flush(), saveAndFlush()

*/

public interface PostRepository extends ElasticsearchRepository<Post,String> {

    List<Post> findAll();
    // 💡 왜 findAll()을 재선언?
    // ElasticsearchRepository의 기본 findAll()은 Iterable<Post>를 반환합니다.
    // List<Post> 반환 타입으로 재선언하면 Spring Data가 자동으로 List로 변환해줍니다.
    // JPA의 JpaRepository는 기본으로 List<T>를 반환하므로 재선언이 필요 없습니다.
}
