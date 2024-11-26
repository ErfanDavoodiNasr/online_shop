package ir.honeynima.repository.impl;

import ir.honeynima.base.repository.BaseRepositoryImpl;
import ir.honeynima.model.DiscountCode;
import ir.honeynima.repository.DiscountCodeRepository;

import javax.persistence.EntityManager;

import static ir.honeynima.util.EntityManagerProvider.getEntityManager;

public class DiscountCodeRepositoryImpl extends BaseRepositoryImpl<DiscountCode,Integer> implements DiscountCodeRepository {
    @Override
    public Class<DiscountCode> getEntityclass() {
        return DiscountCode.class;
    }

    @Override
    public DiscountCode update(DiscountCode discountCode) {
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            DiscountCode oldDiscountCode = em.find(getEntityclass(), discountCode.getId());
            oldDiscountCode.setDiscountPercent(discountCode.getDiscountPercent());
            oldDiscountCode.setExpiredDate(discountCode.getExpiredDate());
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            return null;
        }finally {
            em.close();
        }
        return discountCode;
    }
}
