package abstractfactory.ws;

import abstractfactory.schemas.Product;
import abstractfactory.services.IProductsService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceWS implements IProductsService {
    static ArrayList<Product> products;

    public ProductServiceWS() {
        if (products != null) {
            return;
        }

        products = new ArrayList<>();

        products.add(new Product(1, "Coca Cola"));
        products.add(new Product(2, "Pepsi"));
        products.add(new Product(3, "Fanta"));
        products.add(new Product(4, "Sprite"));
        products.add(new Product(5, "7up"));
        products.add(new Product(6, "Pepsi"));
        products.add(new Product(7, "Fanta"));
        products.add(new Product(8, "Laptop"));
        products.add(new Product(9, "Mouse"));
        products.add(new Product(10, "Teclado"));
        products.add(new Product(11, "Monitor"));
        products.add(new Product(12, "Impresora"));
        products.add(new Product(13, "Televisor"));
        products.add(new Product(14, "Celular"));
        products.add(new Product(15, "Tablet"));
        products.add(new Product(16, "Guitarra"));
        products.add(new Product(17, "Bateria"));
        products.add(new Product(18, "Piano"));
        products.add(new Product(19, "Saxofon"));
        products.add(new Product(20, "Violin"));
    }

    @Override
    public List<Product> getProducts() {
        // Reverse the list
        ArrayList<Product> reversedProducts = new ArrayList<>();
        reversedProducts(reversedProducts);
        return reversedProducts;
    }

    private void reversedProducts(ArrayList<Product> reversedProducts) {
        for (int i = products.size() - 1; i >= 0; i--) {
            reversedProducts.add(products.get(i));
        }
    }

    @Override
    public boolean addProduct(Product product) {
        product.setId(products.size() + 1);
        return products.add(product);
    }
}
