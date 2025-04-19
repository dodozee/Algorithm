import java.util.*;
import java.io.*;

public class Main {
    
	static int inning; 
	static int[][] playerStat;
	
	static boolean[] isPlayerChecked;
	static int[] lineUp; 
	
	static Queue<Integer> que;
	static int out; 
	
	static int max = -1;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	inning = Integer.parseInt(br.readLine());
    	
    	playerStat = new int[inning][10];
    	for(int i=0; i<inning; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		for(int j=1; j<=9; j++) {
    			playerStat[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	isPlayerChecked = new boolean[10];
    	lineUp = new int[10];
    	
    	lineUp[4] = 1; 
    	isPlayerChecked[4] = true; 
    	
    	playerSeq(2);
    	
    	System.out.println(max); 
    	
    }
    
    // 선수 순서 정함
    static void playerSeq(int num) {
    	// 9명 다 채웠으면 종료
    	if(num == 10) {
    		
    		// 야구 게임 플레이
    		int score = play();
    		
    		max = Math.max(max, score);
    		
    		return;
    	}
    	
    	// 현재 선수를 1번 자리부터 9번 자리까지 넣어보며 재귀 호출
    	for(int i=1; i<=9; i++) {
    		
    		if(!isPlayerChecked[i]) {
    			isPlayerChecked[i] = true;
    			
    			lineUp[i] = num;
    			playerSeq(num + 1);
    			
    			isPlayerChecked[i] = false;
    		}
    	}
    }
    
    static int play() {
    	int sum = 0;
    	
    	int idx = 1; 
    	for(int r=0; r<inning; r++) {
    		int inningScore = 0; 
    		out = 0; 
    		boolean[] base = new boolean[4]; 
    		
    		while(out < 3) {
    			switch(playerStat[r][lineUp[idx]]) {
		    		case 0:
		    			out++;
		    			break;
		    		case 1:
		    			if(base[3]) {
		    				inningScore++;
		    				base[3] = false;
		    			}
		    			if(base[2]) {
		    				base[3] = true;
		    				base[2] = false;
		    			}
		    			if(base[1]) {
		    				base[2] = true;
		    			}
		    			base[1] = true;
		    			break;
		    		case 2:
		    			if(base[3]) {
		    				inningScore++;
		    				base[3] = false;
		    			}
		    			if(base[2]) {
		    				inningScore++;
		    			}
		    			if(base[1]) {
		    				base[3] = true;
		    				base[1] = false;
		    			}
		    			base[2] = true;
		    			break;
		    		case 3:
		    			if(base[3]) {
		    				inningScore++;
		    			}
		    			if(base[2]) {
		    				inningScore++;
		    				base[2] = false;
		    			}
		    			if(base[1]) {
		    				inningScore++;
		    				base[1] = false;
		    			}
		    			base[3] = true;
		    			break;
		    		case 4:
		    			if(base[3]) {
		    				inningScore++;
		    				base[3] = false;
		    			}
		    			if(base[2]) {
		    				inningScore++;
		    				base[2] = false;
		    			}
		    			if(base[1]) {
		    				inningScore++;
		    				base[1] = false;
		    			}
		    			inningScore++;
		    			break;
    			}
    			
    			idx++;
    			if(idx >= 10) {
    				idx = 1;
    			}
    		}
    		
    		sum += inningScore;
    		
    	}
    	
    	return sum;
    }

}