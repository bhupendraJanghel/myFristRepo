package login_maven.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CheckUserDaoImpl implements CheckUserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Login checkUser(Login login) {

		
		return jdbcTemplate.queryForObject("select * from login_maven where username=? and password=?",
				new RowMapper<Login>() {

						public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Login login=new Login();
						login.setUserName(rs.getString(1));
						login.setPassword(rs.getString(2));
						return login;
					}
				}, login.getUserName(), login.getPassword());

	
	}

}
