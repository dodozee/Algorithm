import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        
        HashMap<String,Integer> dict=new HashMap<>();
        ArrayList<String> people=new ArrayList<>();
        StringTokenizer st;

        int[] time={4,6,4,10};
        int n=Integer.parseInt(br.readLine());

        for(int i=0; i<n*4; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<7; j++){
                String temp=st.nextToken();
                if(temp.equals("-")){
                    continue;
                }
                else if(dict.get(temp)==null){
                    dict.put(temp,time[i%4]);
                    people.add(temp);
                }
                else{
                    dict.put(temp,dict.get(temp)+time[i%4]);
                }
            }
        }

        boolean right=true;
        int min=2000001;
        int max=0;
        for(int i=0; i<people.size(); i++){
            int temp=dict.get(people.get(i));
            max= max > temp ? max :temp;
            min= min < temp ? min : temp;
        }
        right= max-min > 12 ? false : true;
        bw.write(right==true ? "Yes" : "No");
        bw.flush();
    }
}