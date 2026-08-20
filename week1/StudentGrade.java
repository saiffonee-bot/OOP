public class StudentGrade {
    public static void main(String[] args) {
        int score = 85;

        System.out.println("Student Score: " + score);

        if (score >= 80) {
            System.out.println("Grade: A");
        } else if (score >= 70) {
            System.out.println("Grade: B");
        } else if (score >= 60) {
            System.out.println("Grade: C");
        } else if (score >= 50) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }
}
