import java.util.*;

public class Main{
	
    static int result;
    
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	for(int i = 0; i < T; i++) {
    		result = 0;
    		System.out.println(validate(sc.next()) + " " + result);
    	}
    	sc.close();
    }
    
    private static int recur(String s, int l, int r){
    	result++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recur(s, l+1, r-1);
    }
    
    private static int validate(String s){
        return recur(s, 0, s.length()-1);
    }
}