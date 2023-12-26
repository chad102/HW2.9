package org.employeeBook.Second;

import org.employeeBook.Employee;
import org.employeeBook.EmployeeServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl extends EmployeeServiceImpl {
    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    public Optional<Employee> getMaxSalaryInDep (int departmentId) {
        return employeeServiceImpl.employees.values().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary));
    }

    public Optional<Employee> getMinSalaryInDep (int departmentId) {
        return employeeServiceImpl.employees.values().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary));
    }

    public List<Employee> printEmployeesInDep (int departmentId) {
        return employeeServiceImpl.employees.values().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    List<Employee> printEmployeesAllDep() {
        return employeeServiceImpl.employees.values().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartmentId))
                .collect(Collectors.toList());
    }

}
