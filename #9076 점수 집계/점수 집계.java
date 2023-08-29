import java.util.*;

public class Main{//박두지 화이팅!!
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] score = new int[5];
        
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<score.length;j++)
            {
            	score[j] = sc.nextInt();
            }
        	Arrays.sort(score);
        	if(score[3] >= 4 + score[1])
        	{
        		System.out.println("KIN");
        	}
        	else
        		System.out.println(score[1] + score[2] + score[3]);
        }
        sc.close();
    }
}