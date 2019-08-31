package cn.yinan.common.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yinan
 * @date 19-8-31
 */
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