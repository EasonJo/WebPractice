package cn.eason.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * User Bean
 *
 * @author Eason
 */
@Component("user")
public class User {
    @Value("Eason")
    private String name;
    @Value("18")
    private int age;

    @Resource(name = "car2")
    private Car car;

    public User() {
    }

    public User(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @PreDestroy // destory-method
    public void destory() {
        System.out.println("destory");
    }

    @PostConstruct //init-method
    public void init() {
        System.out.println("init method");
    }

    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", car=" + car +
            '}';
    }
}
