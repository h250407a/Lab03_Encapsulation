// Encapsulated Student class with input validation and computed grade property.
class Student {
    private String name;
    private double marks; // 0 to 100

    public Student(String name, double marks) {
        setName(name);
        setMarks(marks);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name.trim();
    }

    public double getMarks() {
        return marks;
    }

    // Validates marks to ensure invariant: 0 <= marks <= 100
    public void setMarks(double marks) {
        if (marks < 0.0 || marks > 100.0) {
            throw new IllegalArgumentException("Marks must be between 0 and 100. Received: " + marks);
        }
        this.marks = marks;
    }

    // Computed property: returns letter grade without storing it in a redundant field
    public char getGrade() {
        if (marks >= 75.0) return 'A';
        if (marks >= 65.0) return 'B';
        if (marks >= 50.0) return 'C';
        return 'F';
    }

    public void display() {
        System.out.printf("Student: %-10s | Marks: %5.1f | Grade: %c%n", name, marks, getGrade());
    }
}

public class StudentGradeDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Anesu", 82.5);
        Student s2 = new Student("Chenai", 68.0);
        Student s3 = new Student("Farai", 54.0);
        Student s4 = new Student("Tatenda", 42.0);

        s1.display();
        s2.display();
        s3.display();
        s4.display();

        // Testing validation rejection
        try {
            System.out.println("\nAttempting to set marks to 115:");
            s1.setMarks(115.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Caught: " + e.getMessage());
        }

        try {
            System.out.println("Attempting to set marks to -10:");
            s1.setMarks(-10.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Caught: " + e.getMessage());
        }
    }
}
