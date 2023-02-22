package abstractfactory.rest;

import abstractfactory.schemas.Employee;
import abstractfactory.services.IEmployeesService;

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

public class EmployeesServiceRest implements IEmployeesService {

    @Override
    public List<Employee> getEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        // Consume REST API con el link https://api-patron-fabrica-abstracta.herokuapp.com/api/employees
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("https://api-patron-fabrica-abstracta.herokuapp.com/api/employees");
            CloseableHttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream inputStream = entity.getContent();
                String result = new String(inputStream.readAllBytes());
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Type listType = new TypeToken<List<Employee>>() {
                }.getType();
                employees = gson.fromJson(result, listType);
                return employees;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        boolean result = false;
        // Consume REST API con el link https://api-patron-fabrica-abstracta.herokuapp.com/api/employees enviar el empleado en formato JSON por el método POST
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("https://api-patron-fabrica-abstracta.herokuapp.com/api/employees");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(employee);
            httpPost.setEntity(new StringEntity(json));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            CloseableHttpResponse response = httpclient.execute(httpPost);
            // Obtener el código de respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200 || statusCode == 201) {
                result = true;
            }
            // HttpEntity entity = response.getEntity();
            // if (entity != null) {
            //     InputStream inputStream = entity.getContent();
            //     String responseString = new String(inputStream.readAllBytes());
            //     System.out.println(responseString);
            //     result = Boolean.parseBoolean(responseString);
            // }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
