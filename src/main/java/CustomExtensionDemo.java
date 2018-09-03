import org.junit.jupiter.api.extension.*;

import java.lang.reflect.Parameter;

/**
 * Description:
 * Author: Allen.Yang
 * Date: 2017/12/28 上午10:49
 */
public class CustomExtensionDemo implements BeforeTestExecutionCallback, BeforeAllCallback, ParameterResolver {

    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
//        String name = "";
//        if (extensionContext.getTestMethod().isPresent()) {
//            name = extensionContext.getTestMethod().get().getName();
//        }
//        System.out.println(name);
        extensionContext.getTestMethod().ifPresent(System.out::println);
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
//        ApiTest apiTest = null;
        extensionContext.getElement().ifPresent(System.out::println);
//        System.out.println(apiTest.api());
//        System.out.println(apiTest.data());
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == User.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Parameter parameter = parameterContext.getParameter();
        Class<?> type = parameter.getType();
        User user = new User();
        if (type == User.class) {
            System.out.println("param is user class");
            user.setId(123);
            user.setName("456");
        }
        return user;
    }
}
