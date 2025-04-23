import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int n;
    static LinkedList<Belt> conveyor;
    static boolean[] robot;
    static int step = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int size = 2 * n;
        conveyor = new LinkedList<>();
        robot = new boolean[size];
		
        String[] durability = bf.readLine().split(" ");
        for(int i = 0; i < size; i++){
            conveyor.add(i, new Belt(Integer.parseInt(durability[i])));              
        }

        while(k > 0) {
            MoveConveyor();
            MoveRobot();
        }

        bw.write(step+ "");
        bw.flush();
        bw.close();
    }

    static void MoveConveyor(){
        step++;
        conveyor.add(0, conveyor.removeLast());
        if(conveyor.get(n - 1).robot) conveyor.get(n - 1).robot = false;
    }

    static void MoveRobot(){

        for(int i = n - 1; i > 0; i--){
            if(!conveyor.get(i).robot) continue;

            if(conveyor.get(i + 1).robot == true || conveyor.get(i+1).durability <=0) continue;

            conveyor.get(i).robot = false;
            conveyor.get(i+1).putRobot();
            if(conveyor.get(i+1).durability <= 0) k--;

            if(i + 1 == n - 1) conveyor.get(i + 1).robot = false;
        }

        if(conveyor.get(0).durability > 0) {
            conveyor.get(0).putRobot();
            if(conveyor.get(0).durability <= 0) k--;
        }

    }

    static class Belt{
        int durability; 
        boolean robot; 

        public Belt(int durability){
            this.durability = durability;
            robot = false;
        }

        public void putRobot(){
            robot = true;
            durability--;
        }

    }

}