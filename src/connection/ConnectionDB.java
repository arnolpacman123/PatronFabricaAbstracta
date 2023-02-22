package connection;

import abstractfactory.schemas.Employee;
import abstractfactory.schemas.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDB {
    static Connection connection;

    public ConnectionDB() {
        instanciarConnection();
    }

    private static void instanciarConnection() {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://postgresql-arnolpacman123.alwaysdata.net:5432/arnolpacman123_patron_fabrica_abstracta",
                        "arnolpacman123",
                        "Aspirine217021220"
                );
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public List<Employee> getEmployees() {
        // Listar los registros de la tabla employees de la base de datos
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM employees ORDER BY id DESC";
            var result = statement.executeQuery(query);
            while (result.next()) {
                Employee employee = new Employee(
                        result.getInt("id"),
                        result.getString("name")
                );
                employees.add(employee);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return employees;
    }

    public List<Product> getProducts() {
        // Listar los registros de la tabla products de la base de datos
        ArrayList<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM products ORDER BY id DESC";
            var result = statement.executeQuery(query);
            while (result.next()) {
                Product product = new Product(
                        result.getInt("id"),
                        result.getString("name")
                );
                products.add(product);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return products;
    }

    public boolean addEmployee(Employee employee) {
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO employees (name) VALUES ('" + employee.getName() + "')";
            return statement.executeUpdate(query) > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public boolean addProduct(Product product) {
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO products (name) VALUES ('" + product.getName() + "')";
            return statement.executeUpdate(query) > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}
