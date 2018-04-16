package cn.eason.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Eason
 */
@Component("car")
public class Car {
    @Value("兰博基尼")
    private String name;
    @Value("红色")
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "Car{" +
            "name='" + name + '\'' +
            ", color='" + color + '\'' +
            '}';
    }
}
