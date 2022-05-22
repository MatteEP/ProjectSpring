package sk.datalan.datalanproject.data.employee.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.datalan.datalanproject.data.addess.Address;
import sk.datalan.datalanproject.data.employee.Employee;
import sk.datalan.datalanproject.data.utils.Gender;

import java.util.Date;

@Getter
@Setter
public class EmployeeResponse{
    private int id;
    private int age;

    private String name;
    private String surname;

    private Date employeeFrom;
    private Date employeeTo;

    private Gender gender;
    private Address address;

    public EmployeeResponse(Employee employee) {
        this.id = employee.getId();
        this.age = employee.getAge();
        this.name = employee.getName();
        this.surname = employee.getSurname();
        this.employeeFrom = employee.getEmployeeFrom();
        this.employeeTo = employee.getEmployeeTo();
        this.gender = employee.getGender();
        this.address = employee.getAddress();
    }
}
