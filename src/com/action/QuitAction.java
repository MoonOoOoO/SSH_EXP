package com.action;

import com.entity.UserinfoEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * Created by Moon° on 2017/1/7.
 */
public class QuitAction extends ActionSupport {
    @Override
    public String execute() {
        ActionContext ctx = ActionContext.getContext();
        UserinfoEntity userinfoEntity = (UserinfoEntity) ctx.getSession().get("user");
        System.out.println("用户 " + userinfoEntity.getUserName() + " 退出");
        ctx.getSession().remove("user");
        ctx.put("flag", 2);
        return SUCCESS;
    }
}
