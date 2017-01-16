package com.action;

import com.DAO.AddressManager;
import com.DAO.OrderinfoManager;
import com.DAO.OrderitemManager;
import com.entity.AddressEntity;
import com.entity.OrderinfoEntity;
import com.entity.OrderitemEntity;
import com.entity.UserinfoEntity;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Date;
import java.util.List;

public class AddorderAction extends ActionSupport implements Action {
    private String order_address;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String execute() throws Exception {
        ActionContext ctx = ActionContext.getContext();
        OrderitemManager orderitemManager = new OrderitemManager();
        OrderinfoManager orderinfoManager = new OrderinfoManager();
        OrderinfoEntity order = new OrderinfoEntity();
        UserinfoEntity user = (UserinfoEntity) ctx.getSession().get("user");
        if (user == null) {
            return "过期的页面";
        }
        /*-------获取该用户洗衣篮里所有的订单项-------*/
        List<OrderitemEntity> list = orderitemManager.getOrderitems(user.getUserId(), 0);
        if (list.isEmpty()) {
            return "没有待洗衣物";
        }

        Date date = new Date(new java.util.Date().getTime());
        order.setUserId(user.getUserId());
        order.setAddress(order_address);
        order.setOrderPrice(price);
        order.setOrderStatus(1);
        order.setOrderDate(date);
        orderinfoManager.addOrder(order);
        int orderId = orderinfoManager.getOrderId(user.getUserId(), date);
        for (OrderitemEntity orderitem : list) {
            orderitem.setOrderId(orderId);
            orderitemManager.updateOrderitem(orderitem);
        }
        return SUCCESS;
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }
}
