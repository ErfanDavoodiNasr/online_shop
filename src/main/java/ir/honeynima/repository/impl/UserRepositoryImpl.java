package ir.honeynima.repository.impl;

import ir.honeynima.base.repository.BaseRepositoryImpl;
import ir.honeynima.model.User;
import ir.honeynima.repository.UserRepository;

import javax.persistence.EntityManager;

import static ir.honeynima.util.EntityManagerProvider.getEntityManager;

public class UserRepositoryImpl extends BaseRepositoryImpl<User,Integer> implements UserRepository {
    @Override
    public Class<User> getEntityclass() {
        return User.class;
    }

    @Override
    public User update(User user) {
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            User oldUser = em.find(getEntityclass(), user.getId());
            oldUser.setAddress(user.getAddress());
            oldUser.setEmail(user.getEmail());
            oldUser.setRole(user.getRole());
            oldUser.setLastName(user.getLastName());
            oldUser.setFirstName(user.getFirstName());
            oldUser.setBirthDate(user.getBirthDate());
            oldUser.setPhoneNumber(user.getPhoneNumber());
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            return null;
        }finally {
            em.close();
        }
        return user;
    }
}
