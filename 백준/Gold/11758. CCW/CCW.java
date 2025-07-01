import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		Point[] point = new Point[3];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			point[i] = new Point(x, y);
		}

		bw.write(ccw(point) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	public static int ccw(Point[] p) {
		int result = ((p[0].x * p[1].y) + (p[1].x * p[2].y) + (p[2].x * p[0].y))
				- ((p[0].y * p[1].x) + (p[1].y * p[2].x) + (p[2].y * p[0].x));
		if (result > 0)
			return 1;
		else if (result == 0)
			return 0;
		else
			return -1;
	}
}