package link.xuchen.global.exception.exceptions;

import link.xuchen.global.exception.common.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create with IDEA
 * Ludan
 * Data:2019/4/16 4:57 PM
 * Description: 全局异常处理类
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有不可知异常
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    MessageDTO handleException(Exception e){
        log.error("error:", e);
        return MessageDTO.build().error(404, "internal error");
    }

    /**
     * 处理已知特定异常
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    MessageDTO handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("error:", e);
        return MessageDTO.build().error(500, "参数异常");
    }

    /**
     * 处理已知特定异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    MessageDTO handleBusinessException(BusinessException e){
        log.error("error:", e);
        return MessageDTO.build().error(404, e.getMessage());
    }


}
