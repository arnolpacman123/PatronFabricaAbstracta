package abstractfactory.rest;

import abstractfactory.schemas.Product;
import abstractfactory.service.IProductsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceRest implements IProductsService {

    @Override
    public List<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        // Consume REST API con el link http://localhost:3000/api/products
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://localhost:3000/api/products");
            CloseableHttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream inputStream = entity.getContent();
                String result = new String(inputStream.readAllBytes());
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Type listType = new TypeToken<List<Product>>() {
                }.getType();
                products = gson.fromJson(result, listType);
                return products;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}