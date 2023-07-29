import java.io.*;
import java.util.*;
/*      박두지 화이팅!! 갓천대 화이팅!!!
[문제접근]
1.도표에 있는 변경 규칙에 따라 크로아티아 알파벳을 찾아낸다.
2.각 알파멧마다 한개씩 매칭시킨다.
-예를들어서 ijes=njak 라는 문자열이 있으면 ij는 하나의 문자이므로 nj도 하나의 문자이다.
3.-,= 같은 의미없는 문자는 삭제하기 위해서 for문으로 replace()메서드를 이용하여 ""대입하고 삭제.
4.필터링된  문자 배열을 for문으로 돌리며 String의 replace() 메서드를 사용하여 1로 바꿈.
5.문자열 길이를 알게해주는 length() 메서드를 사용하면 끝
[주의할 점]
크게 없어보인다.
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int length = str.length();
        int cnt = 0;

        for (int i = 0; i < length; i++) {

            char ch = str.charAt(i);

            if(ch == 'c' && i < length - 1) {		
                if(str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    i++;
                }
            } else if(ch == 'd' && i < length - 1) {
                if(str.charAt(i + 1) == '-') {	
                    i++;
                }
                else if(str.charAt(i + 1) == 'z' && i < length - 2) {

                    if(str.charAt(i + 2) == '=') {	
                        i += 2;
                    }
                }
            } else if((ch == 'l' || ch == 'n') && i < length - 1) {
                if(str.charAt(i + 1) == 'j') {	
                    i++;
                }
            } else if((ch == 's' || ch == 'z') && i < length - 1) {
                if(str.charAt(i + 1) == '=') {	
                    i++;
                }

            }
            cnt++;

        }

        System.out.println(cnt);
    }
}