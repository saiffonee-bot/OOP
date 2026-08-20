public class Student {
    // Attributes
    String name;
    int age;
    double gpa;

    // Constructor
    public Student(String studentName, int studentAge, double studentGpa) {
        name = studentName;
        age = studentAge;
        gpa = studentGpa;
    }

    // Method to display student information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
    }

    // Method for studying
    public void study() {
        System.out.println(name + " is studying.");
    }

    // Method for taking exams
    public void takeExam() {
        System.out.println(name + " is taking an exam.");
    }
}
