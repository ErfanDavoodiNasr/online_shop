package ir.honeynima.service.impl;

import ir.honeynima.base.service.BaseServiceImpl;
import ir.honeynima.model.DiscountCode;
import ir.honeynima.repository.DiscountCodeRepository;
import ir.honeynima.service.DiscountCodeService;
import java.util.function.Predicate;

public class DiscountCodeServiceImpl extends BaseServiceImpl<DiscountCode,Integer, DiscountCodeRepository> implements DiscountCodeService {
    public DiscountCodeServiceImpl(DiscountCodeRepository discountCodeRepository) {
        super(discountCodeRepository);
    }

    @Override
    public Predicate<Integer> getPredicateId() {
        Predicate<Integer> predicate = (s) -> (s > 0);
        return predicate;
    }
}
