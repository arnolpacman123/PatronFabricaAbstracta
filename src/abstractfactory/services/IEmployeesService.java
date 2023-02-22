package abstractfactory.services;

import abstractfactory.schemas.Employee;

import java.util.List;

public interface IEmployeesService {
    public List<Employee> getEmployees();
    public boolean addEmployee(Employee employee);
}