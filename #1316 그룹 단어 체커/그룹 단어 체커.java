import java.util.*;
public class Main {//두지 코더 화이팅!! 갓천대 컴공 화이팅!!
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.next()); //단어 갯수 받기
        int count =n; // 단어들의 수를 초기값으로 잡아두고 나중에 아닌 단어만 -1씩 시켜준다.

        for(int i = 0; i<n; i++) {
            String string = s.next(); //문자열 입력 받음
            boolean check[] = new boolean[26]; //앞파벳 갯수만큼 배열 생성

            for(int j=0; j<string.length()-1;j++) {
                if(string.charAt(j)!=string.charAt(j+1)) {
                    if(check[string.charAt(j+1)-97]==true) {//a는 아스키코드로 97이므로 a부터 0으로 하는 셈
                        count--;
                        break;
                    }

                }

                check[string.charAt(j)-97]=true; //a는 아스키코드로 97이므로 a부터 0으로 하는 셈
               
            }
        }
        System.out.println(count);
    }
}
