public class Main {
    public static void main(String[] args) {
        Person p1 = new Student("John", "S12345");
        Person p2 = new Lecturer("Dr. Smith", "L98765");
        Person p3 = new Person("Alex", "P55555");

        p3.introduce();
        p1.introduce();
        p2.introduce();
    }
}
