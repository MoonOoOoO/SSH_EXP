package com.entity;

import javax.persistence.*;

/*
 * Created by Moon° on 2017/1/6.
 */
@Entity
@Table(name = "address", schema = "laundry", catalog = "")
public class AddressEntity {
    private int addressId;
    private int userId;
    private String city;
    private String school;
    private String compus;
    private String detail;

    @Id
    @Column(name = "address_id")
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "school")
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Basic
    @Column(name = "compus")
    public String getCompus() {
        return compus;
    }

    public void setCompus(String compus) {
        this.compus = compus;
    }

    @Basic
    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntity that = (AddressEntity) o;

        if (addressId != that.addressId) return false;
        if (userId != that.userId) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (school != null ? !school.equals(that.school) : that.school != null) return false;
        if (compus != null ? !compus.equals(that.compus) : that.compus != null) return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressId;
        result = 31 * result + userId;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (compus != null ? compus.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        return result;
    }
}
