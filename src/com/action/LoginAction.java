package com.action;

import com.DAO.UserInfoManager;
import com.entity.UserinfoEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private String username;
    private String password;

    @Override
    public String execute() {
        ActionContext ctx = ActionContext.getContext();
        UserInfoManager userInfoManager = new UserInfoManager();
        UserinfoEntity user;
        user = userInfoManager.getLoginWithname(username, password);
        if (user == null) {
            System.out.println("非用户名登录 " + username);
            user = userInfoManager.getLoginWithtel(username, password);
            if (user == null) {
                System.out.println("非用户名，用手机号登录失败 " + username + " 密码 " + password);
                ctx.put("status", "用户名或者密码错误");
                return ERROR;
            } else {
                System.out.println("用户 " + user.getUserName() + " 使用手机号 " + username + " 登录");
                ctx.getSession().put("user", user);
                return SUCCESS;
            }
        } else {
            System.out.println("用户 " + user.getUserName() + " 使用用户名登录");
            ctx.getSession().put("user", user);
            return SUCCESS;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
