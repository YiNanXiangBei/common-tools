package cn.yinan.common.util;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yinan
 * @date 19-8-31
 */
public class BeanUtilTest {

    @Test
    public void getGetMethod() throws InvocationTargetException, IllegalAccessException {
        BeanTest beanTest = new BeanTest("yinan_name", "yinan_pass");
        Method nameGetMethod = BeanUtil.getGetMethod(BeanTest.class, "name");
        String name = (String) nameGetMethod.invoke(beanTest);
        Assert.assertEquals("yinan_name", name);
    }

    @Test
    public void getValue() throws Exception {
        BeanTest beanTest = new BeanTest("yinan_name", "yinan_pass");
        String pass = (String)BeanUtil.getValue(beanTest, "password");
        Assert.assertEquals("yinan_pass", pass);
    }

    class BeanTest {
        private String name;

        private String password;

        public BeanTest(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}