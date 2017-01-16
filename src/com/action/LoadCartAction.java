package com.action;

import com.DAO.AddressManager;
import com.DAO.ClothesinfoManager;
import com.DAO.OrderitemManager;
import com.entity.AddressEntity;
import com.entity.ClothesinfoEntity;
import com.entity.OrderitemEntity;
import com.entity.UserinfoEntity;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.*;


public class LoadCartAction extends ActionSupport implements Action {
    @Override
    public String execute() throws Exception {
        ActionContext ctx = ActionContext.getContext();
        UserinfoEntity user = (UserinfoEntity) ctx.getSession().get("user");
        if (user == null) {
            ctx.put("status", "请登录");
            return ERROR;
        }
        OrderitemManager orderitem = new OrderitemManager();
        List<AddressEntity> addressEntity = new ArrayList<>();
        AddressManager addressManager = new AddressManager();
        addressEntity = addressManager.getAddressThroughUser(user.getUserId());

        ClothesinfoEntity clothes;
        ClothesinfoManager clothesinfoManager = new ClothesinfoManager();

         /*-------获取该用户洗衣篮里所有的订单项-------*/
        List<OrderitemEntity> list = orderitem.getOrderitems(user.getUserId(), 0);
        List<Map<String, String>> orderitem_list = new ArrayList<>();
        for (OrderitemEntity o : list) {
            Map<String, String> map = new HashMap<>();
            clothes = clothesinfoManager.getClothesinfo(o.getClothesId());
            map.put("orderitemId", String.valueOf(o.getOrderitemId()));
            map.put("name", clothes.getClothesName());
            map.put("type", clothes.getClothesType());
            map.put("price", String.valueOf(clothes.getClothesPrice()));
            map.put("number", String.valueOf(o.getClothesNum()));
            map.put("picture", clothes.getClothesPic());
            orderitem_list.add(map);
        }

        ctx.put("list", orderitem_list);
        ctx.put("addresses", addressEntity);
        return SUCCESS;
    }
}
