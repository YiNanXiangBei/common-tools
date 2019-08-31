package cn.yinan.common.config;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author yinan
 * @date 19-8-31
 */
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