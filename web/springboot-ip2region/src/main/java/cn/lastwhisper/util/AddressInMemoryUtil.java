package cn.lastwhisper.util;

import org.lionsoul.ip2region.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * ip2region以内存的方式启动，DbSearcher 并发读线程安全，可用于高并发场景
 *
 * @author lastwhisper
 * @date 2020/5/31
 */
public class AddressInMemoryUtil {

    private static final String DB_CLASS_PATH = "/ip2region.db";

    private static Logger logger = LoggerFactory.getLogger(AddressInMemoryUtil.class);

    private static DbSearcher searcher = null;

    static {
        String dbPath = AddressInMemoryUtil.class.getResource(DB_CLASS_PATH).getPath();
        File file = new File(dbPath);
        try (InputStream is = new FileInputStream(file);
             ByteArrayOutputStream bos = new ByteArrayOutputStream();) {

            int len;
            byte[] buffer = new byte[1024];
            while ((len = (is.read(buffer, 0, buffer.length))) != -1) {
                bos.write(buffer, 0, len);
            }

            DbConfig config = new DbConfig();
            searcher = new DbSearcher(config, bos.toByteArray());
        } catch (DbMakerConfigException | IOException e) {
            logger.error("dbSearcher initial fail", e);
        }
    }

    /**
     * @param ip 117.147.32.68
     * @return org.lionsoul.ip2region.DataBlock
     * _城市Id|国家|区域|省份|城市|ISP_
     * 1132|中国|0|浙江省|杭州市|移动|155200
     */
    public static DataBlock getCityInfo(String ip) {
        if (!Util.isIpAddress(ip)) {
            logger.error("{} is invalid ip address", ip);
        }
        DataBlock dataBlock;
        try {
            dataBlock = searcher.memorySearch(ip);
            return dataBlock;
        } catch (Exception e) {
            logger.error("ip convert fail", e);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getCityInfo("117.147.32.68"));
        System.out.println(getCityInfo("127.0.0.1"));
    }

}
