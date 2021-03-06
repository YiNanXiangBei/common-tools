package cn.yinan.common.util;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author yinan
 * @date 19-8-11
 */
public class CommonUtil {
    /**
     * 针对多个数组进行拼接
     * @deprecated Do not use this method!
     * @see CommonUtil#concat2All(Object[][])
     * @param first
     * @param rest
     * @param <T>
     * @return
     */
    @Deprecated
    @SafeVarargs
    public static <T> T[] concatAll(T[] first, T[]... rest) {
        int totalLength = first.length;
        for (T[] array : rest) {

            totalLength += array.length;

        }
        T[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (T[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }

    /**
     * 针对多个数组进行拼接
     * @param rest
     * @param <T>
     * @return
     */
    @SafeVarargs
    public static <T> T[] concat2All(T[]... rest) {
        if (rest == null || rest.length == 0) {
            throw new RuntimeException("can not transport empty params");
        }
        if (rest.length == 1) {
            return rest[0];
        }
        int totalLength = 0;
        for (T[] array : rest) {
            totalLength += array.length;
        }
        T[] result = Arrays.copyOf(rest[0], totalLength);
        int offset = rest[0].length;
        for (int i = 1; i < rest.length; i++) {
            System.arraycopy(rest[i], 0, result, offset, rest[i].length);
            offset += rest[i].length;
        }
        return result;
    }


    /**
     * 为字符串添加日期后缀名,针对数组进行操作
     */
    public static String[] appendDate(String[] fileNames) {
        String[] newFileNames = new String[fileNames.length];
        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd");
        String dateString = "_" + format.format(new Date());
        for (int i = 0; i < fileNames.length; i++) {
            newFileNames[i] = fileNames[i] + dateString;
        }
        return newFileNames;
    }

    /**
     * 为字符串添加日期后缀名，针对单个字符串
     * @param fileName
     * @return
     */
    public static String appendDate(String fileName) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd");
        fileName = fileName + "_" + format.format(new Date());
        return fileName;
    }

    /**
     * 读取文件到byte数组
     * @param fileName
     * @return
     * @throws IOException
     */
    public static byte[] readFileFromResource(String fileName) throws IOException {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(fileName);
        RandomAccessFile accessFile = new RandomAccessFile(resource.getFile(), "r");
        byte[] bytes = new byte[(int) accessFile.length()];
        accessFile.read(bytes);
        accessFile.close();
        return bytes;
    }

    /**
     * 追加数据到配置文件，自动换行
     * @param fileName
     * @param value
     * @throws IOException
     */
    public static void appendFileToResource(String fileName, String value) throws IOException {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(fileName);
        RandomAccessFile accessFile = new RandomAccessFile(resource.getFile(), "rw");
        long fileLength = accessFile.length();
        accessFile.seek(fileLength);
        if (fileLength != 0) {
            value = System.getProperty("line.separator") + value;
        }
        accessFile.write(value.getBytes(Charset.forName("UTF-8")));
        accessFile.close();
    }

    /**
     * 写入数据到新的文件
     * @param fileName
     * @param value
     * @throws IOException
     */
    public static void saveFileToResource(String fileName, String value) throws IOException {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(fileName);
        RandomAccessFile accessFile = new RandomAccessFile(resource.getFile(), "rw");
        accessFile.setLength(0);
        accessFile.write(value.getBytes(Charset.forName("UTF-8")));
        accessFile.close();
    }

}
