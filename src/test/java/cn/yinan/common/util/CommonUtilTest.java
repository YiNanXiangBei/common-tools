package cn.yinan.common.util;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author yinan
 * @date 19-8-31
 */
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