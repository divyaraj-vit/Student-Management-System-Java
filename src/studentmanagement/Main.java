package studentmanagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        DatabaseManager.initialize();

        int choice = 0;

        do {
            System.out.println("\n==============================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Add/Update Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Generate Report");
            System.out.println("7. Save to File");
            System.out.println("8. Save to Database");
            System.out.println("9. View Database Records");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter course: ");
                        String course = sc.nextLine();

                        manager.addStudent(new Student(id, name, course));
                    }

                    case 2 -> manager.viewStudents();

                    case 3 -> {
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        Student student = manager.searchStudent(id);

                        if (student != null) student.display();
                        else System.out.println("Student not found.");
                    }

                    case 4 -> {
                        System.out.print("Enter student ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        Student student = manager.searchStudent(id);

                        if (student == null) {
                            System.out.println("Student not found.");
                            break;
                        }

                        System.out.print("Java marks: ");
                        int java = Integer.parseInt(sc.nextLine());

                        System.out.print("DBMS marks: ");
                        int dbms = Integer.parseInt(sc.nextLine());

                        System.out.print("Networking marks: ");
                        int networking = Integer.parseInt(sc.nextLine());

                        try {
                            student.setMarks(new Marks(java, dbms, networking));
                            System.out.println("Marks saved successfully.");
                        } catch (InvalidMarksException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }

                    case 5 -> {
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        manager.deleteStudent(id);
                    }

                    case 6 -> {
                        ReportThread thread = new ReportThread(manager.getStudents());
                        thread.start();
                        thread.join();
                    }

                    case 7 -> FileManager.saveStudents(manager.getStudents());

                    case 8 -> DatabaseManager.saveStudents(manager.getStudents());

                    case 9 -> DatabaseManager.displayDatabaseStudents();

                    case 10 -> System.out.println("Thank you for using the system.");

                    default -> System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter valid numbers.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Report thread interrupted.");
            }
        } while (choice != 10);

        sc.close();
    }
}
