package cn.yinan.common.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yinan
 * @date 19-8-31
 */
public class JsonUtilTest {

    @Test
    public void json2object() {
        String json = "{\n" +
                "  \"name\": \"yinan_name\",\n" +
                "  \"pass\": \"yinan_pass\"\n" +
                "}";
        JSONTest test = JsonUtil.json2object(json, JSONTest.class);
        Assert.assertEquals("yinan_name", test.getName());
        Assert.assertEquals("yinan_pass", test.getPass());
    }

    @Test
    public void object2json() {
        JSONTest test = new JSONTest("yinan_name", "yinan_pass");
        String jsonStr = JsonUtil.object2json(test);
        String exp = "{\n" +
                "  \"name\": \"yinan_name\",\n" +
                "  \"pass\": \"yinan_pass\"\n" +
                "}";
        Assert.assertEquals(exp, jsonStr);
        System.out.println(jsonStr);
    }

    @Test
    public void json2object1() {

    }

    class JSONTest {
        private String name;

        private String pass;

        public JSONTest(String name, String pass) {
            this.name = name;
            this.pass = pass;
        }

        public JSONTest() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }
    }
}