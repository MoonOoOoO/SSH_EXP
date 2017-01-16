package com.DAO;

import com.HibernateSessionFactory;
import com.entity.OrderinfoEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.List;

public class OrderinfoManager {

    /**
     * 增加订单
     *
     * @param order 新增订单
     * @throws HibernateException
     */
    public void addOrder(OrderinfoEntity order) throws HibernateException {
        Session session;
        Transaction transaction;
        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }

    /**
     * 更新订单内容
     *
     * @param order 待更新的订单
     * @throws HibernateException
     */
    public void updateOrder(OrderinfoEntity order) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        OrderinfoEntity orderinfoEntity = new OrderinfoEntity();
        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();

            orderinfoEntity = session.load(OrderinfoEntity.class, order.getOrderId());
            orderinfoEntity = order;
            session.flush();
            transaction.commit();
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
            HibernateSessionFactory.closeSession();
        }
    }

    /**
     * 根据订单ID获得订单信息
     *
     * @param orderId 订单ID
     * @return 订单信息
     * @throws HibernateException
     */
    public OrderinfoEntity getOrder(int orderId) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        OrderinfoEntity orderinfoEntity = new OrderinfoEntity();
        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();

            orderinfoEntity = session.get(OrderinfoEntity.class, orderId);
            transaction.commit();
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
            HibernateSessionFactory.closeSession();
        }
        return orderinfoEntity;
    }

    /**
     * 获得某用户某状态下的全部订单
     *
     * @param userId      用户ID
     * @param orderstatus 订单状态
     * @return 订单列表
     * @throws HibernateException 异常
     */
    public List<OrderinfoEntity> getOrders_user(int userId, int orderstatus) throws HibernateException {
        Session session;

        try {
            session = HibernateSessionFactory.getSession();

            return session.createQuery("from OrderinfoEntity o where o.userId = :userid and o.orderStatus = :orderstatus")
                    .setInteger("userid", userId).setInteger("orderstatus", orderstatus).list();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }

    /**
     * 获取某用户所有订单
     *
     * @param userId 用户ID
     * @return 订单列表
     * @throws HibernateException Hibernate异常
     */
    public List<OrderinfoEntity> getOrders(int userId) throws HibernateException {
        Session session;
        try {
            session = HibernateSessionFactory.getSession();
            List<OrderinfoEntity> list = session.createQuery("from OrderinfoEntity o where o.userId = :userid")
                    .setInteger("userid", userId).list();
            return list;
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }

    /**
     * 根据用户ID和订单时间来返回订单ID
     *
     * @param userId 用户ID
     * @param date   订单时间
     * @return 订单ID
     * @throws HibernateException 异常
     */
    public int getOrderId(int userId, Date date) throws HibernateException {
        int orderID;
        try {
            Session session = HibernateSessionFactory.getSession();
            orderID = (int) session.createQuery("select o.orderId from OrderinfoEntity o where o.userId = :userid and o.orderDate = :date")
                    .setInteger("userid", userId).setDate("date", date).uniqueResult();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return orderID;
    }


    /**
     * 商家获得某状态的全部用户的全部订单
     *
     * @param orderstatus 订单状态
     * @return 订单列表
     * @throws HibernateException 异常
     */
    public List<OrderinfoEntity> getOrders_seller(int orderstatus) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();

            List list = session.createQuery("from OrderinfoEntity o where o.orderStatus = :orderstatus")
                    .setInteger("orderstatus", orderstatus).list();
            transaction.commit();
            return list;
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
            HibernateSessionFactory.closeSession();
        }
    }

    /**
     * 商家根据地址获取某范围内的全部订单
     *
     * @param address 订单地址
     * @return 订单列表
     * @throws HibernateException
     */
    public List<OrderinfoEntity> getOrders_addr(String address) throws HibernateException {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();

            List list = session.createQuery("from OrderinfoEntity o where o.address like :orderaddress")
                    .setString("orderaddress", address + "%").list();
            transaction.commit();
            return list;
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
            HibernateSessionFactory.closeSession();
        }
    }

    /**
     * 取消订单，其中当订单已经处于待收货阶段之后，即衣物清洗完毕后，则不能取消订单
     *
     * @param orderId 订单ID
     * @throws HibernateException
     */
    public String deleteOrder(int orderId) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        String message = "";
        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();

            OrderinfoEntity order = session.get(OrderinfoEntity.class, orderId);
            if (order != null || order.getOrderStatus() < 3) {
                session.delete(order);
                message = "取消订单成功";
            } else if (order != null || order.getOrderStatus() > 2) {
                message = "衣物已经处理，订单已无法取消";
            } else if (order == null)
                message = "没有此订单消息";
            transaction.commit();
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
            HibernateSessionFactory.closeSession();
        }
        return message;
    }
}
