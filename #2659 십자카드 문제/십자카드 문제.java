import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int size;
	static String answer_str;
	static String reverse_answer_str;
	

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = 1000 * sc.nextInt() + 100 * sc.nextInt() 
                                 + 10 * sc.nextInt() + sc.nextInt();

		int tmp = num;
		for(int i =0;i<3;i++) {
			tmp = tmp / 10 + 1000*(tmp%10);
			num = Math.min(num, tmp);
		}
		
		int ans = 0;
		for(int t = 1111;t<num;t++) {
			if(check(t)) ans++;
		}
		
		System.out.println(ans+1);
        
    
	}
    
        private static boolean check(int t) {
		int tmp = t;
		for(int i =0;i<3;i++) {
			if(tmp%10==0) return false;
			
			tmp = tmp /  10 + 1000 * (tmp%10);
			if(tmp < t) return false;
		}
		
		return true;
	}
    

}