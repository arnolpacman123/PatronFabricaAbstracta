package abstractfactory.services;

import abstractfactory.schemas.Product;

import java.util.List;

public interface IProductsService {
    public List<Product> getProducts();
    public boolean addProduct(Product product);
}
