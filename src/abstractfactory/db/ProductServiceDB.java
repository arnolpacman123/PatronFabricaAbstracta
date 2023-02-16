package abstractfactory.db;

import abstractfactory.schemas.Product;
import abstractfactory.service.IProductsService;
import connection.ConnectionDB;

import java.util.List;

public class ProductServiceDB implements IProductsService {
    ConnectionDB connectionDB = new ConnectionDB();
    @Override
    public List<Product> getProducts() {
        return connectionDB.getProducts();
    }
}
