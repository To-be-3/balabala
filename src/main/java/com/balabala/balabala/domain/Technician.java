package com.balabala.balabala.domain;

import com.sun.istack.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name = "technician")
@Entity
public class Technician implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer technicianId;
    @NotNull
    @Column(length = 30)
    private String username;
    @NotNull
    @Column(length = 30,unique = true)
    private String account;
    @NotNull
    @Column(length = 30)
    private String password;
    private String phone;
    private String email;
    private Integer grants;
    private Integer score;
    private String introduction;
    @NotNull
    private String address;
    private LocalDateTime createTime;
    private Integer type=0;
//    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
//    @Nullable
//    private Set<Project> projects=new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Technician that = (Technician) o;
        return technicianId.equals(that.technicianId) &&
                username.equals(that.username) &&
                account.equals(that.account) &&
                password.equals(that.password) &&
                phone.equals(that.phone) &&
                email.equals(that.email) &&
                grants.equals(that.grants) &&
                score.equals(that.score) &&
                introduction.equals(that.introduction) &&
                address.equals(that.address) &&
                createTime.equals(that.createTime) &&
                type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(technicianId, username, account, password, phone, email, grants, score, introduction, address, createTime, type);
    }

    @Override
    public String toString() {
        return "Technician{" +
                "technicianId=" + technicianId +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", grant=" + grants +
                ", score=" + score +
                ", introduction='" + introduction + '\'' +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                ", type=" + type +
                '}';
    }

    public Integer getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Integer technicianId) {
        this.technicianId = technicianId;
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

    public Integer getGrants() {
        return grants;
    }

    public void setGrants(Integer grant) {
        this.grants = grant;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
