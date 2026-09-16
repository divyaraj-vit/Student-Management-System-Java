package studentmanagement;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileManager {
    public static void saveStudents(List<Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("students.txt"))) {
            for (Student student : students) {
                writer.println("ID: " + student.getId());
                writer.println("Name: " + student.getName());
                writer.println("Course: " + student.getCourse());

                if (student.getMarks() != null) {
                    writer.printf("Percentage: %.2f%n",
                            student.getMarks().calculatePercentage());
                    writer.println("Grade: " + student.getMarks().calculateGrade());
                    writer.println("Result: " + student.getMarks().getResult());
                }
                writer.println("---------------------------");
            }
            System.out.println("Data saved to students.txt");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
