package studentmanagement;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private final ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (searchStudent(student.getId()) != null) {
            System.out.println("Student ID already exists.");
            return;
        }
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) return student;
        }
        return null;
    }

    public void deleteStudent(int id) {
        Student student = searchStudent(id);
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            students.remove(student);
            System.out.println("Student deleted successfully.");
        }
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students) student.display();
    }

    public List<Student> getStudents() {
        return students;
    }
}
