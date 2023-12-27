import java.util.Scanner;

public class Main { //박두지 화이팅!!
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
      
    for(int i = 0 ; i<n ; i++){
      String str = sc.nextLine();
      String[] arr = str.split(" ");
        
      float num = Float.parseFloat(arr[0]);
        
      for(int j = 1 ; j<arr.length ; j++){
        if(arr[j].equals("@")) num *= 3;
        else if(arr[j].equals("%")) num += 5;
        else if(arr[j].equals("#")) num -= 7;
      }
      System.out.println(String.format("%.2f",num));
    }
  }
}