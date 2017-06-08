package meetingapp.service;
import java.util.List;
import meetingapp.entity.Department;
public interface IDepartmentService {
     List<Department> getAllDepartments();
     Department getDepartmentById(int departmentId);
     boolean addDepartment(Department department);
     void updateDepartment(Department department);
     void deleteDepartment(int departmentId);
}