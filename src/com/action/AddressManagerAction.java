package com.action;

import com.DAO.AddressManager;
import com.entity.AddressEntity;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AddressManagerAction extends ActionSupport implements Action {
    private String address;
    private int addressId;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    /**
     * 增加地址
     *
     * @return 成功
     * @throws Exception 异常
     */
    public String addAddress() throws Exception {
        AddressManager addressManager = new AddressManager();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setDetail(address);
        addressManager.addAddress(addressEntity);
        return SUCCESS;
    }

    /**
     * 更新地址
     *
     * @return 成功
     * @throws Exception 异常
     */
    public String updateAddress() throws Exception {
        AddressManager addressManager = new AddressManager();
        AddressEntity addressEntity = addressManager.getAddress(addressId);
        addressEntity.setDetail(address);
        addressManager.updateAddress(addressEntity);
        return SUCCESS;
    }

    /**
     * 删除地址
     *
     * @return 成功
     * @throws Exception 异常
     */
    public String deleteAddress() throws Exception {
        AddressManager addressManager = new AddressManager();
        addressManager.deleteAddress(addressId);
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }


}
