import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        HashSet<String> hs = new HashSet<>();

        for(int i=0; i<n; i++){
            String str= sc.next();
            char[] word = str.toCharArray();
            Arrays.sort(word);
            hs.add(Arrays.toString(word));
        }
        System.out.println(hs.size());
    }
}