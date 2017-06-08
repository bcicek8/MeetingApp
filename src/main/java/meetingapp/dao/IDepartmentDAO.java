package meetingapp.dao;
import java.util.List;
import meetingapp.entity.Department;
public interface IDepartmentDAO {
    List<Department> getAllDepartments();
    Department getDepartmentById(int departmentId);
    void addDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(int departmentId);
    boolean departmentExists(String title, String category);
}