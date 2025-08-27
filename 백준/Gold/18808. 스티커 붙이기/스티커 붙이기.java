import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	public static int N, M, K, res;
	public static int[][] map;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] inputs = br.readLine().split(" ");
    	
    	N = Integer.parseInt(inputs[0]);
    	M = Integer.parseInt(inputs[1]);
    	K = Integer.parseInt(inputs[2]);
    	
    	map = new int[N][M];
    	
    	for(int k = 0; k < K; k++) {
    		// 스티커 크기
    		String[] sizeInfo = br.readLine().split(" ");
    		int h = Integer.parseInt(sizeInfo[0]);
    		int w = Integer.parseInt(sizeInfo[1]);
    		int[][] sticker = new int[h][w];
    		
    		for(int i = 0; i < h; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    			for(int j = 0; j < w; j++) {
    				sticker[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		attach(sticker);
    	}
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			if(map[i][j] == 1) res++;
    		}
    	}
    	
    	System.out.println(res);
    }
    
    public static void attach(int[][] s) {
    	for(int r = 0; r < 4; r++) {
    		for(int i = 0; i < N; i++) {
        		for(int j = 0; j < M; j++) {
        			if(!isValid(i, j, s)) continue;
        			int maxX = j + (s[0].length);
        			int maxY = i + (s.length);
        			for(int y = i; y < maxY; y++) {
        				for(int x = j; x < maxX; x++) {
        					if(s[y-i][x-j] == 1) map[y][x] = s[y-i][x-j];
        				}
        			}
//        			print();
        			return;
        		}
        	}
    		s = rotate(s.length, s[0].length, s);
    	}
    }
    
    public static void print() {
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			System.out.print(map[i][j]);
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
    
    public static boolean isValid(int y, int x, int[][] s) {
    	// 크기
    	int maxX = x + (s[0].length);
    	int maxY = y + (s.length);
    	
    	if(maxX > M || maxY > N) return false;
    	
    	for(int i = y; i < maxY; i++) {
    		for(int j = x; j < maxX; j++) {
    			if(map[i][j] != 0 && s[i-y][j-x] == 1) return false;
    		}
    	}
    	
    	return true;
    }
    
    public static int[][] rotate(int h, int w, int[][] s){
    	int[][] r = new int[w][h];
    	
    	for(int i = 0; i < h; i++) {
    		for(int j = 0; j < w; j++) {
    			r[j][(h-1)-i] = s[i][j];
    		}
    	}
    	
    	return r;
    }
}