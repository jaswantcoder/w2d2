package com.sapient.programs;

import com.sapient.dao.ProductDao;
import com.sapient.dao.ProductDaoJpaImpl;
import com.sapient.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetOneProduct {

    public static void main(String[] args) {
        ProductDao dao = new ProductDaoJpaImpl();
        try {
            Product p = dao.getProduct(1);
            log.debug("p={}",p);
            p.setUnitPrice(p.getUnitPrice()+1);
            dao.updateProduct(p);
            p=dao.getProduct(1);
            log.debug("update product ={}",p);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
