import java.io.File
import java.math.BigInteger

fun desemberThird1() {
    val file = File("/Users/vetledrage/Documents/AdventsKalender/AdventOfCode2025/src/main/kotlin/input3.csv")
    var sum = 0
    file.forEachLine { line ->
        if (line.isNotBlank()) {
            val digits = line.map { it.digitToInt() }
            var maxJoltage = 0
            for (i in 0 until digits.size - 1) {
                for (j in i + 1 until digits.size) {
                    val value = digits[i] * 10 + digits[j]
                    if (value > maxJoltage) {
                        maxJoltage = value
                    }
                }
            }
            sum += maxJoltage
        }
    }

    println(sum)
}

fun desemberThird2() {
    val file = File("/Users/vetledrage/Documents/AdventsKalender/AdventOfCode2025/src/main/kotlin/input3.csv")
    var total = BigInteger.ZERO
    file.forEachLine { line ->
        if (line.isNotBlank()) {
            val digits = line.map { it }
            val toRemove = digits.size - 12
            var removalsLeft = toRemove
            val stack = ArrayDeque<Char>()
            for (d in digits) {
                while (
                    stack.isNotEmpty() &&
                    removalsLeft > 0 &&
                    stack.last() < d
                ) {
                    stack.removeLast()
                    removalsLeft--
                }
                stack.addLast(d)
            }
            val resultDigits = stack.take(12).joinToString("")
            total += BigInteger(resultDigits)
        }
    }

    println(total)
}


fun main() {
    desemberThird1()
    desemberThird2()
}
