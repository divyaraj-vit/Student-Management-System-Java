package studentmanagement;

public class Student extends Person implements Reportable {
    private String course;
    private Marks marks;

    public Student(int id, String name, String course) {
        super(id, name);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public Marks getMarks() {
        return marks;
    }

    public void setMarks(Marks marks) {
        this.marks = marks;
    }

    @Override
    public void display() {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Course: " + course);
        if (marks != null) {
            marks.display();
        } else {
            System.out.println("Marks: Not entered");
        }
        System.out.println("---------------------------");
    }

    @Override
    public void displayReport() {
        System.out.println("\nStudent Report");
        display();
    }
}
