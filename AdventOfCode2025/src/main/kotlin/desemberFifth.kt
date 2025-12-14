import java.io.File

fun desemberFifth1() {
    val file = File("src/main/kotlin/input5.csv")

    val ranges = mutableListOf<LongRange>()
    val availableIds = mutableListOf<Long>()

    var readingRanges = true

    file.forEachLine { line ->
        if (line.isBlank()) {
            readingRanges = false
            return@forEachLine
        }
        if (readingRanges) {
            val (start, end) = line.split('-').map { it.toLong() }
            ranges.add(start..end)
        } else {
            availableIds.add(line.toLong())
        }
    }
    var freshCount = 0
    for (id in availableIds) {
        if (ranges.any { id in it }) {
            freshCount++
        }
    }
    println("answer: "+ freshCount)
}

fun main() {
    desemberFifth1()
}
/*
fun desemberFifth1() {
    val file = File("src/main/kotlin/input5.csv")
    val mapOfIngredians = HashMap<String, Boolean>()
    file.forEachLine { line ->
        if (line.isNotBlank() && '-' !in line) {
            mapOfIngredians[line] = false
        }

    }
    file.forEachLine { line ->
        val parts = line.split('-')
        val start = parts[0].toLong()
        val end = parts[1].toLong()
        val range = start..end
        for (i in range) {
            if (mapOfIngredians.get(i.toString())==false)
                mapOfIngredians[i.toString()]=true
        }
    println(mapOfIngredians)
    }
}
*/