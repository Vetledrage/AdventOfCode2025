import java.io.File

data class Problem(
    val numbers: MutableList<Long> = mutableListOf(),
    var operator: Char = '?'
)
fun desemberSixth1() {
    val problems = mutableListOf<Problem>()
    val file = File("src/main/kotlin/input6.csv")
    file.forEachLine { line ->
        val cells = line.trim().split(Regex("\\s+"))
        if (problems.isEmpty()) {
            repeat(cells.size) {
                problems.add(Problem())
            }
        }
        if (line.first() == '*' || line.first() == '+') {
            for (i in cells.indices) {
                problems[i].operator = cells[i].trim()[0]
            }
        }
        else {
            for (i in cells.indices) {
                problems[i].numbers.add(cells[i].trim().toLong())
            }
        }

    }
    val total = problems.sumOf { problem ->
        when (problem.operator) {
            '+' -> problem.numbers.sum()
            '*' -> problem.numbers.reduce(Long::times)
            else -> 0L
        }
    }
    println(total)
}
fun desemberSixth2() {
    val problems = mutableListOf<Problem>()
    val file = File("src/main/kotlin/input6.csv")
    file.forEachLine { line ->
        val cells = line.trim().split(Regex("\\s+"))
        if (problems.isEmpty()) {
            repeat(cells.size) {
                problems.add(Problem())
            }
        }
        TODO()
        //325
        // 34
        //  3
        // blir

    }
    val total = problems.sumOf { problem ->
        when (problem.operator) {
            '+' -> problem.numbers.sum()
            '*' -> problem.numbers.reduce(Long::times)
            else -> 0L
        }
    }
    println(total)
}


fun main() {
    desemberSixth1()
}