import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] burger = new int[3];	
		int[] drink = new int[2];	
		int bm = Integer.MAX_VALUE;
        int dm = Integer.MAX_VALUE; 
		
		for (int i=0; i<3; i++) {	
			burger[i] = scan.nextInt();
			
			if(bm > burger[i]) {	
				bm = burger[i];		
			}
		}
		
		for(int i=0; i<2; i++) {	
			drink[i] = scan.nextInt();

			if(dm > drink[i])		
				dm = drink[i];		
		}
		System.out.println(bm + dm - 50);	
	}
}