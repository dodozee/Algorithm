import java.util.*;

public class Main {//ㅂㅏㄱㄷㅜㅈㅣㅎㅗㅏㅇㅣㅌㅣㅇ
    static ArrayList<Integer> card = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        for (int i=1; i<21; i++) card.add(i);
        for (int i=0; i<10; i++) reverse(s.nextInt(), s.nextInt());
        for (int i : card) System.out.print(i + " ");
    }
    static void reverse(int start, int end){
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i=start; i<=end; i++)
            temp.add(card.remove(start-1));
        for (int i : temp)
            card.add(start-1, i);
    }
}