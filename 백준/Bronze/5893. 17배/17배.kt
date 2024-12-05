import java.io.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    println((readLine().toBigInteger(2) * 17.toBigInteger()).toString(2))
}