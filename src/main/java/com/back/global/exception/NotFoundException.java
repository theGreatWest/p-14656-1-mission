package com.back.global.exception;

public class NotFoundException extends DomainException{

    public NotFoundException(String message){
        super("404", message); // DomainException의 생성자에서 resultCode = 404로 고정
    }
}
