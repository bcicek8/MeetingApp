package meetingapp.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import meetingapp.entity.Employee;
@Transactional
@Repository
public class EmployeeDAO implements IEmployeeDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Employee getEmployeeById(int employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		String hql = "FROM Employee as emp ORDER BY emp.id";
		return (List<Employee>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);
	}
	@Override
	public void updateEmployee(Employee employee) {
		Employee artcl = getEmployeeById(employee.getEmployeeId());
		artcl.setName(employee.getName());
		entityManager.flush();
	}
	@Override
	public void deleteEmployee(int employeeId) {
		entityManager.remove(getEmployeeById(employeeId));
	}
	@Override
	public boolean employeeExists(String name) {
		return false;
	}
}