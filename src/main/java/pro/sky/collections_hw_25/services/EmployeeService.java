package pro.sky.collections_hw_25.services;

import pro.sky.collections_hw_25.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee (String firstName, String lastName);
    Employee deleteEmployee (String firstName, String lastName);
    Employee findEmployee (String firstName, String lastName);
    List<Employee> getAll();
}
