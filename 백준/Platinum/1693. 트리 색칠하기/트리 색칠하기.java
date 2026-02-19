import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
    static int MAX_color = 20;
    static int DP[][] =  new int[100004][MAX_color+1];; 
    static boolean choice[];
    static int Min = Integer.MIN_VALUE;
    
    
    public static int Tree_table_set(ArrayList<ArrayList<Integer>> list,int par,int index,int color) {
    	
    	if(DP[index][color]!=0) return DP[index][color]; //값을 취합하는 과정에서 거꾸로 가는것을 방지
    	for(int next : list.get(index)) {
    		if(next == par) continue;    //부모로는 못가게 막는다. 
    		int min = Integer.MAX_VALUE; //최솟값 정의 => 값은 최대 
    		
        	for(int i=1;i<=MAX_color;i++) {
        		if(i == color) continue;  //일단 부모 컬러는 제외 시킨다. 
        		int t = Tree_table_set(list,index,next,i); //서브트리 탐색
        					  //트리의 말단 노드까지 이동하고 최소 컬러 노드를 넣어준다.        		                                              
        		min = Math.min(min, t);  
        	}
        	DP[index][color] += min;	
    	}
    	
    	//말단 노드에 값을 넣어준다. 
    	DP[index][color] += color;
    	return DP[index][color]; //그 값을 리턴해준다.    	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	
		for(int i=0;i<=n;i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0;i<n-1;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.get(x).add(y);
			list.get(y).add(x); 
		}
		list.get(0).add(1);
		int result = Tree_table_set(list,-1,0,0);
		System.out.println(result);
	}
}