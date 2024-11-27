package ir.honeynima.service.impl;

import ir.honeynima.base.service.BaseServiceImpl;
import ir.honeynima.model.Basket;
import ir.honeynima.repository.BasketRepository;
import ir.honeynima.service.BasketService;
import java.util.function.Predicate;

public class BasketServiceImpl extends BaseServiceImpl<Basket,Integer, BasketRepository> implements BasketService {
    public BasketServiceImpl(BasketRepository basketRepository) {
        super(basketRepository);
    }

    @Override
    public Predicate<Integer> getPredicateId() {
        Predicate<Integer> predicate = (s) -> (s > 0);
        return predicate;
    }
}
