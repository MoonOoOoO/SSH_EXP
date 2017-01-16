package com.action;

import com.DAO.OrderitemManager;
import com.entity.OrderitemEntity;
import com.entity.UserinfoEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddClothesAction extends ActionSupport {
    private String clothesId;
    private String number;

    public String getClothesId() {
        return clothesId;
    }

    public void setClothesId(String clothesId) {
        this.clothesId = clothesId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String execute() throws Exception {
        ActionContext ctx = ActionContext.getContext();
        OrderitemEntity orderitem = new OrderitemEntity();
        OrderitemManager orderitemManager = new OrderitemManager();
        UserinfoEntity user = (UserinfoEntity) ctx.getSession().get("user");
        if (user == null) {
            System.out.println("session中无用户");
            return ERROR;
        }
        orderitem.setUserId(user.getUserId());
        orderitem.setClothesId(Integer.parseInt(clothesId));
        orderitem.setClothesNum(Integer.parseInt(number));
        orderitem.setOrderId(0);

        orderitemManager.addOrderitem(orderitem);
        System.out.println("用户 " + user.getUserName() + " 添加了 " + number + " 件 " + clothesId);
        ctx.put("tip", "商品已加入洗衣篮");
        ctx.put("flag", 1);
        return SUCCESS;
    }
}
