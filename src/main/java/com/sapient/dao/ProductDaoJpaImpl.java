package com.sapient.dao;

import com.sapient.dao.DaoException;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.sapient.entity.Product;

public class ProductDaoJpaImpl implements ProductDao {

    private EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRAINING");
        return emf.createEntityManager();

    }

    @Override
    public void addProduct(Product product) throws DaoException {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            em.persist(product);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new DaoException(e);
        } finally {
            em.close();
        }

    }

    @Override
    public Product getProduct(Integer id) throws DaoException {
        EntityManager em = getEntityManager();
        Product product = em.find(Product.class, id);
        em.close();
        return product;

    }

    @Override
    public void updateProduct(Product product) throws DaoException {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            em.merge(product);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new DaoException(e);
        } finally {
            em.close();
        }

    }

    @Override
    public void deleteProduct(Integer id) throws DaoException {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Product product = this.getProduct(id);
            if (product == null) {
                throw new DaoException("no data found for id: " + id);
            }
            em.remove(product);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new DaoException(e);
        } finally {
            em.close();
        }

    }

    @Override
    public List<Product> getAll() throws DaoException {

        return null;
    }

    @Override
    public List<Product> getProductsByBrand(String brand) throws DaoException {

        return null;
    }

    @Override
    public List<Product> getProductsWithDiscount() throws DaoException {

        return null;
    }

    @Override
    public List<Product> getProductsByCategory(String Category) throws DaoException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> getProductsByPriceRange(Double min, Double max) throws DaoException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> getProductsWithoutDiscount() throws DaoException {
        // TODO Auto-generated method stub
        return null;
    }

}
