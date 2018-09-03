import org.junit.jupiter.api.Test;

/**
 * Description:
 * Author: Allen.Yang
 * Date: 2017/12/28 上午10:53
 */
@ApiTest(api = "api template file", data = "api test data template file")
class ExtensionTest {

    @Test void test01() {
        System.out.println("current test is test01...");
		System.out.println();
    }

    @Test void test02(User user) {
        System.out.println(user.getId());
        System.out.println(user.getName());
    }
}
