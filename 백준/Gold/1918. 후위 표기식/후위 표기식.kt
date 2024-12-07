import java.lang.*
import java.util.*

fun main() {
    val str = readLine()!!
    val sb = StringBuilder()
    val stack = Stack<Char>()

    str.forEach {
        if (it in 'A'..'Z') {
            sb.append(it)
        } else {
            when (it) {
                '+', '-' -> {
                    while (stack.isNotEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop())
                    }
                    stack.push(it)
                }
                '*', '/' -> {
                    while (stack.isNotEmpty() && stack.peek() != '(' && stack.peek() != '-' && stack.peek() != '+') {
                        sb.append(stack.pop())
                    }
                    stack.push(it)
                }
                '(' -> {
                    stack.push(it)
                }
                ')' -> {
                    while (stack.isNotEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop())
                    }
                    if (stack.isNotEmpty() && stack.peek() == '(') {
                        stack.pop()
                    }
                }
            }
        }
    }
    while (stack.isNotEmpty()) {
        sb.append(stack.pop())
    }
    println(sb)
}