package studentmanagement;

import java.util.List;

public class Report {
    public static void generate(List<Student> students) {
        System.out.println("\n===== STUDENT PERFORMANCE REPORT =====");

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        int pass = 0;
        int fail = 0;

        for (Student student : students) {
            System.out.println("\nID: " + student.getId());
            System.out.println("Name: " + student.getName());

            if (student.getMarks() != null) {
                System.out.printf("Percentage: %.2f%%%n",
                        student.getMarks().calculatePercentage());
                System.out.println("Grade: " + student.getMarks().calculateGrade());
                System.out.println("Result: " + student.getMarks().getResult());

                if (student.getMarks().getResult().equals("PASS")) pass++;
                else fail++;
            } else {
                System.out.println("Marks not entered.");
            }
        }

        System.out.println("\nPassed: " + pass);
        System.out.println("Failed: " + fail);
    }
}
