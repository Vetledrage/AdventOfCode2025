import java.io.File

fun desemberThird1() {
    val file = File("/Users/vetledrage/Documents/AdventsKalender/AdventOfCode2025/src/main/kotlin/input3.csv")
    var sum=0
    file.forEachLine { line ->
        if (line.isNotBlank()) {
            val digits: List<Int> = line.map { it.digitToInt() }
            var biggest1 = digits.last()
            var biggest2 = Int.MIN_VALUE
            var array1= 0
            var array2= 0
            for (i in digits.lastIndex downTo 0) {
                val x = digits[i]                     // digit at position i
                if (x >= biggest1) {
                    biggest2 = biggest1
                    array2= array1
                    biggest1 = x
                    array1=i
                }
                else if (x > biggest2){
                    biggest2=x
                    array2=i
                }
            }
            if (array2 <array1){
                val value = "$biggest1$biggest2".toInt()
                sum+=value
            }
            else if (array1<array2){
                val value = "$biggest2$biggest1".toInt()
                sum+=value
            }
            println(sum)
        }
    }
}

fun main() {
    desemberThird1()
}