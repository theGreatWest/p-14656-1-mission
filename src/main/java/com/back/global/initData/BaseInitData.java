package com.back.global.initData;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 클래스 지정
public class BaseInitData {

    // ApplicationRunner Bean을 통해 애플리케이션 시작 시 초기화 로직 실행
    @Bean
    public ApplicationRunner baseInitDataRunner (){
        return args->{
            System.out.println("ApplicationRunner 빈은 스프링에 등록되면 자동으로 실행됩니다");
        };
    }
}