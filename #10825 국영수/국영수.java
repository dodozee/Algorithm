import java.util.*;
//박두지 화이팅!!!
class Student implements Comparable<Student> {
    String name;
    int korean;
    int english;
    int math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Student other) {
        if (this.korean != other.korean) {
            return Integer.compare(other.korean, this.korean); // 국어 점수 감소 순서로 정렬
        } else if (this.english != other.english) {
            return Integer.compare(this.english, other.english); // 영어 점수 증가 순서로 정렬
        } else if (this.math != other.math) {
            return Integer.compare(other.math, this.math); // 수학 점수 감소 순서로 정렬
        } else {
            return this.name.compareTo(other.name); // 이름 사전 순으로 정렬
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String name = scanner.next();
            int korean = scanner.nextInt();
            int english = scanner.nextInt();
            int math = scanner.nextInt();
            students.add(new Student(name, korean, english, math));
        }

        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student.name);
        }
    }
}
