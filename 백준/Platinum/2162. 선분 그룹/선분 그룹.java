import java.io.*;
import java.util.StringTokenizer;

class Point {
	double x1;
	double y1;
	double x2;
	double y2;

	Point(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}

public class Main {
	static final int INF = 5000;
	static int[] parent; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		parent = new int[N];
		Point[] points = new Point[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			parent[i] = i;
			double x1 = Double.parseDouble(st.nextToken());
			double y1 = Double.parseDouble(st.nextToken());
			double x2 = Double.parseDouble(st.nextToken());
			double y2 = Double.parseDouble(st.nextToken());

			points[i] = new Point(x1, y1, x2, y2);
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				Point p1 = points[i];
				Point p2 = points[j];

				double res = intersectionPointX(p1, p2);

				if (res == INF + 1) {
					if (p1.x2 - p1.x1 == 0 && p2.x2 - p2.x1 == 0) {
						if (p1.x1 != p2.x1) {
							continue;
						}

						if ((p1.y1 > p2.y1 && p1.y1 > p2.y2 && p1.y2 > p2.y1 && p1.y2 > p2.y2)
								|| (p2.y1 > p1.y1 && p2.y1 > p1.y2 && p2.y2 > p1.y1 && p2.y2 > p1.y2)) {
							continue;
						}

						union(i, j);
						continue;
					}

					// x = a 형태가 아닌 경우
					double m1 = (p1.y2 - p1.y1) / (p1.x2 - p1.x1);
					double m2 = (p2.y2 - p2.y1) / (p2.x2 - p2.x1);

					double n1 = -m1 * p1.x1 + p1.y1;
					double n2 = -m2 * p2.x1 + p2.y1;

					if (n1 != n2) {
						continue;
					}

					if ((p1.x1 > p2.x1 && p1.x1 > p2.x2 && p1.x2 > p2.x1 && p1.x2 > p2.x2)
							|| (p2.x1 > p1.x2 && p2.x1 > p1.x2 && p2.x2 > p1.x1 && p2.x2 > p1.x2)) {
						continue;
					}

					if ((p1.y1 > p2.y1 && p1.y1 > p2.y2 && p1.y2 > p2.y1 && p1.y2 > p2.y2)
							|| (p2.y1 > p1.y1 && p2.y1 > p1.y2 && p2.y2 > p1.y1 && p2.y2 > p1.y2)) {
						continue;
					}

					union(i, j);
				} else {
					if (res >= Math.min(p1.x1, p1.x2) && res <= Math.max(p1.x1, p1.x2) && res >= Math.min(p2.x1, p2.x2)
							&& res <= Math.max(p2.x1, p2.x2)) {
						res = intersectionPointY(p1, p2);

						if (res <= INF && res >= -INF) {
							if (res >= Math.min(p1.y1, p1.y2) && res <= Math.max(p1.y1, p1.y2)
									&& res >= Math.min(p2.y1, p2.y2) && res <= Math.max(p2.y1, p2.y2)) {
								union(i, j);
							}
						}
					}
				}
			}
		}

		// parent의 0 ~ N까지 본인의 루트 노드에 해당하는
		// 값이 몇 개인지 계산함.
		int[] cnt = new int[N];
		for (int i = 0; i < N; i++) {
			cnt[find(i)]++;
		}

		int groupCnt = 0;
		int lineCnt = 0;

		for (int i = 0; i < N; i++) {
			// cnt가 0이 아니면 다른 노트에 대하여 합집합 연산을
			// 최소 1번이상 했다는 의미임.
			if (cnt[i] > 0) {
				groupCnt++;
			}

			lineCnt = Math.max(lineCnt, cnt[i]);
		}

		bw.write(groupCnt + "\n" + lineCnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			if (x < y) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}

	public static double intersectionPointX(Point p1, Point p2) {
		if ((p1.x1 - p1.x2) * (p2.y1 - p2.y2) - (p1.y1 - p1.y2) * (p2.x1 - p2.x2) == 0) {
			return INF + 1;
		}

		double denominator = ((p1.x1 * p1.y2 - p1.y1 * p1.x2) * (p2.x1 - p2.x2))
				- ((p1.x1 - p1.x2) * (p2.x1 * p2.y2 - p2.y1 * p2.x2));
		double numerator = ((p1.x1 - p1.x2) * (p2.y1 - p2.y2)) - ((p1.y1 - p1.y2) * (p2.x1 - p2.x2));

		return denominator / numerator;
	}

	public static double intersectionPointY(Point p1, Point p2) {
		if ((p1.x1 - p1.x2) * (p2.y1 - p2.y2) - (p1.y1 - p1.y2) * (p2.x1 - p2.x2) == 0) {
			return INF + 1;
		}

		double denominator = ((p1.x1 * p1.y2 - p1.y1 * p1.x2) * (p2.y1 - p2.y2)
				- (p1.y1 - p1.y2) * (p2.x1 * p2.y2 - p2.y1 * p2.x2));
		double numerator = ((p1.x1 - p1.x2) * (p2.y1 - p2.y2) - (p1.y1 - p1.y2) * (p2.x1 - p2.x2));

		return denominator / numerator;
	}

}