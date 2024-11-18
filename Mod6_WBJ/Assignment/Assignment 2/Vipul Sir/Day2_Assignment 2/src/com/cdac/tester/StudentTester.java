package com.cdac.tester;

import java.util.Scanner;
import com.cdac.dao.StudentDao;
import com.cdac.dao.StudentDaoImpl;
import com.cdac.pojos.Student;

public class StudentTester {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            StudentDao dao = new StudentDaoImpl();

            while (true) {
                System.out.println("\n1. Add Student\n2. View All Students\n3. Update Student\n4. Delete Student\n5. Search by Email\n6. Search by Name\n7. Exit");
                System.out.print("Choose an Option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Name, Age, Grade, Email: ");
                        dao.addStudent(new Student(0, sc.next(), sc.nextInt(), sc.next(), sc.next()));
                        System.out.println("Student added successfully!");
                        break;
                    case 2:
                        dao.getAllStudents().forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("Enter ID to update, Name, Age, Grade, Email: ");
                        dao.updateStudent(new Student(sc.nextInt(), sc.next(), sc.nextInt(), sc.next(), sc.next()));
                        System.out.println("Student updated successfully!");
                        break;
                    case 4:
                        System.out.print("Enter ID to delete: ");
                        dao.deleteStudent(sc.nextInt());
                        System.out.println("Student deleted successfully!");
                        break;
                    case 5:
                        System.out.print("Enter Email to search: ");
                        System.out.println(dao.searchStudentByEmail(sc.next()));
                        break;
                    case 6:
                        System.out.print("Enter Name to search: ");
                        System.out.println(dao.searchStudentByName(sc.next()));
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        dao.cleanUp();
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}