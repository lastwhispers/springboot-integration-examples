package cn.lastwhisper.model;

import java.io.Serializable;

/**
 * @author lastwhisper
 */
public class QueryRequest implements Serializable {

    /**
     * 当前页面数据量
     */
    private int size = 10;

    /**
     * 当前页码
     */
    private int current = 1;

    /**
     * 排序字段
     */
    private String field;

    /**
     * 排序规则，asc升序，desc降序
     */
    private String order;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
