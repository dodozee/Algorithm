import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var result = 0
    val pattern = arrayOf('K', 'O', 'R', 'E', 'A')
    val str = readLine()

    if (str.contains('K')) {
        var idx = 0
        for (i in str.indices) {
            if (str[i] == pattern[idx]) {
                when (idx) {
                    4 -> idx = 0
                    else -> idx++
                }

                result++
            } else {
                continue
            }
        }
    }

    bw.write("$result")
    bw.flush()
    bw.close()
}