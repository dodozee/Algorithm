import java.io.*;
import java.util.*;

public class Main {//박두지 화이팅!!!! 갓천대 화이팅!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            HashMap<String, String> animalSounds = new HashMap<>();//HashMap 생성
            ArrayList<String> animalSound = new ArrayList<>();
            while(st.hasMoreTokens()){
                animalSound.add(st.nextToken());
            }

            while (true) {
                String sound = br.readLine();
                if (sound.equals("what does the fox say?")) {
                    break;
                }

                StringTokenizer animalSay = new StringTokenizer(sound," ");
                animalSay.nextToken();//동물의 이름
                animalSay.nextToken();//gose
                animalSounds.put(animalSay.nextToken(), " ");
            }

            StringBuilder foxSound = new StringBuilder();
            int k=0;
            int size = animalSound.size();
            for(int j=0; j<size;j++) {
                String word = animalSound.get(j);
                if (!animalSounds.containsKey(word)) {
                    foxSound.append(word).append(" ");
                }

            }

            System.out.println(foxSound);
        }
    }
}
