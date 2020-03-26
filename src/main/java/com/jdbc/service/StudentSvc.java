package com.jdbc.service;

import java.util.List;

import com.jdbc.modal.Student;

public interface StudentSvc {
	Student getStudent(int id);
	List<Student> getAllStudents();
}
