package org.employeeBook.Second;

import org.employeeBook.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiceImpl departmentServiceImpl;
    public DepartmentController(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }
@GetMapping(path = "/max-salary")
    public Optional<Employee> getMaxSalaryInDep(@RequestParam("departmentId") int departmentId) {
        return departmentServiceImpl.getMaxSalaryInDep(departmentId);
    }
@GetMapping(path = "/min-salary")
    public Optional<Employee> getMinSalaryInDep(@RequestParam("departmentId") int departmentId) {
        return departmentServiceImpl.getMinSalaryInDep(departmentId);
    }
@GetMapping(path = "/all")
    public List<Employee> printAllEmployeesInDep(@RequestParam("departmentId") int departmentId) {
        return departmentServiceImpl.printEmployeesInDep(departmentId);
    }

@GetMapping(path = "/all1")
    public List<Employee> printAllDeps() {
        return departmentServiceImpl.printEmployeesAllDep();
    }
}
