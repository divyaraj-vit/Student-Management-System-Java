package studentmanagement;

public class Marks {
    private int javaMarks;
    private int dbmsMarks;
    private int networkingMarks;

    public Marks(int javaMarks, int dbmsMarks, int networkingMarks)
            throws InvalidMarksException {

        validate(javaMarks);
        validate(dbmsMarks);
        validate(networkingMarks);

        this.javaMarks = javaMarks;
        this.dbmsMarks = dbmsMarks;
        this.networkingMarks = networkingMarks;
    }

    private void validate(int mark) throws InvalidMarksException {
        if (mark < 0 || mark > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100.");
        }
    }

    public int calculateTotal() {
        return javaMarks + dbmsMarks + networkingMarks;
    }

    public double calculatePercentage() {
        return calculateTotal() / 3.0;
    }

    public String calculateGrade() {
        double p = calculatePercentage();

        if (p >= 90) return "A+";
        else if (p >= 80) return "A";
        else if (p >= 70) return "B";
        else if (p >= 60) return "C";
        else if (p >= 50) return "D";
        else return "F";
    }

    public String getResult() {
        return (javaMarks >= 40 && dbmsMarks >= 40 && networkingMarks >= 40)
                ? "PASS" : "FAIL";
    }

    public void display() {
        System.out.println("Java: " + javaMarks);
        System.out.println("DBMS: " + dbmsMarks);
        System.out.println("Networking: " + networkingMarks);
        System.out.println("Total: " + calculateTotal());
        System.out.printf("Percentage: %.2f%%%n", calculatePercentage());
        System.out.println("Grade: " + calculateGrade());
        System.out.println("Result: " + getResult());
    }

    public int getJavaMarks() { return javaMarks; }
    public int getDbmsMarks() { return dbmsMarks; }
    public int getNetworkingMarks() { return networkingMarks; }
}
