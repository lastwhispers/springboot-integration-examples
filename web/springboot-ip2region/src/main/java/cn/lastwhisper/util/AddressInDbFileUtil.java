package cn.lastwhisper.util;

import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * ip 转成地址
 * <p>
 * search接口不是线程安全的实现，不同线程可以通过创建不同的查询对象来使用，
 * 并发量很大的情况下，binary和b-tree算法可能会打开文件数过多的错误，请修改内核的最大允许打开文件数(fs.file-max=一个更高的值)
 *
 * @author lastwhisper
 * @date 2020/5/31
 */
public class AddressInDbFileUtil {

    private static final String DB_CLASS_PATH = "/ip2region.db";

    /**
     * 默认 b-tree 算法查询
     */
    private static final int ALGORITHM = DbSearcher.BTREE_ALGORITHM;

    private static Logger logger = LoggerFactory.getLogger(AddressInDbFileUtil.class);

    public static DataBlock getCityInfo(String ip) {
        if (!Util.isIpAddress(ip)) {
            logger.error("{} is invalid ip address", ip);
        }

        DbSearcher searcher = null;
        try {
            String dbPath = AddressInDbFileUtil.class.getResource(DB_CLASS_PATH).getPath();
            DbConfig config = new DbConfig();
            searcher = new DbSearcher(config, dbPath);
            DataBlock dataBlock = null;

            switch (ALGORITHM) {
                case DbSearcher.BTREE_ALGORITHM:
                    dataBlock = searcher.btreeSearch(ip);
                    break;
                case DbSearcher.BINARY_ALGORITHM:
                    dataBlock = searcher.binarySearch(ip);
                    break;
                case DbSearcher.MEMORY_ALGORITYM:
                    dataBlock = searcher.memorySearch(ip);
                    break;
                default:
                    break;
            }

            return dataBlock;
        } catch (Exception e) {
            logger.error("ip convert fail", e);
        } finally {
            if (searcher != null) {
                try {
                    searcher.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(getCityInfo("117.147.32.68"));
        System.out.println(getCityInfo("127.0.0.1"));
    }
}
