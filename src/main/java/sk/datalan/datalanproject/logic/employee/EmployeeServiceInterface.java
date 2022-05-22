package sk.datalan.datalanproject.logic.employee;

import sk.datalan.datalanproject.data.employee.Employee;
import sk.datalan.datalanproject.data.employee.bodies.EmployeeRequest;
import sk.datalan.datalanproject.data.utils.Gender;

import java.util.List;

public interface EmployeeServiceInterface {

    Employee addEmployee(EmployeeRequest employeeRequest);

    List<Employee> getAll();

    List<Employee> getEmployeesByGender(Gender gender);

    List<Employee> sortEmployeesByAge();

    List<Employee> getActiveEmployees();

    List<Employee> getEmployeesByCity(String code);

    void printEmployees();

}
