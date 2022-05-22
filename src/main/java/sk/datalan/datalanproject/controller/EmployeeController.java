package sk.datalan.datalanproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.datalan.datalanproject.data.employee.bodies.EmployeeRequest;
import sk.datalan.datalanproject.data.employee.bodies.EmployeeResponse;
import sk.datalan.datalanproject.data.utils.Gender;
import sk.datalan.datalanproject.logic.employee.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     *
     * @param employeeRequest tu by mohla padnut exception keby dostal nespravne telo requestu BAD REQUEST 400
     * @return
     */
    @PostMapping
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return new ResponseEntity<>(new EmployeeResponse(employeeService.addEmployee(employeeRequest)), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService.getAll().stream().map(EmployeeResponse::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/sort/age")
    public List sortedByAge() {
        return employeeService.sortEmployeesByAge().stream().map(EmployeeResponse::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/gender/{gender}")
    public List getByGender(@PathVariable Gender gender) {
        return employeeService.getEmployeesByGender(gender).stream().map(EmployeeResponse::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/active")
    public List getByGender() {
        return employeeService.getActiveEmployees().stream().map(EmployeeResponse::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/city/{code}")
    public List getEmpByCity(@PathVariable String code) {
        return employeeService.getEmployeesByCity(code).stream().map(EmployeeResponse::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/print")
    public String printEmployees() {
        return employeeService.printEmployees();
    }

}
