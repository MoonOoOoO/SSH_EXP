package com.entity;

import javax.persistence.*;
import java.sql.Date;

/*
 * Created by Moon° on 2017/1/6.
 */
@Entity
@Table(name = "orderinfo", schema = "laundry", catalog = "")
public class OrderinfoEntity {
    private int orderId;
    private Integer userId;
    private String address;
    private Double orderPrice;
    private Integer orderStatus;
    private Date orderDate;

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "order_price")
    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Basic
    @Column(name = "order_status")
    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "order_date")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderinfoEntity that = (OrderinfoEntity) o;

        if (orderId != that.orderId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (orderPrice != null ? !orderPrice.equals(that.orderPrice) : that.orderPrice != null) return false;
        if (orderStatus != null ? !orderStatus.equals(that.orderStatus) : that.orderStatus != null) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (orderPrice != null ? orderPrice.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        return result;
    }
}
