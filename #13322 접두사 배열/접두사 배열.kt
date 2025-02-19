import java.io.*;

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    readLine().forEachIndexed { index, c ->
        bw.appendLine("$index")
    }
    bw.flush()
    bw.close()
}