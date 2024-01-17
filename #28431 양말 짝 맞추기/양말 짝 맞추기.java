import java.util.*;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 5;

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<cnt; i++) {
            int num = sc.nextInt();
            if(set.contains(num)) set.remove(num);
            else set.add(num);
        }

        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}