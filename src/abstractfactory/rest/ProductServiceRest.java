package abstractfactory.rest;

import abstractfactory.schemas.Product;
import abstractfactory.services.IProductsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
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
        // Consume REST API con el link https://api-patron-fabrica-abstracta.herokuapp.com/api/products
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("https://api-patron-fabrica-abstracta.herokuapp.com/api/products");
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

    @Override
    public boolean addProduct(Product product) {
        boolean result = false;
        // Consume REST API con el link https://api-patron-fabrica-abstracta.herokuapp.com/api/products enviar el producto en formato JSON por el m??todo POST
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("https://api-patron-fabrica-abstracta.herokuapp.com/api/products");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(product);
            httpPost.setEntity(new StringEntity(json));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            CloseableHttpResponse response = httpclient.execute(httpPost);
            // Obtener el c??digo de respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                result = true;
            }
            // HttpEntity entity = response.getEntity();
            // if (entity != null) {
            //     InputStream inputStream = entity.getContent();
            //     String responseString = new String(inputStream.readAllBytes());
            //     result = Boolean.parseBoolean(responseString);
            // }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}