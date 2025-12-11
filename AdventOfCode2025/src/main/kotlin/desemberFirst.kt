import java.io.File

fun desemberFirst1() {
    val file = File("/Users/vetledrage/Documents/AdventsKalender/AdventOfCode2025/src/main/kotlin/input.csv")
    var sum = 50
    var counter = 0
    file.forEachLine { line ->
        if (line.isNotBlank()) {
            val direction = line.first()
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

fun desemberFirst2() {
    val file = File("/Users/vetledrage/Documents/AdventsKalender/AdventOfCode2025/src/main/kotlin/input.csv")
    var pos = 50
    var counter = 0
    file.forEachLine { line ->
        if (line.isNotBlank()) {
            val direction = line.first()
            val steps = line.drop(1).toInt()
            val delta = if (direction == 'R') 1 else -1
            repeat(steps) {
                pos = (pos + delta).mod(100)
                if (pos == 0) counter++
            }
        }
    }

    println(counter)
}



fun main() {
    desemberFirst1()
    desemberFirst2()
}