package org.employeeBook;

import org.apache.commons.lang3.StringUtils;
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
        if (!firstName.isEmpty() &&
            firstName != null &&
            StringUtils.isAlpha(firstName) &&

            !lastName.isEmpty() &&
            lastName != null &&
            StringUtils.isAlpha(lastName)) {

                StringUtils.capitalize(firstName);
                StringUtils.capitalize(lastName);
            return employeeServiceImpl.addNewEmployee(firstName, lastName, departmentId, salary);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/remove")
    public Employee remove (@RequestParam("firstName")String firstName, @RequestParam("lastName") String lastName) {
        if (!firstName.isEmpty() &&
            firstName != null &&
            StringUtils.isAlpha(firstName) &&

            !lastName.isEmpty() &&
            lastName != null &&
            StringUtils.isAlpha(lastName)) {

            StringUtils.capitalize(firstName);
            StringUtils.capitalize(lastName);
            return employeeServiceImpl.removeEmployee(firstName, lastName);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/find")
    public Employee find (@RequestParam("firstName")String firstName, @RequestParam("lastName") String lastName) {
        if (!firstName.isEmpty() &&
            firstName != null &&
            StringUtils.isAlpha(firstName) &&

            !lastName.isEmpty() &&
            lastName != null &&
            StringUtils.isAlpha(lastName)) {

            StringUtils.capitalize(firstName);
            StringUtils.capitalize(lastName);
            return employeeServiceImpl.findEmployee(firstName, lastName);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public Map<String, Employee> printList() {
        return  employeeServiceImpl.printAllEmployees();
    }

}
