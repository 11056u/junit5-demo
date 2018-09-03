import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:
 * Author: Allen.Yang
 * Date: 2017/12/28 上午11:25
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(CustomExtensionDemo.class)
public @interface ApiTest {
    String api() default "";
    String data() default "";
}
