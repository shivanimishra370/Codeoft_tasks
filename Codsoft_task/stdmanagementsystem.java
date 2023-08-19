
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class Student {
    private int rollNumber;
    private String name;
    private String grade;

    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
    }

    public int getRollNumber() 
    {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) 
    {
        this.rollNumber = rollNumber;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getGrade() 
    {
        return grade;
    }

    public void setGrade(String grade) 
    {
        this.grade = grade;
    }

   // @Override
    public String toString() 
    {
        return "Roll Number: " + rollNumber + ", Name: " + name + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) 
        {
            System.out.print("1. Add Student\n");
            System.out.print("2. Remove Student\n");
            System.out.print("3. Search Student\n");
            System.out.print("4. Display All Students\n");
            System.out.print("5. Exit\n");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();
                    
                    Student newStudent = new Student(rollNumber, name, grade);
                    
                    system.addStudent(newStudent);
                    break;
                    
                case 2:
                    System.out.print("Enter Roll Number of the student to remove: ");
                    int rollNumToRemove = scanner.nextInt();
                    system.removeStudent(rollNumToRemove);
                    break;
                    
                case 3:
                    System.out.print("Enter Roll Number of the student to search: ");
                    int rollNumToSearch = scanner.nextInt();
                    
                    Student searchedStudent = system.searchStudent(rollNumToSearch);
                    
                    if (searchedStudent != null) 
                    {
                        System.out.println("Student Found: " + searchedStudent);
                    } 
                    else 
                    {
                        System.out.println("Student not found.");
                    }
                    break;
                    
                case 4:
                    system.displayAllStudents();
                    break;
                    
                case 5:
                    System.out.println("Exiting...");
                     System.out.println("Thank you!!!");
                    scanner.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}