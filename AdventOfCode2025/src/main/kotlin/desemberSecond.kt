import java.io.File

fun desemberSecond1() {
    val file = File("/Users/vetledrage/Documents/AdventsKalender/AdventOfCode2025/src/main/kotlin/input2.csv")
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
                        println(sum)
                    }
            }
            }

        }}}
fun desemberSecond2() {
    val file = File("/Users/vetledrage/Documents/AdventsKalender/AdventOfCode2025/src/main/kotlin/input2.csv")
    var sum = 0L
    file.forEachLine { line ->
        if (line.isNotBlank()) {
            val range = line.split(",")
            for (x in range){
                val numbers = x.split("-")
                val number1 =numbers[0].toLong()
                val number2 = numbers[1].toLong()
                for (i in number1..number2) {
                    val numberStr = i.toString()
                    val size = numberStr.length
                    for (x in 1..size) {
                        if (x > size / 2) break
                        if (size % x != 0) continue
                        val block = numberStr.substring(0, x)
                        //for (i in )

                    }
                }
            }
        }
    }
}
fun main() {
    //desemberSecond1()
    desemberSecond2()
}



