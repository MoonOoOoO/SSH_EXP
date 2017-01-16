package com.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/*
 * Created by Moon° on 2017/1/6.
 */
@Entity
@Table(name = "userinfo", schema = "laundry", catalog = "")
public class UserinfoEntity {
    private int userId;
    private String userName;
    private String userPsw;
    private String userTel;
    private int userType;
    private BigDecimal userBalance;
    private Integer userPoint;
    private String userHeadpic;
    private Integer userDefaultaddr;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_psw")
    public String getUserPsw() {
        return userPsw;
    }

    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw;
    }

    @Basic
    @Column(name = "user_tel")
    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    @Basic
    @Column(name = "user_type")
    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "user_balance")
    public BigDecimal getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(BigDecimal userBalance) {
        this.userBalance = userBalance;
    }

    @Basic
    @Column(name = "user_point")
    public Integer getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(Integer userPoint) {
        this.userPoint = userPoint;
    }

    @Basic
    @Column(name = "user_headpic")
    public String getUserHeadpic() {
        return userHeadpic;
    }

    public void setUserHeadpic(String userHeadpic) {
        this.userHeadpic = userHeadpic;
    }

    @Basic
    @Column(name = "user_defaultaddr")
    public Integer getUserDefaultaddr() {
        return userDefaultaddr;
    }

    public void setUserDefaultaddr(Integer userDefaultaddr) {
        this.userDefaultaddr = userDefaultaddr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserinfoEntity that = (UserinfoEntity) o;

        if (userId != that.userId) return false;
        if (userType != that.userType) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userPsw != null ? !userPsw.equals(that.userPsw) : that.userPsw != null) return false;
        if (userTel != null ? !userTel.equals(that.userTel) : that.userTel != null) return false;
        if (userBalance != null ? !userBalance.equals(that.userBalance) : that.userBalance != null) return false;
        if (userPoint != null ? !userPoint.equals(that.userPoint) : that.userPoint != null) return false;
        if (userHeadpic != null ? !userHeadpic.equals(that.userHeadpic) : that.userHeadpic != null) return false;
        if (userDefaultaddr != null ? !userDefaultaddr.equals(that.userDefaultaddr) : that.userDefaultaddr != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPsw != null ? userPsw.hashCode() : 0);
        result = 31 * result + (userTel != null ? userTel.hashCode() : 0);
        result = 31 * result + userType;
        result = 31 * result + (userBalance != null ? userBalance.hashCode() : 0);
        result = 31 * result + (userPoint != null ? userPoint.hashCode() : 0);
        result = 31 * result + (userHeadpic != null ? userHeadpic.hashCode() : 0);
        result = 31 * result + (userDefaultaddr != null ? userDefaultaddr.hashCode() : 0);
        return result;
    }
}
