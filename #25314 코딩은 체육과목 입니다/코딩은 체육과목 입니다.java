import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        
        for(int i=0; i<n/4; i++){
            System.out.printf("long ");
        }System.out.println("int");
    }
}