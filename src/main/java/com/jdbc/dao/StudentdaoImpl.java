package com.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.jdbc.modal.Student;

public class StudentdaoImpl implements Studentdao {

	private DataSource datasource;
	private JdbcTemplate jdbcTemplate;


	private  String sql = "select *from student where id =?";


	public void setDatasource(DataSource datasource) {

		this.datasource = datasource;
	}



	@Override
	public Student getStudentById(int id) {
		jdbcTemplate = new JdbcTemplate(datasource);
		Student student =jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				student.setAge(rs.getInt("age"));
				return student;
			}

		});
		return student;
	}

	public Student getStudentUsingLambda(int id) {
		jdbcTemplate = new JdbcTemplate(datasource);
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, (rs, rowNum) ->
		new Student(rs.getInt("id"),
				rs.getString("name"),
				rs.getString("email"),
				rs.getInt("age"))
				);

	}



	@Override
	public List<Student> getAllStudents() {
		jdbcTemplate = new JdbcTemplate(datasource);
		List<Student> studentList = jdbcTemplate.query("select *from student", new StudentRowmapper());
		return studentList;
	}

}
