package io.mustang.modules.app.annotation;

import java.lang.annotation.*;

/**
 * app登录效验
 *
 * @author Mustang
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
