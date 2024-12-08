import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val T = sc.nextInt() // 차 종류
    val arr = IntArray(5)

    // 참가자 정답 입력
    for (i in arr.indices) {
        arr[i] = sc.nextInt()
    }

    // 정답자 카운트해주기
    var cnt = 0
    for (i in arr.indices) {
        if (arr[i] == T) {
            cnt++
        }
    }
    println(cnt)
    sc.close()
}