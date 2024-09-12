import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Building> buildings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            buildings.add(new Building(left, right));
        }

        Collections.sort(buildings, Comparator.comparingInt(b -> b.left)); // x축 기준 정렬

        int totalArea = 0;
        int maxHeightIndex = 0;

        Building currentBuilding = buildings.get(0);
        for (int i = 1; i < buildings.size(); i++) {
            Building nextBuilding = buildings.get(i);

            if (currentBuilding.right <= nextBuilding.right) {
                totalArea += (nextBuilding.left - currentBuilding.left) * currentBuilding.right;
                currentBuilding = nextBuilding;
                maxHeightIndex = i;
            }
        }

        currentBuilding = buildings.get(buildings.size() - 1);
        for (int i = 1; i < buildings.size() - maxHeightIndex; i++) {
            Building nextBuilding = buildings.get(buildings.size() - 1 - i);

            if (currentBuilding.right <= nextBuilding.right) {
                totalArea += (currentBuilding.left - nextBuilding.left) * currentBuilding.right;
                currentBuilding = nextBuilding;
            }
        }

        totalArea += buildings.get(maxHeightIndex).right;

        System.out.println(totalArea);
    }
    
     static class Building {
        int left;
        int right;

        public Building(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
