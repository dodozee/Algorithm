import java.util.*;
 
class Main{//박두지 화이팅!!
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 2;
        int res = 0;
        Integer array[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(array, Collections.reverseOrder());
 
        for (int i = 0; i < n; i++) {
            res = Math.max(res, count + array[i]);
            count++;
        }
 
        System.out.println(res);
    }
}
