package com.shopping.aop;

import com.shopping.entity.ErrorTip;
import com.shopping.exception.BussinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;
import java.util.function.Consumer;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	private static String SYS_ERROR  = "系统错误";

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 默认异常：系统错误
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public ErrorTip sysError(Throwable e) {
        log.error(e.getMessage(), e);
        return new ErrorTip(SYS_ERROR);
    }

    /**
     * 拦截业务异常
     */
    @ExceptionHandler(BussinessException.class)
    @ResponseBody
    public ErrorTip bussinessException(BussinessException e) {
        log.debug(e.getMessage(),e);
        return new ErrorTip(e.getCode(), e.getMessage());
    }

    /**
     * 统一处理参数校验错误
     * @param e
     * @return
     */
    @ExceptionHandler(value = {ConstraintViolationException.class, BindException.class})
    @ResponseBody
    public Object validationExceptionHandler(Exception e){
        log.debug(e.getMessage(),e);
        List list = new ArrayList();

        //方法参数校验失败时的处理
        if(e instanceof ConstraintViolationException){
            ConstraintViolationException exception = (ConstraintViolationException)e;
            Set<ConstraintViolation<?>> set = exception.getConstraintViolations();
            set.forEach(new Consumer<ConstraintViolation<?>>() {
                @Override
                public void accept(ConstraintViolation<?> constraintViolation) {
                    Map map = new HashMap();
                    String keyPath = constraintViolation.getPropertyPath().toString();
                    String paramName = keyPath.substring(keyPath.indexOf(".")+1,keyPath.length());
                    map.put(paramName,constraintViolation.getMessage());
                    list.add(map);
                }
            });
        }
        //POJO参数校验失败时的处理
        if(e instanceof BindException){
            List<FieldError> errors = ((BindException) e).getFieldErrors();
            errors.forEach(new Consumer<FieldError>() {
                @Override
                public void accept(FieldError error) {
                    Map map = new HashMap();
                    map.put(error.getField(),error.getDefaultMessage());
                    list.add(map);
                }
            });
        }
        return new ErrorTip("参数错误",list);
    }


}
