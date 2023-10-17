import java.util.*;

public class Main { //박두지 화이팅!!
       public static void main(String[] args){
            Scanner s = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();
            int t = s.nextInt();

            for(int i=0; i<t; i++){
                 int n = s.nextInt();
                 int people = 0;

                 boolean[] room = new boolean[n+1];
                 Arrays.fill(room, false);
            
                 for(int round=1; round<=n; round++){
                 
                     for(int j=0; j<room.length; j++){
                     
                          if(j%round==0){
                               room[j] = !room[j];
                          }
                     }
                 }

                 for(int j=1; j<room.length; j++){
                 
                      if(room[j]){
                     
                          people++;
                     }
                 }
            
                 sb.append(people + "\n");
            }
        
        System.out.println(sb.toString());
     }
}

