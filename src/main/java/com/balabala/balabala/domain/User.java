package com.balabala.balabala.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(length = 30)
    private String username;
    @Column(length = 30, unique = true)
    @NotNull
    private String account;
    @Column(length = 30)
    @NotNull
    private String password;
    private Integer type=1;
    public enum Sex{
        男,女;//枚举中常量结束位置要有分号
        public static List<String> toList(){
            Sex[] sex=Sex.values();
            List<String> list=new ArrayList<>();
            for(Sex s:sex){
                list.add(s.name());
            }
            return list;
        }
    };
    private Sex sex;
    private LocalDate birthday;
    @Column(length = 11)
    private String phone;
    @Column(length = 100)
    private String email;
    private LocalDateTime lastLoginTime;
    private LocalDateTime createTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId) &&
                username.equals(user.username) &&
                account.equals(user.account) &&
                password.equals(user.password) &&
                sex == user.sex &&
                birthday.equals(user.birthday) &&
                phone.equals(user.phone) &&
                email.equals(user.email) &&
                lastLoginTime.equals(user.lastLoginTime) &&
                createTime.equals(user.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, account, password, sex, birthday, phone, email, lastLoginTime, createTime);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
