package meetingapp.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import meetingapp.entity.Department;
@Transactional
@Repository
public class DepartmentDAO implements IDepartmentDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Department getDepartmentById(int departmentId) {
		return entityManager.find(Department.class, departmentId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getAllDepartments() {
		String hql = "FROM Department as dep ORDER BY dep.id";
		return (List<Department>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addDepartment(Department department) {
		entityManager.persist(department);
	}
	@Override
	public void updateDepartment(Department department) {
		Department artcl = getDepartmentById(department.getDepartmentId());
		artcl.setName(department.getName());
		artcl.setDescription(department.getDescription());
		entityManager.flush();
	}
	@Override
	public void deleteDepartment(int departmentId) {
		entityManager.remove(getDepartmentById(departmentId));
	}
	@Override
	public boolean departmentExists(String name, String desscription) {
		String hql = "FROM Department as dep WHERE dep.name = ? and dep.description = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name)
		              .setParameter(2, desscription).getResultList().size();
		return count > 0 ? true : false;
	}
}