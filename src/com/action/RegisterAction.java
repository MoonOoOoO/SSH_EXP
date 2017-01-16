package com.action;

import com.DAO.UserInfoManager;
import com.entity.UserinfoEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.math.BigDecimal;

/*
 * Created by Moon° on 2017/1/6.
 */
public class RegisterAction extends ActionSupport {
    private String username;
    private String userTel;
    private String password;

    @Override
    public String execute() {
        ActionContext ctx = ActionContext.getContext();
        UserInfoManager userInfoManager = new UserInfoManager();
        UserinfoEntity user;
        String status = userInfoManager.isExist(username, userTel);
        if ("注册成功".equals(status)) {
            user = new UserinfoEntity();
            user.setUserName(username);
            user.setUserTel(userTel);
            user.setUserPsw(password);
            user.setUserBalance(BigDecimal.valueOf(0));
            user.setUserPoint(0);
            user.setUserType(0);
            user.setUserHeadpic(null);
            user.setUserDefaultaddr(-1);
            userInfoManager.addUser(user);
            System.out.println("用户 " + user.getUserName() + " 注册成功");
            ctx.getSession().put("user", user);
            ctx.put("status", status);
            return SUCCESS;
        } else {
            System.out.println(status);
            ctx.put("status", status);
            return ERROR;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
