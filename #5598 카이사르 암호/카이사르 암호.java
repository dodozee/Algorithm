import java.io.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] array = br.readLine().toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 65) {
                array[i] = 91;
            }
            if (array[i] == 66) {
                array[i] = 92;
            }
            if (array[i] == 67) {
                array[i] = 93;
            }
            System.out.print((char)(array[i] - 3));
        }
    }
}