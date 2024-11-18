package com.cdac.dao;

import com.cdac.pojos.Student;
import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
	void addStudent(Student student) throws SQLException;
	List<Student> getAllStudents() throws SQLException;
	void updateStudent(Student student)throws SQLException;
	void deleteStudent(int id)throws SQLException;
	Student searchStudentByEmail(String email) throws SQLException;
	Student searchStudentByName(String Name) throws SQLException;
	
	void cleanUp() throws SQLException;

}
