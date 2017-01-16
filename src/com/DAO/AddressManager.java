package com.DAO;

import com.HibernateSessionFactory;
import com.entity.AddressEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AddressManager {
    /**
     * 添加新的地址
     *
     * @param address 地址信息
     */
    public void addAddress(AddressEntity address) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();
            session.save(address);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
            HibernateSessionFactory.closeSession();
        }
    }

    /**
     * 更新地址信息
     *
     * @param address 更新后的地址信息
     * @throws HibernateException
     */
    public void updateAddress(AddressEntity address) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        AddressEntity addressEntity = new AddressEntity();
        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();

            addressEntity = session.load(AddressEntity.class, address.getAddressId());
            addressEntity = address;
            session.save(addressEntity);
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

    public AddressEntity getAddress(int addressId) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        AddressEntity addressEntity = new AddressEntity();
        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();

            addressEntity = session.get(AddressEntity.class, addressId);
            transaction.commit();
        } finally {
            HibernateSessionFactory.closeSession();
        }

        return addressEntity;
    }

    /**
     * 根据用户ID返回其所有的地址
     *
     * @param userId 用户ID
     * @return 地址集合
     * @throws HibernateException
     */
    public List<AddressEntity> getAddressThroughUser(int userId) throws HibernateException {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();

            List list = session.createQuery("from AddressEntity a where a.userId = :userid")
                    .setInteger("userid", userId).list();
            transaction.commit();
            return list;
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }

    /**
     * 删除当前地址
     *
     * @param addressId 即将删除的地址ID
     * @throws HibernateException 异常
     */
    public void deleteAddress(int addressId) throws HibernateException {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();

            AddressEntity address = session.get(AddressEntity.class, addressId);
            if (address != null)
                session.delete(address);

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
}
