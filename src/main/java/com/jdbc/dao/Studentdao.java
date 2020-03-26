package com.jdbc.dao;

import java.util.List;

import com.jdbc.modal.Student;

public interface Studentdao {

	Student getStudentById(int id) ;

	List<Student> getAllStudents();

}
