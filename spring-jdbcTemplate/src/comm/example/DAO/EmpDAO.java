package comm.example.DAO;

import java.util.List;

import comm.example.Model.Employee;

public interface EmpDAO {

	public void addEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public Employee findByID(int id);
	public String updateEmployee(int id);
	public List<Employee> findByName(String name);
}
