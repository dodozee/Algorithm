import java.util.Scanner;
public class Main {
    public static void main(String[] args) { //갓천대 화이팅! 이길여 총장님 오래사세요!
        Scanner in = new Scanner(System.in);
        StringBuilder s = new StringBuilder(); //가변객체이다.

        int n = in.nextInt(); //스택의 길이 받는다.
        stack = new long[n]; //미리 선언한 stack을 Long 배열로 만듦.
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(in.next()); //push.pop,size,empty, top을 사용하기 위해 문자열 입력받음
            if (num == 0) { //0이 입력되면 pop으로 사라지게한다.
                s.append(pop()).append('\n');

            }else{
                push(num); //num을 넘김

            }
        }
        System.out.println(sum);
    }
    public static long sum=0;
    public static long[] stack; //스택에 사용할 배열 선언!
    public static int size = 0; //스택의 사이즈 측정하는 것!
    public static void push(long item) {
        stack[size] = item;
        size++; //push할 때마다 size를 늘린다.
        sum += item;
    }

    public static long pop() {//pop()은 제일 최근 위에 있는 데이터를 제거 후 리턴
            long data = stack[size - 1];//pop()하기 전 data로 빼고 -1인 이유는 인덱스이기 때문이다
            stack[size - 1] = 0; //0으로 변경
            size--;
            sum -= data;
            return data;

    }


}
