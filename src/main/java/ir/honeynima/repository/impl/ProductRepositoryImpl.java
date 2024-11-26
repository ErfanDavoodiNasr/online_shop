package ir.honeynima.repository.impl;

import ir.honeynima.base.repository.BaseRepositoryImpl;
import ir.honeynima.model.Product;
import ir.honeynima.repository.ProductRepository;

import javax.persistence.EntityManager;

import static ir.honeynima.util.EntityManagerProvider.getEntityManager;

public class ProductRepositoryImpl extends BaseRepositoryImpl<Product,Integer> implements ProductRepository {
    @Override
    public Class<Product> getEntityclass() {
        return Product.class;
    }

    @Override
    public Product update(Product product) {
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            Product oldProduct = em.find(getEntityclass(), product.getId());
            oldProduct.setCount(product.getCount());
            oldProduct.setName(product.getName());
            oldProduct.setWeight(product.getWeight());
            oldProduct.setDescription(product.getDescription());
            oldProduct.setPrice(product.getPrice());
            oldProduct.setCreateTime(product.getCreateTime());
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            return null;
        }finally {
            em.close();
        }
        return product;
    }
}
