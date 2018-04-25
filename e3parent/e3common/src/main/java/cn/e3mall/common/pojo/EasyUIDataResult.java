package cn.e3mall.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Eason
 * @date Create in 15:41 24/04/2018
 */
public class EasyUIDataResult<T> implements Serializable {
    private long total;
    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
