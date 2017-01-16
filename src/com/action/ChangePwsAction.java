package com.action;

import com.DAO.UserInfoManager;
import com.entity.UserinfoEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.HashMap;
import java.util.Map;

public class ChangePwsAction extends ActionSupport {
    private String userTel;
    private String O_password;
    private String N_password;

    @Override
    public String execute() {
        ActionContext ctx = ActionContext.getContext();
        UserInfoManager userInfoManager = new UserInfoManager();
        UserinfoEntity user = (UserinfoEntity) ctx.getSession().get("user");
        Map<String, String> map = new HashMap<>();
        map.put("userpassword", N_password);
        if (userTel.equals(user.getUserTel()) && O_password.equals(user.getUserPsw())) {
            userInfoManager.updateUser(map, user.getUserId());
            System.out.println("用户 " + user.getUserName() + "修改密码成功");
            ctx.put("status", "修改密码成功，请重新登录");
            return SUCCESS;
        } else {
            ctx.put("status", "输入信息有误，修改密码失败");
            return ERROR;
        }
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getO_password() {
        return O_password;
    }

    public void setO_password(String o_password) {
        O_password = o_password;
    }

    public String getN_password() {
        return N_password;
    }

    public void setN_password(String n_password) {
        N_password = n_password;
    }
}
