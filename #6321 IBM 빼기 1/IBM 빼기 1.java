import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for(int i=0;i<n;i++){

            String ch = scanner.next();

            char[] chArr = ch.toCharArray();

            String chnum="";

            for(int j=0;j< chArr.length;j++){
                int chval=(char)((int)chArr[j])+1;

                if(chval>90){
                    chval=65;
                }
                chnum=chnum+(char)chval;
            }
            System.out.printf("String #%d%n",i+1);
            
            System.out.println(chnum);
            System.out.println();
            
        }
    }
}