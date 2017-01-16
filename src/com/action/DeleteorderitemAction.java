package com.action;

import com.DAO.OrderitemManager;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteorderitemAction extends ActionSupport implements Action {
    private int orderitemId;

    public int getOrderitemId() {
        return orderitemId;
    }

    public void setOrderitemId(int orderitemId) {
        this.orderitemId = orderitemId;
    }

    @Override
    public String execute() throws Exception {
        OrderitemManager orderitemManager = new OrderitemManager();
        System.out.println("删除洗衣篮中ID=" + orderitemId);
        orderitemManager.deleteOrderitem(orderitemId);
        return SUCCESS;
    }
}
