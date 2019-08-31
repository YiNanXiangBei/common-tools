# 个人工具类仓库
## 2019/08/31更新
* 读取`resource`目录下配置文件数据
```java
public class ConfigTest {

    @Test
    public void getStringValue() {
        String value = Config.getInstance().getStringValue("common.tools.test-string");
        Assert.assertEquals("string", value);
        String val = Config.getInstance("common-config.properties").getStringValue("common.tools.test-string");
        Assert.assertEquals("string", val);

    }

    @Test
    public void getIntValue() {
        int value = Config.getInstance().getIntValue("common.tools.test-int");
        Assert.assertEquals(1, value);
        int val = Config.getInstance("common-config.properties").getIntValue("common.tools.test-int");
        Assert.assertEquals(1, val);
    }

    @Test
    public void getDoubleValue() {
        double value = Config.getInstance().getDoubleValue("common.tools.test-double");
        Assert.assertEquals(1.111, value, 0);
        double val = Config.getInstance("common-config.properties").getDoubleValue("common.tools.test-double");
        Assert.assertEquals(1.111, val, 0);
    }

    @Test
    public void getLongValue() {
        long value = Config.getInstance().getLongValue("common.tools.test-long");
        Assert.assertEquals(23, value);
        long val = Config.getInstance("common-config.properties").getLongValue("common.tools.test-long");
        Assert.assertEquals(23, val);
    }

    @Test
    public void getBooleanValue() {
        boolean value = Config.getInstance().getBooleanValue("common.tools.test-boolean");
        Assert.assertTrue(value);
        boolean val = Config.getInstance("common-config.properties").getBooleanValue("common.tools.test-boolean");
        Assert.assertTrue(val);
    }
}
```
* 获取对象中指定属性的值
```java
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
```
* 公共操作
```java
public class CommonUtilTest {

    @Test
    public void concatAll() {
        String[] strs1 = new String[] {"1", "2"};
        String[] strs2 = new String[] {"3", "4"};
        String[] results = CommonUtil.concat2All(strs1, strs2);
        Assert.assertEquals(4, results.length);
        String[] validateArray = new String[] {"1", "2", "3", "4"};
        Assert.assertArrayEquals(validateArray,results);
    }

    @Test
    public void appendDate() {
        String fileName = "test";
        String str = CommonUtil.appendDate(fileName);
        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd");
        fileName = fileName + "_" + format.format(new Date());
        Assert.assertEquals(fileName, str);
    }

    @Test
    public void appendDate1() {
        String[] fileNames = new String[] {"name1", "name2"};
        fileNames = CommonUtil.appendDate(fileNames);
        Assert.assertEquals(2, fileNames.length);
        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd");
        String exp = "name1_" + format.format(new Date());
        Assert.assertEquals(exp, fileNames[0]);
    }

    @Test
    public void readFileFromResource() {
        
    }

    @Test
    public void appendFileToResource() {
    }

    @Test
    public void saveFileToResource() {
    }
}
```
* `json`转换
```java
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
```
* `ip`地址和`int`类型进行转换
```java
public class IPUtilTest {

    @Test
    public void ipToInt() throws UnknownHostException {
        String ip = "192.168.1.1";
        int ipInt = IPUtil.ipToInt(ip);
        Assert.assertEquals(-1062731519, ipInt);
    }

    @Test
    public void intToIp() {
        int ipInt = -1062731519;
        String ip = IPUtil.intToIp(ipInt);
        Assert.assertEquals("192.168.1.1", ip);
    }
}
```
* 类型转换
```java
public class LangUtilTest {

    @Test
    public void parseBoolean() {
        String btrue = "true";
        Assert.assertTrue(LangUtil.parseBoolean(btrue));
    }

    @Test
    public void parseInt() {
        String sInt = "1";
        Assert.assertEquals(new Integer(1), LangUtil.parseInt(sInt));
    }

    @Test
    public void parseLong() {
        String sLong = "1";
        Assert.assertEquals(new Long(1), LangUtil.parseLong(sLong));
    }

    @Test
    public void parseDouble() {
        String sDouble = "1.11";
        Assert.assertEquals(new Double(1.11), LangUtil.parseDouble(sDouble));
    }
}
```