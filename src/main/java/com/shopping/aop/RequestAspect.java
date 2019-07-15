package com.shopping.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class RequestAspect {
    Logger logger = LoggerFactory.getLogger(RequestAspect.class);


    /**
     * 定义控制器层的切入点,即拦截控制器层的公共方法
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void log() {
    }


    /**
     * 环绕输出方法的入参与回参
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("log()")
    public Object aroundNotice(ProceedingJoinPoint point) throws Throwable {
        String requestURI = null;
        Map<String, Object> paramMap = new HashMap<>();
        String userId = null;
        try {
            HttpServletRequest request = getHttpServletRequest();
            MethodSignature signature = (MethodSignature) point.getSignature();
            String[] params = signature.getParameterNames();
            requestURI = request.getRequestURI();
            point.getSignature().getDeclaringTypeName();
            Object[] args = point.getArgs();
            for (int i = 0; i < params.length; i++) {
                if (args[i] == null) {
                    paramMap.put(params[i], "");
                } else {
                    try {
                        paramMap.put(params[i], JSON.toJSONString(args[i]));
                    } catch (Exception e) {
                        logger.warn("参数{}序列化错误", params[i]);
                    }
                }
            }
        } catch (Exception e) {
            logger.warn("日志处理错误", e);
        }
        Object result = point.proceed();
        try {
            String res = JSON.toJSONString(result);
            if (res.length() > 400) {
                res = res.substring(0, 400);
            }
            logger.info("用户:{};请求url:{};参数:{};返回结果:{}", userId, requestURI, paramMap, res);
        } catch (Exception e) {
            logger.warn("logger错误", e);
        }
        return result;
    }

    protected HttpServletRequest getHttpServletRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
}
