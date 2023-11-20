import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!
    static int numRows, numCols;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dR = {1, -1, 0, 0};
    static int[] dC = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numCols = Integer.parseInt(st.nextToken());
        numRows = Integer.parseInt(st.nextToken());

        maze = new int[numRows][numCols];
        visited = new boolean[numRows][numCols];

        for(int i = 0; i < numRows; i++){
            String[] input = br.readLine().split("");

            for(int j = 0; j < numCols; j++)
                maze[i][j] = Integer.parseInt(input[j]);
        }

        System.out.println(findShortestPath(0, 0));
    }

    static int findShortestPath(int startRow, int startCol){
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(startRow, startCol, 0));
        visited[startRow][startCol] = true;

        while(!queue.isEmpty()){
            Node current = queue.poll();

            if(current.row == numRows - 1 && current.col == numCols - 1) {
                return current.breakWall;
            }

            for(int i = 0; i < 4; i++){
                int nextRow = current.row + dR[i];
                int nextCol = current.col + dC[i];

                if(nextRow < 0 || nextCol < 0 || nextRow >= numRows || nextCol >= numCols)
                    continue;
                if(visited[nextRow][nextCol])
                    continue;

                if(maze[nextRow][nextCol] == 0)
                    queue.offer(new Node(nextRow, nextCol, current.breakWall));
                else
                    queue.offer(new Node(nextRow, nextCol, current.breakWall + 1));

                visited[nextRow][nextCol] = true;
            }
        }

        return 0;
    }
}

class Node implements Comparable<Node>{
    int row, col, breakWall;

    Node(int row, int col, int breakWall){
        this.row = row;
        this.col = col;
        this.breakWall = breakWall;
    }

    @Override
    public int compareTo(Node other){
        return this.breakWall - other.breakWall;
    }
}
