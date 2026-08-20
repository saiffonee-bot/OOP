public class main {
    public static void main(String[] args) {
        Student student = new Student();

        // Setting values using setter methods
        student.setStudentID("CU12345");
        student.setName("Ali");
        student.setCGPA(3.75);
        student.setProgramme("BIT");

        // Displaying output using getter methods
        System.out.println("Student ID : " + student.getStudentID());
        System.out.println("Name       : " + student.getName());
        System.out.println("CGPA       : " + student.getCGPA());
        System.out.println("Programme  : " + student.getProgramme());
    }
}
