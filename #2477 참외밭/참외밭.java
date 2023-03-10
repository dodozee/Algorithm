import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();

        Point[] pList = new Point[6]; //Point 객체를 담을 배열
        Point p = new Point(0, 0);
        for (int i = 0; i < 6; i++) {

            int direction = s.nextInt();
            int length = s.nextInt();

            switch (direction) {	// swtich문으로 각 사각형 점 위치 객체 생성!
                case 1:
                    pList[i] = new Point(p.x + length, p.y);
                    break;
                case 2:
                    pList[i] = new Point(p.x - length, p.y);
                    break;
                case 3:
                    pList[i] = new Point(p.x, p.y - length);
                    break;
                case 4:
                    pList[i] = new Point(p.x, p.y + length);
                    break;
            }
            p = pList[i];
        }

        int max_X = Integer.MIN_VALUE, min_X = Integer.MAX_VALUE;
        int max_Y = Integer.MIN_VALUE, min_Y = Integer.MAX_VALUE;
        int mid_X = 0, mid_Y = 0;
        for (int i = 0; i < 6; i++) {	// 각 X, Y의 최대값, 최소값 구하기
            if (max_X < pList[i].x) {
                max_X = pList[i].x;
            }
            if (min_X > pList[i].x) {
                min_X = pList[i].x;
            }
            if (max_Y < pList[i].y) {
                max_Y = pList[i].y;
            }
            if (min_Y > pList[i].y) {
                min_Y = pList[i].y;
            }
        }

        for (int i = 0; i < 6; i++) {	// 작은 사각형의 점 구하기
            if (pList[i].x > min_X && pList[i].x < max_X) {//x좌표중에 min보다 크고 max보다 크면 작은 사각형이다!
                mid_X = pList[i].x;
            }
            if (pList[i].y > min_Y && pList[i].y < max_Y) {
                mid_Y = pList[i].y;
            }
        }

        int len_X = 0, len_Y = 0;
        for (int i = 0; i < 6; i++) {	// 작은 사각형의 점을 통해 작은 사각형의 각 변의 길이 구하기
            if (pList[i].x == mid_X && pList[i].y != mid_Y) {
                len_Y = Math.max(pList[i].y, mid_Y) - Math.min(pList[i].y, mid_Y);
            }
            if (pList[i].y == mid_Y && pList[i].x != mid_X) {
                len_X = Math.max(pList[i].x, mid_X) - Math.min(pList[i].x, mid_X);
            }
        }

        int big =  (max_Y - min_Y) * (max_X - min_X);	// 큰 사각형의 넓이!!
        int small = len_X * len_Y;	// 작은 사각형의 넓이!!

        System.out.println((big - small) * k);

    }
    }
class Point {	// 점 위치를 찍어내는 Point 클래스!
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}