package abstractfactory.db;

import abstractfactory.schemas.Employee;
import abstractfactory.services.IEmployeesService;
import connection.ConnectionDB;

import java.util.List;

public class EmployeesServiceDB implements IEmployeesService {
    ConnectionDB connectionDB = new ConnectionDB();
    @Override
    public List<Employee> getEmployees() {
        // Listar los registros de la tabla employees de la base de datos
        return connectionDB.getEmployees();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        // Agregar un registro a la tabla employees de la base de datos
        return connectionDB.addEmployee(employee);
    }
}
