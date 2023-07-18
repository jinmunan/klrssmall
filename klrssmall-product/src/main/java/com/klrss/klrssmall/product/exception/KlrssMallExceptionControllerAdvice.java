package com.klrss.klrssmall.product.exception;

import com.klrss.common.exception.BizCodeEnum;
import com.klrss.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhongnan
 * 全局的统一异常处理
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.klrss.klrssmall.product.controller")
public class KlrssMallExceptionControllerAdvice {
    /**
     * 出现数据校验错误时的全局提示
     * @param e
     * @return
     */
    @ExceptionHandler(value = {WebExchangeBindException.class})
    public R handleValidException(WebExchangeBindException e) {
        log.error("数据校验出现问题：{}，异常类型是：{}", e.getMessage(), e.getClass());
        // 对校验错误的字段进行打印
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }));
        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(), BizCodeEnum.VALID_EXCEPTION.getMsg()).put("data",errorMap);
    }

    /**
     * 出现错误时的全局提示
     * @param throwable
     * @return
     */
    @ExceptionHandler(value = {Throwable.class})
    public R handleValidException(Throwable throwable) {
        log.error("错误：", throwable);
        return R.error(BizCodeEnum.UNKNOW_EXCEPTION.getCode(), BizCodeEnum.UNKNOW_EXCEPTION.getMsg());
    }

}
