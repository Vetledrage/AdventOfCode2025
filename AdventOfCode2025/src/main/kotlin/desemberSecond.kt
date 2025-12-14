import java.io.File

fun desemberSecond1() {
    val file = File("src/main/kotlin/input2.csv")
    var sum = 0L
    file.forEachLine { line ->
        if (line.isNotBlank()) {
            val range = line.split(",")
            for (x in range){
                val numbers = x.split("-")
                val number1 =numbers[0].toLong()
                val number2 = numbers[1].toLong()
                for (i in number1..number2 ){
                    val mid=i.toString().length/2
                    val first = i.toString().substring(0, mid)
                    val second = i.toString().substring(mid)
                    if (first==second){
                        sum+=i
                    }
            }
            }
        }
        println("PART 1: "+sum)}}

fun isInvalidId(id: Long): Boolean {
    val s = id.toString()
    val n = s.length
    for (blockLen in 1..(n / 2)) {
        if (n % blockLen != 0) continue
        val block = s.substring(0, blockLen)
        var ok = true
        var idx = 0
        while (idx < n) {
            if (!s.startsWith(block, idx)) {
                ok = false
                break
            }
            idx += blockLen
        }
        if (ok) {
            return true
        }
    }
    return false
}

fun desemberSecond2() {
    val file = File("src/main/kotlin/input2.csv")
    var sum = 0L
    file.forEachLine { line ->
        if (line.isNotBlank()) {
            val ranges = line.split(",")
            for (range in ranges) {
                if (range.isBlank()) continue
                val parts = range.split("-")
                val start = parts[0].toLong()
                val end = parts[1].toLong()
                for (id in start..end) {
                    if (isInvalidId(id)) {
                        sum += id
                    }
                }
            }
        }
    }

    println("PART 2: "+sum)
}

fun main() {
    desemberSecond1()
    desemberSecond2()
}



