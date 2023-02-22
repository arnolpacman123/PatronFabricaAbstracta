package abstractfactory.db;

import abstractfactory.schemas.Product;
import abstractfactory.services.IProductsService;
import connection.ConnectionDB;

import java.util.List;

public class ProductServiceDB implements IProductsService {
    ConnectionDB connectionDB = new ConnectionDB();
    @Override
    public List<Product> getProducts() {
        // Listar los registros de la tabla products de la base de datos
        return connectionDB.getProducts();
    }

    @Override
    public boolean addProduct(Product product) {
        // Agregar un registro a la tabla products de la base de datos
        return connectionDB.addProduct(product);
    }
}
