package com.DAO;

import com.HibernateSessionFactory;
import com.entity.OrderitemEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderitemManager {
    /**
     * 添加一个订单项
     *
     * @param orderitem 订单物品信息
     * @throws HibernateException 异常
     */
    public void addOrderitem(OrderitemEntity orderitem) throws HibernateException {
        Transaction transaction;
        Session session;
        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();
            session.save(orderitem);
            transaction.commit();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }

    /**
     * 更新订单项
     *
     * @param orderitem 待更新的订单项信息
     * @throws HibernateException 异常
     */
    public void updateOrderitem(OrderitemEntity orderitem) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        OrderitemEntity orderitemEntity = new OrderitemEntity();
        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();

            orderitemEntity = session.load(OrderitemEntity.class, orderitem.getOrderId());
            orderitemEntity = orderitem;
            session.update(orderitemEntity);
            transaction.commit();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }

    /**
     * 根据商品项ID获取商品信息
     *
     * @param orderitemId 商品项ID
     * @return 商品信息
     * @throws HibernateException 异常
     */
    public OrderitemEntity getOrderitem(int orderitemId) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        OrderitemEntity orderitem = new OrderitemEntity();
        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();

            orderitem = session.get(OrderitemEntity.class, orderitemId);
            transaction.commit();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
            HibernateSessionFactory.closeSession();
        }

        return orderitem;
    }

    /**
     * 根据订单ID获取此订单的所有商品信息
     *
     * @param orderId 订单ID
     * @return 此订单的所有的商品信息
     * @throws HibernateException 异常
     */
    public List<OrderitemEntity> getOrderitems(int orderId) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        OrderitemEntity orderitem = new OrderitemEntity();
        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();

            List list = session.createQuery("from OrderitemEntity Order where Order.orderId = :orderid")
                    .setInteger("orderid", orderId).list();
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
     * 根据用户ID和订单ID查找订单项，这里是查找某一用户洗衣篮里的所有商品，所以订单ID固定为0（洗衣篮里的商品订单号均为0，以用户ID区分）
     *
     * @param userId  用户ID
     * @param orderId 订单ID=0
     * @return 该用户洗衣篮里的订单项
     * @throws HibernateException 异常
     */
    public List<OrderitemEntity> getOrderitems(int userId, int orderId) throws HibernateException {
        Session session = null;
        OrderitemEntity orderitem = new OrderitemEntity();
        session = HibernateSessionFactory.getSession();
        List list = session.createQuery("from OrderitemEntity Order where Order.userId = :userid and Order.orderId = :orderid")
                .setInteger("userid", userId).setInteger("orderid", orderId).list();

        HibernateSessionFactory.closeSession();
        return list;
    }

    /**
     * 删除指定商品项
     *
     * @param orderitemId 待删除商品项ID
     * @throws HibernateException 异常
     */
    public void deleteOrderitem(int orderitemId) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();

            OrderitemEntity orderitem = session.get(OrderitemEntity.class, orderitemId);
            if (orderitem != null)
                session.delete(orderitem);
            transaction.commit();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }
}
