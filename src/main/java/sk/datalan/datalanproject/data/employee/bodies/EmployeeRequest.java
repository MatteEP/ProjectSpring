package sk.datalan.datalanproject.data.employee.bodies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.datalan.datalanproject.data.addess.Address;
import sk.datalan.datalanproject.data.utils.Gender;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeRequest {
    private int id;
    private int age;

    private String name;
    private String surname;

    private Date employeeFrom;
    private Date employeeTo;

    private Gender gender;
    private Address address;
}
