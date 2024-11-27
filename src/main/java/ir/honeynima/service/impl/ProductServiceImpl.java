package ir.honeynima.service.impl;

import ir.honeynima.base.service.BaseServiceImpl;
import ir.honeynima.model.Product;
import ir.honeynima.repository.ProductRepository;
import ir.honeynima.service.ProductService;
import java.util.function.Predicate;

public class ProductServiceImpl extends BaseServiceImpl<Product,Integer, ProductRepository> implements ProductService {
    public ProductServiceImpl(ProductRepository productRepository) {
        super(productRepository);
    }

    @Override
    public Predicate<Integer> getPredicateId() {
        Predicate<Integer> predicate = (s) -> (s > 0);
        return predicate;
    }
}
