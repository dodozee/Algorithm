
import java.io.*;
import java.util.*;

public class Main {
    private static final int DAY_OF_YEAR = 365;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String[]> team = new HashMap<>();
        HashMap<String, String> girl = new HashMap<>();

        while (n-- > 0) {
            String teamName = br.readLine();
            int k = Integer.parseInt(br.readLine());
            String[] teamMembers = new String[k];

            while (k-- > 0) {
                String name = br.readLine();
                teamMembers[k] = name;
                girl.put(name, teamName);
            }
            Arrays.sort(teamMembers);//왜 정렬? -> 팀원 이름을 사전순으로 정렬하기 위해

            team.put(teamName, teamMembers);


        }
        while (m-- > 0) {
            String tmp = br.readLine();
            int quiz = Integer.parseInt(br.readLine());

            switch(quiz){
                case 0:
                    for (String name : team.get(tmp)) {
                        System.out.println(name);
                    }
                    break;
                case 1:
                    System.out.println(girl.get(tmp));
            }
        }


    }
}


