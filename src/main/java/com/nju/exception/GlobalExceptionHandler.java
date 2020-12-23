package com.nju.exception;

import com.nju.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Maxyu
 * @date 2020/12/17 14:22
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger logger =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 空指针异常
     *
     * @param ex NullPointerException
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleTypeMismatchException(NullPointerException ex) {
        logger.error("空指针异常， {}", ex.getMessage());
        return new Result("500", false,"空指针异常了");
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
       // logger.error("系统异常: ", ex);
        System.out.println("系统异常");
//        return new Result(BusinessMsgEnum.UNEXPECTED_EXCEPTION);
        return new Result("500", false,"系统发生异常,请联系管理员");
    }
}


