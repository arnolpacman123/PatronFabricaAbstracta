package abstractfactory.service;

import abstractfactory.schemas.Product;

import java.util.List;

public interface IProductsService {
    public List<Product> getProducts();
}
