 class Student {
    private String name;
    private int id;
    private int[] grades;

    // Default Constructor
    public Student() {
        this.name = "Unknown";
        this.id = 0;
        this.grades = new int[0]; // Empty array for grades
    }

    // Parameterized Constructor
    public Student(String name, int id, int[] grades) {
        this.name = name;
        this.id = id;
        setGrades(grades); 
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int[] getGrades() {
        return grades;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Setter for grades with validation
    public void setGrades(int[] grades) {
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 0 || grades[i] > 100) {
                System.out.println("Error: Invalid grade " + grades[i] + " for student " + this.name);
                grades[i] = -1; // Mark invalid grades with -1
            }
        }
        this.grades = grades;
    }

    // Method to calculate the average grade
    public double calculateAverage() {
        if (grades.length == 0) {
            return 0;  
        }

        int sum = 0;
        int validGradeCount = 0;

        // Sum the valid grades
        for (int grade : grades) {
            if (grade >= 0 && grade <= 100) {
                sum += grade;
                validGradeCount++;
            }
        }

        // If there are no valid grades, return 0
        if (validGradeCount == 0) {
            return 0;
        }

        return (double) sum / validGradeCount;  // Calculate average of valid grades
    }
}

 class StudentManagement {
    private Student[] students;
    private int studentCount;

    // Constructor 
    public StudentManagement() {
        this.students = new Student[5]; 
        this.studentCount = 0;
    }

    // Method to add a student to the students array
    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount] = student;
            studentCount++;
            System.out.println("Student " + student.getName() + " added successfully.");
        } else {
            System.out.println("Cannot add more students. The array is full.");
        }
    }

    // Method to display all students
    public void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students to display.");
            return;
        }

        System.out.println("Displaying All Students:");
        for (int i = 0; i < studentCount; i++) {
            Student student = students[i];
            System.out.println("Name: " + student.getName() + ", ID: " + student.getId() + ", Average Grade: " + student.calculateAverage());
        }
    }
}
public class programmingAssignment3 {
    public static void main(String[] args) {
        //  StudentManagement object
        StudentManagement management = new StudentManagement();

        
        System.out.println("Creating students...");

        // Creating students and adding them to the management system
        int[] grades1 = {85, 90, 78};   // Valid grades
        Student student1 = new Student("Alice", 101, grades1);

        int[] grades2 = {92, 110, 75};  // Invalid grade (110)
        Student student2 = new Student("Bob", 102, grades2);

        int[] grades3 = {150, 200, -10}; // All invalid grades
        Student student3 = new Student("Charlie", 103, grades3);

        int[] grades4 = {}; // No grades
        Student student4 = new Student("David", 104, grades4);

        // Add students to the management system
        management.addStudent(student1);
        management.addStudent(student2);
        management.addStudent(student3);
        management.addStudent(student4);

        // Display all students
        management.displayAllStudents();
    }
}

