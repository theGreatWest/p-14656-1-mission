package com.back.global.exception;

// 커스텀 예외처리기

// RuntimeException : 상속 (Unchecked Exception)
public class DomainException extends RuntimeException{
    String resultCode;

    // resultCode: 에러 코드 (예: "404", "400")
    // message: 에러 메시지
    public DomainException(String resultCode, String message){
        super(message);
        this.resultCode = resultCode;
    }
}
