package com.example.likelion12.common.exception_handler;

import com.example.likelion12.common.exception.MemberException;
import com.example.likelion12.common.exception.MemberSocialringException;
import com.example.likelion12.common.response.BaseErrorResponse;
import jakarta.annotation.Priority;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Priority(0)
@RestControllerAdvice
public class MemberSocialringExceptionControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MemberSocialringException.class)
    public BaseErrorResponse handle_MemberSocialringException(MemberSocialringException e) {
        log.error("[handle_MemberSocialringException]", e);
        return new BaseErrorResponse(e.getExceptionStatus(), e.getMessage());
    }
}