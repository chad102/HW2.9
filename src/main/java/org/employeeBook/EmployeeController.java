package org.employeeBook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping(path = "/add")
    public Employee add (@RequestParam("firstName")String firstName,
                         @RequestParam("lastName") String lastName,
                         @RequestParam("department") int departmentId,
                         @RequestParam("salary") int salary) {
        return employeeServiceImpl.addNewEmployee(firstName, lastName, departmentId, salary);
    }

    @GetMapping(path = "/remove")
    public Employee remove (@RequestParam("firstName")String firstName, @RequestParam("lastName") String lastName) {
        return employeeServiceImpl.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee find (@RequestParam("firstName")String firstName, @RequestParam("lastName") String lastName) {
        return employeeServiceImpl.findEmployee(firstName, lastName);
    }
    @GetMapping
    public Map<String, Employee> printList() {
        return  employeeServiceImpl.printAllEmployees();
    }

}
