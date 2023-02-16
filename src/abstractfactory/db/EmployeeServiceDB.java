package abstractfactory.db;

import abstractfactory.schemas.Employee;
import abstractfactory.service.IEmployeeService;
import connection.ConnectionDB;

import java.util.List;

public class EmployeeServiceDB implements IEmployeeService {
    ConnectionDB connectionDB = new ConnectionDB();
    @Override
    public List<Employee> getEmployees() {
        // Listar los registros de la tabla employees de la base de datos
        return connectionDB.getEmployees();
    }
}
