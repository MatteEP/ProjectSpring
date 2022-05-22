package sk.datalan.datalanproject.data.employee;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.datalan.datalanproject.data.addess.Address;
import sk.datalan.datalanproject.data.employee.bodies.EmployeeRequest;
import sk.datalan.datalanproject.data.utils.Gender;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;

    private int age;

    private Date employeeFrom;
    private Date employeeTo;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @OneToOne(cascade=CascadeType.MERGE)
    private Address address;

    public Employee(EmployeeRequest employeeRequest) {
        this.id = employeeRequest.getId();
        this.name = employeeRequest.getName();
        this.surname = employeeRequest.getSurname();
        this.age = employeeRequest.getAge();
        this.employeeFrom = employeeRequest.getEmployeeFrom();
        this.employeeTo = employeeRequest.getEmployeeTo();
        this.gender = employeeRequest.getGender();
        this.address = employeeRequest.getAddress();
    }

}
