package com.mvc.dao;

import java.util.List;

import com.mvc.entity.Student;

public interface UserService {
	
	public void saveStudent(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(String student);
	public List<Student> getAllStudent();
}
