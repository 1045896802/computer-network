package com.nju.exception;

import com.nju.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Maxyu
 * @date 2020/12/17 14:22
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 空指针异常
     *
     * @param ex NullPointerException
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleTypeMismatchException(NullPointerException ex) {
        log.error("空指针异常， {}", ex.getMessage());
        return new Result("500", false, "空指针异常了");
    }

    /**
     * 系统异常预期以外异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleUnexpectedServer(Exception ex) {
        System.out.println("ex.getMessage()");
        return new Result("500", false, ex.getMessage());
    }
}


