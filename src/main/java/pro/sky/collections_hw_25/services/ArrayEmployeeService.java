package pro.sky.collections_hw_25.services;

import org.springframework.stereotype.Service;
import pro.sky.collections_hw_25.model.Employee;
import pro.sky.collections_hw_25.exceptions.EmployeeAlreadyAddedException;
import pro.sky.collections_hw_25.exceptions.EmployeeNotFoundException;
import pro.sky.collections_hw_25.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArrayEmployeeService implements EmployeeService {

    private static final int amount = 10;
    //private Employee[] stuff = new Employee[amount];
   // private int currentIndex = 0;
    List<Employee> stuff = new ArrayList<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
       if(stuff.size()>=amount){
           throw new EmployeeStorageIsFullException();
       }
        Employee temporary = new Employee(firstName, lastName);
        if (stuff.contains(temporary)) {
            throw new EmployeeAlreadyAddedException();
        }

        stuff.add(temporary);
        return temporary;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee temporary = new Employee(firstName, lastName);
       int n = stuff.indexOf(temporary);

        if(n == -1){
            throw new EmployeeNotFoundException();
        }
        stuff.remove(n);
        return temporary;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee temporary = new Employee(firstName, lastName);
        int n = stuff.indexOf(temporary);

        if(n == -1) {
            throw new EmployeeNotFoundException();
        }

        return stuff.get(n);
    }

    @Override
    public List<Employee> getAll() {
        return stuff;
    }
}
