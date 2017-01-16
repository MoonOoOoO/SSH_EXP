package com.action;

import com.DAO.ClothesinfoManager;
import com.entity.ClothesinfoEntity;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.Map;


public class WashClothesAction extends ActionSupport implements Action {
    private String clothesName;
    private int num;

    @Override
    public String execute() throws Exception {
        ActionContext ctx = ActionContext.getContext();
        ClothesinfoManager clothesinfoManager = new ClothesinfoManager();
        List<ClothesinfoEntity> list = clothesinfoManager.getAllClothesinfos();
        ctx.put("clothes", list);
        return SUCCESS;
    }

    public String getClothesName() {
        return clothesName;
    }

    public void setClothesName(String clothesName) {
        this.clothesName = clothesName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
