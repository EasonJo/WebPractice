package cn.eason.springboot.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Eason
 * @date Create in 14:40 15/05/2018
 */
public class User implements Serializable{
    private Integer id;
    private String userName;
    private Date birthDay;
    private String address;
    private String sex;


    public User() {
    }

    public User(Integer id, String userName, Date birthDay, String address, String sex) {
        this.id = id;
        this.userName = userName;
        this.birthDay = birthDay;
        this.address = address;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
