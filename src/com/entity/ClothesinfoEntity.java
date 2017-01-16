package com.entity;

import javax.persistence.*;

/*
 * Created by Moon° on 2017/1/6.
 */
@Entity
@Table(name = "clothesinfo", schema = "laundry", catalog = "")
public class ClothesinfoEntity {
    private int clothesId;
    private String clothesName;
    private Double clothesPrice;
    private String clothesType;
    private String clothesPic;

    @Id
    @Column(name = "clothes_id")
    public int getClothesId() {
        return clothesId;
    }

    public void setClothesId(int clothesId) {
        this.clothesId = clothesId;
    }

    @Basic
    @Column(name = "clothes_name")
    public String getClothesName() {
        return clothesName;
    }

    public void setClothesName(String clothesName) {
        this.clothesName = clothesName;
    }

    @Basic
    @Column(name = "clothes_price")
    public Double getClothesPrice() {
        return clothesPrice;
    }

    public void setClothesPrice(Double clothesPrice) {
        this.clothesPrice = clothesPrice;
    }

    @Basic
    @Column(name = "clothes_type")
    public String getClothesType() {
        return clothesType;
    }

    public void setClothesType(String clothesType) {
        this.clothesType = clothesType;
    }

    @Basic
    @Column(name = "clothes_pic")
    public String getClothesPic() {
        return clothesPic;
    }

    public void setClothesPic(String clothesPic) {
        this.clothesPic = clothesPic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClothesinfoEntity that = (ClothesinfoEntity) o;

        if (clothesId != that.clothesId) return false;
        if (clothesName != null ? !clothesName.equals(that.clothesName) : that.clothesName != null) return false;
        if (clothesPrice != null ? !clothesPrice.equals(that.clothesPrice) : that.clothesPrice != null) return false;
        if (clothesType != null ? !clothesType.equals(that.clothesType) : that.clothesType != null) return false;
        if (clothesPic != null ? !clothesPic.equals(that.clothesPic) : that.clothesPic != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clothesId;
        result = 31 * result + (clothesName != null ? clothesName.hashCode() : 0);
        result = 31 * result + (clothesPrice != null ? clothesPrice.hashCode() : 0);
        result = 31 * result + (clothesType != null ? clothesType.hashCode() : 0);
        result = 31 * result + (clothesPic != null ? clothesPic.hashCode() : 0);
        return result;
    }
}
