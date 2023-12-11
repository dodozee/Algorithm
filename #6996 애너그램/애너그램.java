import java.util.Arrays;
import java.util.Scanner;
 
public class Main {//박두지 화이팅!!
    public static String sortString(String string){
        char[] solution = string.toCharArray();
        Arrays.sort(solution);
        return new StringBuilder(new String(solution)).toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int N = Integer.parseInt(sc.next());
         
        for(int i=0; i < N; i++) {
            String A = sc.next();
            String B = sc.next();
 
            System.out.print(A + " & " + B + " are ");
            if(!sortString(A).equals(sortString(B))) {
                System.out.print("NOT ");
            }
            System.out.println("anagrams.");
        }
 
    }
}