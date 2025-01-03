import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int[][] map = new int[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char [] arr = br.readLine().toCharArray();
        int x = 0;
        int y = 0;
        
        Set<Point> set = new HashSet<>();
        set.add(new Point(x, y));
        for(int i = 0; i < n; i++) {
            if(arr[i] == 'E') {
                x++;
            } else if(arr[i] == 'W') {
                x--;
            } else if(arr[i] == 'S') {
                y--;
            } else {
                y++;
            }
            set.add(new Point(x, y));
        }
        
        System.out.println(set.size());

//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == 'E') {
//                x++;
//            }else if(arr[i] == 'W') {
//                x--;
//            } else if (arr[i] == 'S') {
//                y--;
//            } else {
//                y++;
//            }
//        }
    }
}

class Point{
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object object) {
        Point point = (Point) object;
        return this.x == point.x && this.y == point.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}