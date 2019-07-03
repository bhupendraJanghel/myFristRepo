package com.example.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.spring.Student;

public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public StudentDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addStudent(Student student) {

		String[] temp = student.getOperatingSystem();
		StringBuilder sb = new StringBuilder();
		for (String str : temp) {
			sb.append(str).append(",");
		}

		jdbcTemplate.update(
				"insert into studentSpringMvc(first_name,last_name,language,country,operatingSystem) values(?,?,?,?,?)",
				student.getFirst_name(), student.getLast_name(), student.getFavoriteLanguage(), student.getCountry(),
				sb.toString());

	}

	@Override
	public List<Student> getAll() {

		return jdbcTemplate.query("select * from studentSpringMvc", new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int arg1) throws SQLException {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setFirst_name(rs.getString(2));
				s.setLast_name(rs.getString(3));

				s.setFavoriteLanguage(rs.getString(4));
				s.setCountry(rs.getString(5));

				s.setOs(rs.getString(6));

				return s;
			}

		});

	}

	@Override
	public void delete(int id) {

		jdbcTemplate.update("Delete from studentSpringMvc where id=?", id);

	}

	@Override
	public void update(Student student) {
		
		String[] temp = student.getOperatingSystem();
		StringBuilder sb = new StringBuilder();
		for (String str : temp) {
			sb.append(str).append(",");
		}
		
		jdbcTemplate.update("update studentspringMvc set first_name=?,last_name=?,language=?,country=?,operatingSystem=? where id=?",
				student.getFirst_name(),student.getLast_name(),student.getFavoriteLanguage(),student.getCountry(),sb.toString(),student.getId());
		
	}

}
