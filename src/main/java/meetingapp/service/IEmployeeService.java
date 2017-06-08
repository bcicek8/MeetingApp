package meetingapp.service;
import java.util.List;
import meetingapp.entity.Employee;
public interface IEmployeeService {
     List<Employee> getAllEmployees();
     Employee getEmployeeById(int employeeId);
     boolean addEmployee(Employee employee);
     void updateEmployee(Employee employee);
     void deleteEmployee(int employeeId);
}