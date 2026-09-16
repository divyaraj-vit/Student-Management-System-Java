package studentmanagement;

import java.util.List;

public class ReportThread extends Thread {
    private final List<Student> students;

    public ReportThread(List<Student> students) {
        this.students = students;
    }

    @Override
    public void run() {
        System.out.println("\nGenerating report in background...");
        Report.generate(students);
        System.out.println("Report generation completed.");
    }
}
