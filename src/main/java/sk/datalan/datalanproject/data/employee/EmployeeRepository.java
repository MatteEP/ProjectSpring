package sk.datalan.datalanproject.data.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.datalan.datalanproject.data.utils.Gender;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByGender(Gender gender);

    List<Employee> findByOrderByAge();

}
