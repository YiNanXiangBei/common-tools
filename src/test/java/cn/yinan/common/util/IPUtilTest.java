package cn.yinan.common.util;

import org.junit.Assert;
import org.junit.Test;

import java.net.UnknownHostException;

import static org.junit.Assert.*;

/**
 * @author yinan
 * @date 19-8-31
 */
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