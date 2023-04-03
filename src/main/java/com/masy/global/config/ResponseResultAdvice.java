package com.masy.global.config;

import com.masy.global.exception.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @ClassName ResponseResultAdvice
 * @Description 返回数据封装
 * @Author masy
 * @Date 2023/4/323:49
 **/
@RestControllerAdvice
public class ResponseResultAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 跳过判断是否有返回值，直接调用beforeBodyWrite
     *
     * @param returnType    返回值类型
     * @param converterType
     * @return boolean
     * @author masy
     * @date 2023/4/3 23:50
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Result) {
            return body;
        } else {
            return Result.success(body);
        }
    }
}
