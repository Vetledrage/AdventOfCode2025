import java.io.File

fun desemberFourth1() {
    val file = File("src/main/kotlin/input4.csv")
    var array1: Array<String>? = null // top row
    var array2: Array<String>? = null // middle row
    var array3: Array<String>? = null // bottom row
    var counter = 0
    file.forEachLine { line ->
        if (line.isNotBlank()) {
            val newRow = line.map { it.toString() }.toTypedArray()
            array3 = array2   // old middle becomes bottom
            array2 = array1   // old top becomes middle
            array1 = newRow   // new row becomes top
            // Only start checking when we have 3 rows
            if (array1 != null && array2 != null && array3 != null) {
                val top = array1!!
                val mid = array2!!
                val bot = array3!!
                for (i in mid.indices) {
                    var paperCounter = 0
                    if (mid[i] == "@") {
                        if (i - 1 >= 0 && mid[i - 1] == "@") paperCounter++
                        if (i + 1 < mid.size && mid[i + 1] == "@") paperCounter++
                        if (i - 1 >= 0 && top[i - 1] == "@") paperCounter++
                        if (top[i] == "@") paperCounter++
                        if (i + 1 < top.size && top[i + 1] == "@") paperCounter++
                        if (i - 1 >= 0 && bot[i - 1] == "@") paperCounter++
                        if (bot[i] == "@") paperCounter++
                        if (i + 1 < bot.size && bot[i + 1] == "@") paperCounter++
                    }
                    if (paperCounter < 4) {
                        counter++
                    }
                }
            }
        }
    }

    println("FINAL RESULT: $counter")
}

fun main() {
    desemberFourth1()
    desemberFourth3()
}
//GPT solution
fun desemberFourth3() {
    val file = File("src/main/kotlin/input4.csv")
    // Read full input into a grid
    val grid = file.readLines().filter { it.isNotBlank() }
        .map { line -> line.toCharArray().toTypedArray() }
    val rows = grid.size
    val cols = grid[0].size
    var accessible = 0
    // Directions (8 neighbors)
    val directions = listOf(
        Pair(-1, -1), Pair(-1, 0), Pair(-1, 1),
        Pair(0, -1),              Pair(0, 1),
        Pair(1, -1), Pair(1, 0), Pair(1, 1)
    )
    // Scan entire grid
    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (grid[r][c] == '@') {
                var neighborCount = 0
                for ((dr, dc) in directions) {
                    val nr = r + dr
                    val nc = c + dc
                    if (nr in 0 until rows && nc in 0 until cols) {
                        if (grid[nr][nc] == '@')
                            neighborCount++
                    }
                }
                // Fewer than 4 neighbors → accessible
                if (neighborCount < 4)
                    accessible++
            }
        }
    }

    println("Accessible rolls: $accessible")
}
