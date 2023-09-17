import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {//박두지 화이팅!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] chessBoard = new char[8][8];
        
        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                chessBoard[i][j] = line.charAt(j);
            }
        }
        
        int count = 0;
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0 && chessBoard[i][j] == 'F') {
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }
}
