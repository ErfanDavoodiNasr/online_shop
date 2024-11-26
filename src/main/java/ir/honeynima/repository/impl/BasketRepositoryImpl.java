package ir.honeynima.repository.impl;

import ir.honeynima.base.repository.BaseRepositoryImpl;
import ir.honeynima.model.Basket;
import ir.honeynima.repository.BasketRepository;

import javax.persistence.EntityManager;

import static ir.honeynima.util.EntityManagerProvider.getEntityManager;

public class BasketRepositoryImpl extends BaseRepositoryImpl<Basket,Integer> implements BasketRepository {
    @Override
    public Class<Basket> getEntityclass() {
        return Basket.class;
    }

    @Override
    public Basket update(Basket basket) {
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            Basket oldBasket = em.find(getEntityclass(), basket.getId());
            oldBasket.setProducts(basket.getProducts());
            oldBasket.setUser(basket.getUser());
            oldBasket.setStatus(basket.getStatus());
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            return null;
        }finally {
            em.close();
        }
        return basket;
    }
}
