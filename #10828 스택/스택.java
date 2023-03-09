import java.util.Scanner;
public class Main {
    public static void main(String[] args) { //갓천대 화이팅! 이길여 총장님 오래사세요!

        Scanner in = new Scanner(System.in);
        StringBuilder s = new StringBuilder();

        int n = in.nextInt(); //스택의 길이 받는다.
        stack = new int[n]; //미리 선언한 stack을 배열로 만듦.
        for(int i = 0; i < n; i++) {

            String str = in.next(); //push.pop,size,empty, top을 사용하기 위해 문자열 입력받음

            switch (str) {

                case "push":
                    push(in.nextInt());
                    break;
                case "pop":
                    s.append(pop()).append('\n');
                    break;
                case "size":
                    s.append(size()).append('\n');
                    break;
                case "top":
                    s.append(top()).append('\n');
                    break;
                case "empty":
                    s.append(empty()).append('\n');
                    break;
            }

        }
        System.out.println(s);
    }
    public static int[] stack; //스택에 사용할 배열 선언!
    public static int size = 0; //스택의 사이즈 측정하는 것!
    public static void push(int item) {
        stack[size] = item;
        size++; //push할 때마다 size를 늘린다.
    }
    public static int pop() {//pop()은 제일 최근 위에 있는 데이터를 제거 후 리턴
        if(size == 0) {
            return -1; //
        }
        else {
            int data = stack[size - 1];//pop()하기 전 data로 빼고 -1인 이유는 인덱스이기 때문이다
            stack[size - 1] = 0; //0으로 변경
            size--;
            return data;
        }
    }
    public static int size() {
        return size;
    }
    public static int top() {
        if(size == 0) {
            return -1;
        }
        else {
            return stack[size - 1];
        }
    }
    public static int empty() { //스택이 비어있는지 확인 비어있으면 1을 리턴
        if(size == 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
}