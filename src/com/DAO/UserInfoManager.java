package com.DAO;

import com.HibernateSessionFactory;
import com.entity.UserinfoEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public class UserInfoManager {

    /**
     * 增加新的用户，即用户注册
     *
     * @param user 用户类
     * @throws HibernateException 抛出异常
     */
    public void addUser(UserinfoEntity user) throws HibernateException {
        Transaction transaction;
        Session session;
        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }

    /**
     * 判定用户名及联系方式是否已经被使用
     *
     * @param username 用户名
     * @param usertel  用户联系方式
     * @return 是否成功及错误信息
     * @throws HibernateException 异常
     */
    public String isExist(String username, String usertel) throws HibernateException {
        Session session;
        UserinfoEntity User;
        String message;
        try {
            session = HibernateSessionFactory.getSession();
            Query query = session.createQuery("from UserinfoEntity User where User.userName= :username")
                    .setString("username", username);
            User = (UserinfoEntity) query.uniqueResult();
            if (User != null) {
                message = "此用户名已经被使用";
                return message;
            }
            User = (UserinfoEntity) session.createQuery("from UserinfoEntity User where User.userTel= :usertel")
                    .setString("usertel", usertel).uniqueResult();
            if (User != null) {
                message = "此联系方式已经注册过了";
                return message;
            }
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return "注册成功";
    }

    /**
     * 根据用户ID返回用户信息
     *
     * @param userID 用户ID
     * @return 用户信息
     * @throws HibernateException 异常
     */
    public UserinfoEntity getUser(int userID) throws HibernateException {
        Session session;
        UserinfoEntity User = new UserinfoEntity();
        try {
            session = HibernateSessionFactory.getSession();
            User = session.get(UserinfoEntity.class, userID);
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return User;
    }

    /**
     * 更新用户信息
     *
     * @param map    具体的更新内容，使用map封装
     * @param userid 用户ID
     */
    public void updateUser(Map<String, String> map, int userid) {
        Session session;
        Transaction transaction;
        UserinfoEntity User = new UserinfoEntity();
        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();
            User = session.get(UserinfoEntity.class, userid);
            Set set = map.keySet();
            for (Object aSet : set) {
                String key = (String) aSet;
                String values = map.get(key);
                switch (key) {
                    case "username":
                        User.setUserName(values);
                        break;
                    case "userpassword":
                        User.setUserPsw(values);
                        break;
                    case "usertel":
                        User.setUserTel(values);
                        break;
                    case "usertype":
                        User.setUserType(Integer.parseInt(values));
                        break;
                    case "userbalance":
                        User.setUserBalance(new BigDecimal(values));
                        break;
                    case "userpoint":
                        User.setUserPoint(Integer.parseInt(values));
                        break;
                    case "userheadpic":
                        User.setUserHeadpic(values);
                        break;
                    case "useraddress":
                        User.setUserDefaultaddr(Integer.parseInt(values));
                        break;
                }
            }
            session.flush();
            transaction.commit();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }


    /**
     * 使用用户名登录
     *
     * @param username 用户名
     * @param password 用户密码
     * @return 存在返回TRUE，否则返回FALSE
     * @throws HibernateException 异常
     */
    public UserinfoEntity getLoginWithname(String username, String password) throws HibernateException {
        Session session;
        UserinfoEntity User = new UserinfoEntity();

        try {
            session = HibernateSessionFactory.getSession();

            String hql = "FROM  UserinfoEntity User WHERE userName = ?1 AND userPsw = ?2";
            Query query = session.createQuery(hql)
                    .setParameter("1", username).setParameter("2", password);
            User = (UserinfoEntity) query.uniqueResult();
        } finally {
            HibernateSessionFactory.closeSession();
        }

        return User;
    }

    /**
     * 根据用户联系方式登录
     *
     * @param usertel  联系方式
     * @param password 用户密码
     * @return 存在返回TRUE，否则返回FALSE
     * @throws HibernateException 异常
     */
    public UserinfoEntity getLoginWithtel(String usertel, String password) throws HibernateException {
        Session session;
        UserinfoEntity User = new UserinfoEntity();

        try {
            session = HibernateSessionFactory.getSession();
            String hql = "FROM  UserinfoEntity User WHERE userTel = ?1 AND userPsw = ?2";
            Query query = session.createQuery(hql)
                    .setParameter("1", usertel).setParameter("2", password);
            User = (UserinfoEntity) query.uniqueResult();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return User;
    }
}
