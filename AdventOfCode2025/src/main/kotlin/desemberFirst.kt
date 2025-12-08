import java.io.File

fun desemberFirst1() {
    val file = File("/Users/vetledrage/Documents/AdventsKalender/AdventOfCode2025/src/main/kotlin/input.csv")
    var sum = 50
    var counter = 0
    file.forEachLine { line ->
        if (line.isNotBlank()) {
            val direction = line[0]
            val value = line.substring(1).toInt()
            sum = if (direction == 'R') {
                (sum + value) % 100
            } else {
                (sum - value) % 100
            }
            if (sum < 0) sum += 100
            if (sum == 0) counter++
        }
    }
    println(counter)
}

fun main() {
    desemberFirst1()
}
