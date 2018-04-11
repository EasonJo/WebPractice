package cn.eason.many2many;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Long userId;
    private String userCode;
    private String userName;
    private String userPassword;
    private String userState;

    private Set<Role> roles = new HashSet<>();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
            "userId=" + userId +
            ", userCode='" + userCode + '\'' +
            ", userName='" + userName + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", userState='" + userState + '\'' +
            ", roles=" + roles +
            '}';
    }
}
