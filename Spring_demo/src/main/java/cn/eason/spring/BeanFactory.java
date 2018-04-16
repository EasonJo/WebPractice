package cn.eason.spring;

import cn.eason.bean.User;

public class BeanFactory {
    public static User CreateUser(){
        System.out.println("static factory create");
        return new User();
    }

    public User createUser2(){
        System.out.println("instance factory");
        return new User();
    }
}
