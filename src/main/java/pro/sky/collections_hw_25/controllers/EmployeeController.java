package pro.sky.collections_hw_25.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collections_hw_25.model.Employee;
import pro.sky.collections_hw_25.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping ("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName){
        return service.addEmployee(firstName,lastName);
    }
    @GetMapping("/remove")
    public Employee deleteEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName){
        return service.deleteEmployee(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName){
        return service.findEmployee(firstName, lastName);
    }
    @GetMapping
    public List<Employee> showAll(){
        return service.getAll();
    }

}
