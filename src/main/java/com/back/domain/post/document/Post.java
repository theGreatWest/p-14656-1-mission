package com.back.domain.post.document;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.OffsetDateTime;

// Elasticsearch
// 검색 방식을 저장 시점에 필드 타입으로 미리 결정해야 한다.
// 필드 타입 변경 시 인덱스 재생성 필요 (마이그레이션)

@Getter
@Document(indexName = "posts")
// Elasticsearch에 posts 인덱스 생성
// JPA의 @Entity + @Table(name="posts")과 동일
public class Post {
    @Id // Elasticsearch에서는 ID가 보통 String 타입이다. 자동 생성 시 UUID 형태의 문자열이 할당된다.
    private String id;

    @Field(type = FieldType.Text) // 전문 검색 가능
    // 형태소 분석되어 부분 검색 가능 (예: "Spring Boot" 검색 시 "Spring", "Boot" 각각 매칭)
    private String title;

    @Field(type = FieldType.Text)
    private String content;

    @Field(type= FieldType.Keyword) // 정확한 일치 검색용
    // 분석되지 않고 정확히 일치해야 검색 (예: 이메일, 상태값, ID 참조용)
    private String author;

    // 둘 다 필요할 경우, @MultiField 사용
    // @MultiField(
    //    mainField = @Field(type = FieldType.Text),
    //    otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword)
    //)

    @Field(
            type = FieldType.Date,
            format = DateFormat.date_time
    )
    private OffsetDateTime createdAt;

    @Field(
            type = FieldType.Date,
            format = DateFormat.date_time
    )
    private OffsetDateTime lastModifiedAt;

    public Post(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;

        this.createdAt = OffsetDateTime.now();
        this.lastModifiedAt = OffsetDateTime.now();
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", createdAt=" + createdAt +
                ", lastModifiedAt=" + lastModifiedAt +
                '}';
    }
}
