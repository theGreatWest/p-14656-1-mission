package com.back.domain.post.post.repository;

import com.back.domain.post.post.document.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/*

ElasticsearchRepository<Post, String> 상속
* 첫 번째 제네릭: 엔티티 타입
* 두 번째 제네릭: ID 타입 (Elasticsearch는 String ID 사용)
* JPA의 JpaRepository<Post, Long>에 해당

제공: save(entity), findById(id), findAll(), delete(entity), count(), existsById(id)
제공X(JPA만 제공): flush(), saveAndFlush()

*/

public interface PostRepository extends ElasticsearchRepository<Post,String> {
}
