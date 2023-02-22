package abstractfactory.ws;

import abstractfactory.schemas.Employee;
import abstractfactory.services.IEmployeesService;

import java.util.ArrayList;
import java.util.List;

public class EmployeesServiceWS implements IEmployeesService {
    static List<Employee> employees;

    public EmployeesServiceWS() {
        if (employees != null) {
            return;
        }

        employees = new ArrayList<>();
        employees.add(new Employee(1, "Juana de Arco"));
        employees.add(new Employee(2, "Pablo Picasso"));
        employees.add(new Employee(3, "Albert Einstein"));
        employees.add(new Employee(4, "Leonardo Da Vinci"));
        employees.add(new Employee(5, "Isaac Newton"));
        employees.add(new Employee(6, "Charles Darwin"));
        employees.add(new Employee(7, "Nikola Tesla"));
        employees.add(new Employee(8, "Thomas Edison"));
        employees.add(new Employee(9, "Marie Curie"));
        employees.add(new Employee(10, "Galileo Galilei"));
        employees.add(new Employee(11, "Benjamin Franklin"));
        employees.add(new Employee(12, "Alexander Graham Bell"));
        employees.add(new Employee(13, "Louis Pasteur"));
        employees.add(new Employee(14, "Albert Schweitzer"));
        employees.add(new Employee(15, "Wolfgang Amadeus Mozart"));
        employees.add(new Employee(16, "Johannes Gutenberg"));
        employees.add(new Employee(17, "Leonardo Fibonacci"));
        employees.add(new Employee(18, "Galileo Galilei"));
        employees.add(new Employee(19, "Benjamin Franklin"));
        employees.add(new Employee(20, "Alexander Graham Bell"));
    }


    @Override
    public List<Employee> getEmployees() {
        ArrayList<Employee> reversedEmployees = new ArrayList<>();
        reversedEmployees(reversedEmployees);
        return reversedEmployees;
    }

    private void reversedEmployees(ArrayList<Employee> reversedEmployees) {
        for (int i = employees.size() - 1; i >= 0; i--) {
            reversedEmployees.add(employees.get(i));
        }
    }

    @Override
    public boolean addEmployee(Employee employee) {
        employee.setId(employees.size() + 1);
        return employees.add(employee);
    }

}
