package comm.example.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import comm.example.Model.Employee;

public class EmployeeDaoImpl implements EmpDAO {

	private JdbcTemplate jdbcTemplate;

	public EmployeeDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addEmployee(Employee employee) {
		jdbcTemplate.update("insert into employees values(?,?,?,?)", employee.getEmployeeId(), employee.getFirstName(),
				employee.getLastName(), employee.getSalary());

	}

	@Override
	public List<Employee> getAllEmployee() {
		return jdbcTemplate.query("select * from employees", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int arg1) throws SQLException {

				Employee employee = new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setFirstName(rs.getString(2));
				employee.setLastName(rs.getString(3));
				employee.setSalary(rs.getInt(4));
				return employee;
			}

		});
	}

	@Override
	public Employee findByID(int id) {

		return jdbcTemplate.queryForObject("select * from employees where employee_id=?", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int arg1) throws SQLException {

				Employee employee = new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setFirstName(rs.getString(2));
				employee.setLastName(rs.getString(3));
				employee.setSalary(rs.getInt(4));
				return employee;
			}
		},id);
	}

	@Override
	public String updateEmployee(int id) {
		Scanner sc=new Scanner(System.in);
		EmpDAO emp=new EmployeeDaoImpl();
		
			 System.out.println("First name:");
			 String first_name=sc.next();
			 System.out.println("Last name:");
			 String last_name=sc.next();
			 System.out.println("Salary");
			 int salary=sc.nextInt();
			 jdbcTemplate.update("update employees set first_name=?,last_name=?,salary=? where employee_id=?",first_name,last_name,salary,id);
		
	
		return "Updated Successfully";
	}

	@Override
	public List<Employee> findByName(String name) {
		
				
		return  jdbcTemplate.query("Select * from employees where first_name=?",new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
				Employee employee=new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setFirstName(rs.getString(2));
				employee.setLastName(rs.getString(3));
				employee.setSalary(rs.getInt(4));
				return employee;
			} 
			
		},name);
	}

}
