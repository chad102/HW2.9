package org.employeeBook;

import org.employeeBook.exceptions.EmployeeAlreadyAddedException;
import org.employeeBook.exceptions.EmployeeNotFoundException;
import org.employeeBook.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public final Map<String, Employee> employees = new HashMap<>();
    private static final int MAX_SIZE = 100;

    public Employee addNewEmployee(String firstName, String lastName, int departmentId, int salary) {
        Employee e = new Employee(firstName, lastName, departmentId, salary);
        if (employees.containsKey(firstName+lastName)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен в список");
        }
        if (employees.size() <= MAX_SIZE) {
            employees.put(firstName+lastName, e);
            return e;
        } else {
            throw new EmployeeStorageIsFullException("Превышено максимальное количество сотрудников");
        }
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        if (employees.containsKey(firstName+lastName)) {
            employees.remove(firstName+lastName);
            return e;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        if (employees.containsKey(firstName+lastName)){
            return e;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    public Map<String, Employee> printAllEmployees() {
            return employees;
    }
}
