import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        String tk[] = line.split("/");
        int k = Integer.valueOf(tk[0]);
        int d = Integer.valueOf(tk[1]);
        int a = Integer.valueOf(tk[2]);
        
        if (k + a < d || d == 0)
            System.out.println("hasu");
        else
            System.out.println("gosu");
    }
}