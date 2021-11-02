package io.mustang.common.exception;

import io.mustang.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 异常处理器
 *
 * @author Mustang
 */
@Slf4j
@RestControllerAdvice
public class RRExceptionHandler {
//	private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(RRException.class)
    public R handleRRException(RRException e) {
        R r = new R();
        r.put("code", e.getCode());
        r.put("msg", e.getMessage());

        return r;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public R handlerNoFoundException(Exception e) {
        log.error(e.getMessage(), e);
        return R.error(404, "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public R handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(), e);
        return R.error("数据库中已存在该记录");
    }

//    @ExceptionHandler(AuthorizationException.class)
//    public R handleAuthorizationException(AuthorizationException e) {
//        log.error(e.getMessage(), e);
//        return R.error("没有权限，请联系管理员授权");
//    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        log.error(e.getMessage(), e);
        return R.error();
    }
}
