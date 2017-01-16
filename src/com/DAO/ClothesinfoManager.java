package com.DAO;

import com.HibernateSessionFactory;
import com.entity.ClothesinfoEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by WZS on 2017/1/4.
 */
public class ClothesinfoManager {
    /**
     * 增加衣物种类
     *
     * @param clothes 新增加的衣物信息
     * @throws HibernateException
     */
    public void addClothesinfo(ClothesinfoEntity clothes) throws HibernateException {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();
            session.save(clothes);
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
     * 根据衣物ID返回衣物信息
     *
     * @param clothesId 衣物ID
     * @return 衣物信息
     * @throws HibernateException
     */
    public ClothesinfoEntity getClothesinfo(int clothesId) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        ClothesinfoEntity clothes = new ClothesinfoEntity();
        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();

            clothes = session.get(ClothesinfoEntity.class, clothesId);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return clothes;
    }

    /**
     * 更新衣物信息
     *
     * @param clothes 即将更新的衣物信息
     * @throws HibernateException
     */
    public void updateClothes(ClothesinfoEntity clothes) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        ClothesinfoEntity clothesinfoEntity = new ClothesinfoEntity();
        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();

            clothesinfoEntity = session.load(ClothesinfoEntity.class, clothesinfoEntity.getClothesId());
            clothesinfoEntity = clothes;
            session.save(clothesinfoEntity);
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
     * 获取所有衣物信息，在加载商品界面时使用
     *
     * @return 所有的衣物信息
     * @throws HibernateException
     */
    public List<ClothesinfoEntity> getAllClothesinfos() throws HibernateException {
        Session session = null;

        session = HibernateSessionFactory.getSession();
        List list = session.createQuery("from ClothesinfoEntity Clothes").list();

        HibernateSessionFactory.closeSession();
        return list;
    }

    /**
     * 删除衣物信息
     *
     * @param clothesId 待删除的衣物ID
     * @throws HibernateException
     */
    public void deleteClothesinfo(int clothesId) throws HibernateException {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();

            ClothesinfoEntity clothesinfoEntity = session.get(ClothesinfoEntity.class, clothesId);
            if (clothesinfoEntity != null)
                session.delete(clothesinfoEntity);
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
}
