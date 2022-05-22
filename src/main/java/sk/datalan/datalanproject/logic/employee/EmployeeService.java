package sk.datalan.datalanproject.logic.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.datalan.datalanproject.data.addess.Address;
import sk.datalan.datalanproject.data.city.City;
import sk.datalan.datalanproject.data.employee.Employee;
import sk.datalan.datalanproject.data.employee.EmployeeRepository;
import sk.datalan.datalanproject.data.employee.bodies.EmployeeRequest;
import sk.datalan.datalanproject.data.state.State;
import sk.datalan.datalanproject.data.utils.Gender;
import sk.datalan.datalanproject.logic.address.AddressService;
import sk.datalan.datalanproject.logic.city.CityService;
import sk.datalan.datalanproject.logic.state.StateService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private CityService cityService;
    @Autowired
    private StateService stateService;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AddressService addressService;

    @Override
    public Employee addEmployee(EmployeeRequest employeeRequest) {
        return employeeRepository.saveAndFlush(new Employee(employeeRequest));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmployeesByGender(Gender gender) {
        return employeeRepository.findByGender(gender);
    }

    @Override
    public List<Employee> sortEmployeesByAge() {
        return employeeRepository.findByOrderByAge();
    }

    @Override
    public List<Employee> getActiveEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<Employee> activeEmployeeList = new ArrayList<>();

        Date date = new Date();

        for (Employee employee : employeeList) {
            if (employee.getEmployeeFrom().before(date)) {
                if (employee.getEmployeeTo() == null || employee.getEmployeeTo().after(date)) {
                    activeEmployeeList.add(employee);
                }
            }
        }

        return activeEmployeeList;
    }

    @Override
    public List<Employee> getEmployeesByCity(String code) {
        List<Employee> employeeList = employeeRepository.findAll();
        List<Employee> activeEmployeeList = new ArrayList<>();

        for (Employee employee : employeeList) {
            if (employee.getAddress().getCity().getCode().equals(code)) {
                activeEmployeeList.add(employee);
            }
        }

        return activeEmployeeList;
    }

    @Override
    public void printEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<State> states = stateService.findAllStates();
        List<City> cities = cityService.findAllCities();
        List<Address> addresses = addressService.findAllAddresses();

        printEmployees(employees, states, cities, addresses);

    }

    private void printEmployees(List<Employee> employees, List<State> states, List<City> cities, List<Address> addresses) {
        State state = states.get(0);
        System.out.println(state.getName());

        for (City city : cities) {
            for (Address address : addresses) {
                if (address.getState().equals(state) && address.getCity().equals(city)) {
                    System.out.println("---- " + city.getName());
                    for (Employee employee : employees) {
                        if (employee.getAddress().equals(address))
                            System.out.println("---- ---- " + employee.getName() + employee.getSurname());
                    }
                }

            }
        }
        states.remove(0);
        if (!states.isEmpty())
            printEmployees(employees, states, cities, addresses);
    }
}



