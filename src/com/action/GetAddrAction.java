package com.action;

import com.DAO.AddressManager;
import com.entity.AddressEntity;
import com.entity.UserinfoEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Moon° on 2017/1/7.
 */
public class GetAddrAction extends ActionSupport {
    public String execute() {
        ActionContext ctx = ActionContext.getContext();
        UserinfoEntity user;
        List<AddressEntity> addressEntity = new ArrayList<>();
        AddressManager addressManager = new AddressManager();

        user = (UserinfoEntity) ctx.getSession().get("user");
        addressEntity = addressManager.getAddressThroughUser(user.getUserId());
        ctx.put("address", addressEntity);
        return SUCCESS;
    }
}
