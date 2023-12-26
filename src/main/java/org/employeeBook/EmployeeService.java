package org.employeeBook;

import java.util.Map;

public interface EmployeeService {
    Employee addNewEmployee(String firstName, String lastName, int departmentId, int salary);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Map<String, Employee> printAllEmployees();
}