package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderitem", schema = "laundry", catalog = "")
public class OrderitemEntity {
    private int orderitemId;
    private Integer orderId;
    private Integer clothesId;
    private Integer clothesNum;
    private Integer userId;

    @Id
    @Column(name = "orderitem_id")
    public int getOrderitemId() {
        return orderitemId;
    }

    public void setOrderitemId(int orderitemId) {
        this.orderitemId = orderitemId;
    }

    @Basic
    @Column(name = "order_id")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "clothes_id")
    public Integer getClothesId() {
        return clothesId;
    }

    public void setClothesId(Integer clothesId) {
        this.clothesId = clothesId;
    }

    @Basic
    @Column(name = "clothes_num")
    public Integer getClothesNum() {
        return clothesNum;
    }

    public void setClothesNum(Integer clothesNum) {
        this.clothesNum = clothesNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderitemEntity that = (OrderitemEntity) o;

        if (orderitemId != that.orderitemId) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (clothesId != null ? !clothesId.equals(that.clothesId) : that.clothesId != null) return false;
        if (clothesNum != null ? !clothesNum.equals(that.clothesNum) : that.clothesNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderitemId;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (clothesId != null ? clothesId.hashCode() : 0);
        result = 31 * result + (clothesNum != null ? clothesNum.hashCode() : 0);
        return result;
    }


    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
