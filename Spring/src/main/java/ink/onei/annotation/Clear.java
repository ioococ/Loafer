package ink.onei.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: nekotako
 * @Description: 清除属性值
 * @Date: 14/12/2023 16:44 Thursday
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Clear {
    boolean clearStatus() default false;
}
