import java.io.*;
import java.util.*;

public class Main {
    static List<List<Point>> pointGroup = new ArrayList<>();
    static List<Rectangle> rectangles = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        List<List<Integer>> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t * 4; i++) {
            st = new StringTokenizer(br.readLine());

            int px1 = Integer.parseInt(st.nextToken());
            int py1 = Integer.parseInt(st.nextToken());

            List<Integer> l = new ArrayList<>();
            l.add(px1);
            l.add(py1);
            list.add(l);
        }

        for (int i = 0; i < list.size(); i += 4) {
            List<Point> points = new ArrayList<>();
            for (int j = i; j < i + 4; j++) {
                Point point = new Point(list.get(j).get(0), list.get(j).get(1));
                points.add(point);
            }
            pointGroup.add(points);
        }

        for (List<Point> pg : pointGroup) {
            Rectangle r = new Rectangle(pg.get(0), pg.get(1), pg.get(2), pg.get(3));
            rectangles.add(r);
        }

        for (Rectangle r : rectangles) {
            System.out.println(r.isSquare());
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public Double toDistance(Point p) {
            return Math.sqrt(Math.pow(p.getX() - this.x, 2) + Math.pow(p.getY() - this.y, 2));
        }
    }

    static class Rectangle {
        private List<Point> points = new ArrayList<>();
        private Set<Double> distanceSet = new HashSet<>();

        public Rectangle(Point p1, Point p2, Point p3, Point p4) {
            points.add(p1);
            points.add(p2);
            points.add(p3);
            points.add(p4);
            setDistances();
        }

        private void setDistances() {
            Double distance;
            for (int i = 0; i < points.size() - 1; i++) {
                for (int j = i + 1; j < points.size(); j++) {
                    distance = points.get(i).toDistance(points.get(j));
                    distanceSet.add(distance);
                }
            }
        }

        public void print() {
            System.out.println(distanceSet);
        }

        public Integer isSquare() {
            return (distanceSet.size() == 2) ? 1 : 0;
        }
    }
}
