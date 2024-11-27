package ir.honeynima.service.impl;

import ir.honeynima.base.service.BaseServiceImpl;
import ir.honeynima.model.User;
import ir.honeynima.repository.UserRepository;
import ir.honeynima.service.UserService;
import java.util.function.Predicate;

public class UserServiceImpl extends BaseServiceImpl<User,Integer, UserRepository> implements UserService {
    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public Predicate<Integer> getPredicateId() {
        Predicate<Integer> predicate = (s) -> (s > 0);
        return predicate;
    }
}
