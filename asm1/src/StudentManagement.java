import java.util.*;

class Student {
    private String studentId;
    private String studentName;
    private double marks;

    // Constructor
    public Student(String studentId, String studentName, double marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.marks = marks;
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Method to rank students based on marks
    public String getRanking() {
        if (marks < 5.0) {
            return "Fail";
        } else if (marks < 6.5) {
            return "Medium";
        } else if (marks < 7.5) {
            return "Good";
        } else if (marks < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + studentName + ", Marks: " + marks + ", Rank: " + getRanking();
    }
}

public class StudentManagement {
    private List<Student> students = new ArrayList<>();

    // Add a new student
    public void addStudent(String studentId, String studentName, double marks) {
        students.add(new Student(studentId, studentName, marks));
    }

    // Edit student details
    public void editStudent(String studentId, String newName, double newMarks) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.setStudentName(newName);
                student.setMarks(newMarks);
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    // Delete a student
    public void deleteStudent(String studentId) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentId().equals(studentId)) {
                iterator.remove();
                System.out.println("Student removed successfully.");
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    // Search for a student by ID
    public void searchStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    // Sort students by marks
    public void sortStudents() {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("Students sorted by marks in descending order:");
        displayAllStudents();
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement management = new StudentManagement();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Sort Students");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String id = scanner.next();
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    System.out.print("Enter student marks: ");
                    double marks = scanner.nextDouble();
                    management.addStudent(id, name, marks);
                    break;
                case 2:
                    System.out.print("Enter student ID to edit: ");
                    String editId = scanner.next();
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new marks: ");
                    double newMarks = scanner.nextDouble();
                    management.editStudent(editId, newName, newMarks);
                    break;
                case 3:
                    System.out.print("Enter student ID to delete: ");
                    String deleteId = scanner.next();
                    management.deleteStudent(deleteId);
                    break;
                case 4:
                    System.out.print("Enter student ID to search: ");
                    String searchId = scanner.next();
                    management.searchStudent(searchId);
                    break;
                case 5:
                    management.sortStudents();
                    break;
                case 6:
                    management.displayAllStudents();
                    break;
                case 7:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}