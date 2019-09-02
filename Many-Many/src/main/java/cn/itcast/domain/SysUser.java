package cn.itcast.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
    @Table(name="sys_user")
    public class SysUser implements Serializable {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="user_id")
        private Long userId;
        @Column(name="user_code")
        private String userCode;
        @Column(name="user_name")
        private String userName;
        @Column(name="user_password")
        private String userPassword;
        @Column(name="user_state")
        private String userState;
        @ManyToMany(mappedBy ="sysUser",cascade = CascadeType.ALL)
    private Set<SysRole> roleSet = new HashSet<SysRole>();

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

    public Set<SysRole> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<SysRole> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userState='" + userState + '\'' +
                ", roleSet=" + roleSet +
                '}';
    }
}
