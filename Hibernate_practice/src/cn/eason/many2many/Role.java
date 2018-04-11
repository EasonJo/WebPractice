package cn.eason.many2many;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private Long roleId;
    private String roleName;
    private String roleMemo;

    private Set<User> users = new HashSet<>();

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleMemo() {
        return roleMemo;
    }

    public void setRoleMemo(String roleMemo) {
        this.roleMemo = roleMemo;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
            "roleId=" + roleId +
            ", roleName='" + roleName + '\'' +
            ", roleMemo='" + roleMemo + '\'' +
            ", users=" + users +
            '}';
    }
}
