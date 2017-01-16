package com.action;


import com.DAO.UserInfoManager;
import com.entity.OrderinfoEntity;
import com.entity.UserinfoEntity;

import java.util.List;
import java.util.Scanner;

public class SellerTest {

    public static void main(String[] args) {
        Seller seller = new Seller();
        List<OrderinfoEntity> orderlist;
        UserInfoManager userManager = new UserInfoManager();
        UserinfoEntity user = new UserinfoEntity();
        Scanner scanner = new Scanner(System.in);
        int choose=1000;

        while(choose!=0){
            System.out.println("1.查看未接订单");
            System.out.println("2.查看未清洗订单");
            System.out.println("3.查看未发货订单");
            System.out.println("0.退出");

            choose = scanner.nextInt();

            orderlist = seller.getAllOrders(choose);
            for (OrderinfoEntity o:orderlist) {
                user = userManager.getUser(o.getUserId());
                System.out.println(o.getOrderId()+"\t"+user.getUserName()+"\t"+o.getAddress()+"\t"+o.getOrderDate()+"\t"+o.getOrderPrice());
            }
            seller.setOrders(orderlist,choose);
            System.out.println("已全部接单。");
        }


    }
}
