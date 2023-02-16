package abstractfactory.service;

import abstractfactory.schemas.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> getEmployees();
}