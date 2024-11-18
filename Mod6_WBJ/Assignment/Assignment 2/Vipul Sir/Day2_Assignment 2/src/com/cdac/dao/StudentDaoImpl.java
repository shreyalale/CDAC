
package com.cdac.dao;

import com.cdac.pojos.Student;
import com.cdac.utils.DBUtils;
import java.sql.*;
import java.util.*;

public class StudentDaoImpl implements StudentDao {
    private Connection connection;

    public StudentDaoImpl() throws SQLException {
        connection = DBUtils.openConnection();
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (name, age, grade, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, student.getName());
            pst.setInt(2, student.getAge());
            pst.setString(3, student.getGrade());
            pst.setString(4, student.getEmail());
            pst.executeUpdate();
        }
    }

    @Override
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
                        rs.getString("grade"), rs.getString("email")));
            }
        }
        return students;
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        String sql = "UPDATE students SET name=?, age=?, grade=?, email=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getGrade());
            ps.setString(4, student.getEmail());
            ps.setInt(5, student.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public Student searchStudentByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM students WHERE email=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
                            rs.getString("grade"), rs.getString("email"));
                }
            }
        }
        return null;
    }

    @Override
    public Student searchStudentByName(String name) throws SQLException {
        String sql = "SELECT * FROM students WHERE name=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
                            rs.getString("grade"), rs.getString("email"));
                }
            }
        }
        return null;
    }

    @Override
    public void cleanUp() throws SQLException {
        DBUtils.closeConnection();
    }
}











