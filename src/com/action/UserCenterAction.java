package com.action;

import com.DAO.OrderinfoManager;
import com.DAO.UserInfoManager;
import com.entity.OrderinfoEntity;
import com.entity.UserinfoEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/*
 * Created by Moon° on 2017/1/6.
 */
public class UserCenterAction extends ActionSupport {
    private UserinfoEntity user;

    @Override
    public String execute() {
        ActionContext ctx = ActionContext.getContext();
        UserInfoManager userInfoManager = new UserInfoManager();
        List<OrderinfoEntity> orders;
        OrderinfoManager orderinfoManager = new OrderinfoManager();
        user = (UserinfoEntity) ctx.getSession().get("user");
        user = userInfoManager.getUser(user.getUserId());
        orders = orderinfoManager.getOrders(user.getUserId());
        ctx.getSession().put("orders", orders);
        ctx.getSession().put("user", user);
        return SUCCESS;
    }

    public UserinfoEntity getUser() {
        return user;
    }

    public void setUser(UserinfoEntity user) {
        this.user = user;
    }
}
