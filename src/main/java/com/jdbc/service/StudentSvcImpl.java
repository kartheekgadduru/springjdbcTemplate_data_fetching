package com.jdbc.service;

import java.util.List;

import com.jdbc.dao.Studentdao;
import com.jdbc.modal.Student;

public class StudentSvcImpl implements StudentSvc{

	private Studentdao studentdao;


	public void setStudentdao(Studentdao studentdao) {
		this.studentdao = studentdao;
	}


	public Student getStudent(int id)  {
		// TODO Auto-generated method stub
		return studentdao.getStudentById(id);
	}


	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentdao.getAllStudents();
	}

}
