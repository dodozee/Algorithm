import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();
		int countA = 0;
        int countB = 0;

		for (char result : str.toCharArray()) {
			if (result == 'A') {
				countA++;
			}
            
            if(result == 'B'){
                countB++;
            }
		}
        
        String ret = "A";

		if (countA == countB) {
			ret = "Tie";
		} else if (countA < countB) {
			ret = "B";
		} 
		System.out.println(ret);
	}
}