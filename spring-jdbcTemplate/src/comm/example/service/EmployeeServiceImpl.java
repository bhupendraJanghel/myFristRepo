package comm.example.service;

import java.util.List;

import comm.example.DAO.EmpDAO;
import comm.example.DAO.EmployeeDaoImpl;
import comm.example.Model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmpDAO daoImpl=new EmployeeDaoImpl(); 
	public EmployeeServiceImpl(EmpDAO dao) {
		// TODO Auto-generated constructor stub
		this.daoImpl = dao;
	}

	@Override
	public void addEmployee(Employee employee) {
		daoImpl.addEmployee(employee);

		
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return daoImpl.getAllEmployee();
	}

	@Override
	public Employee findByID(int id) {
		
		return daoImpl.findByID(id);
	}

	@Override
	public String updateEmployee(int id) {
		
		return daoImpl.updateEmployee(id);
	}

	@Override
	public List<Employee> findByName(String name) {
		return daoImpl.findByName(name);
	}

}
