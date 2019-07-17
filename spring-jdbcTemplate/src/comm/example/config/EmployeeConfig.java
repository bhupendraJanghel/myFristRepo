package comm.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import comm.example.DAO.EmpDAO;
import comm.example.DAO.EmployeeDaoImpl;
import comm.example.service.EmployeeService;
import comm.example.service.EmployeeServiceImpl;

@Configuration

public class EmployeeConfig {


	@Bean
	public DriverManagerDataSource dSource() {
		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/sample", "root", "root");
	}
	
	@Bean
	public JdbcTemplate jTemplate()
	{
		return new JdbcTemplate(dSource());
	}
	
	@Bean EmpDAO dao() {
		return new EmployeeDaoImpl(jTemplate());
	}
	
	@Bean EmployeeService service() {
		return new EmployeeServiceImpl(dao());
	}
}
