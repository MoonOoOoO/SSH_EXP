package com.action;


import com.DAO.OrderinfoManager;
import com.entity.OrderinfoEntity;

import java.util.List;

public class Seller {
    public List<OrderinfoEntity> getAllOrders(int status) {
        OrderinfoManager orderinfoManager = new OrderinfoManager();
        return orderinfoManager.getOrders_seller(status);
    }

    public void setOrders(List<OrderinfoEntity> list, int status) {
        OrderinfoManager orderinfoManager = new OrderinfoManager();
        for (OrderinfoEntity o : list) {
            o.setOrderStatus(status + 1);
            orderinfoManager.updateOrder(o);
        }
    }
}
