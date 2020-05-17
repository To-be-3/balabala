package com.balabala.balabala.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "company")
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;
    @Column(length = 30)
    @NotNull
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return companyId.equals(company.companyId) &&
                username.equals(company.username) &&
                account.equals(company.account) &&
                password.equals(company.password) &&
                phone.equals(company.phone) &&
                email.equals(company.email) &&
                grants.equals(company.grants) &&
                score.equals(company.score) &&
                introduction.equals(company.introduction) &&
                address.equals(company.address) &&
                createTime.equals(company.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, username, account, password, phone, email, grants, score, introduction, address, createTime);
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
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
                '}';
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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
}
