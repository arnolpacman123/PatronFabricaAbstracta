package abstractfactory.rest;

import abstractfactory.schemas.Employee;
import abstractfactory.service.IEmployeeService;

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

public class EmployeeServiceRest implements IEmployeeService {

    @Override
    public List<Employee> getEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        // Consume REST API con el link http://localhost:3000/api/employees
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://localhost:3000/api/employees");
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
}
