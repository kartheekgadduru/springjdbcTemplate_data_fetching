package com.jdbc.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.service.StudentSvc;

public class MainApp {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/springjdbcbean.xml");
		System.out.println("hellow");
		StudentSvc studentSvc = (StudentSvc)context.getBean("studentsvr");

		//System.out.println(studentSvc.getStudent(5));
		System.out.println(studentSvc.getAllStudents());
	}

}
