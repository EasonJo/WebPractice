package cn.e3mall.common.pojo;

import java.io.Serializable;

/**
 * @author Eason
 * @date Create in 16:41 24/04/2018
 */
public class EasyUITreeNote implements Serializable {
    private long id;
    private String text;
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "EasyUITreeNote{" +
            "id=" + id +
            ", text='" + text + '\'' +
            ", state='" + state + '\'' +
            '}';
    }
}
