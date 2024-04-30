import java.io.*;
import java.sql.Array;
import java.util.*;


/**
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String find = br.readLine();

        int sizeOfLine = line.length();
        int sizeOfFind = find.length();

        line = line.replace(find, "");
        System.out.println((sizeOfLine-line.length())/sizeOfFind);
    }
}