package programers

/*
숫자	영단어
,"0"	zero
,"1"	one
,"2"	two
,"3"	three
,"4"	four
,"5"	five
,"6"	six
,"7"	seven
,"8"	eight
,"9"	nine
 */
class NumericStringsAndEnglishWords {
    fun solution(s: String): Int {
        var word = s
        while (!word.all { it.isDigit() }) {
            word = word.replace("zero", "0")
            word = word.replace("one", "1")
            word = word.replace("two", "2")
            word = word.replace("three", "3")
            word = word.replace("four", "4")
            word = word.replace("five", "5")
            word = word.replace("six", "6")
            word = word.replace("seven", "7")
            word = word.replace("eight", "8")
            word = word.replace("nine", "9")
        }
        return word.toInt()
    }

    fun bestSolution(s: String): Int {
        var answer = s
        val dict = mapOf(
            "zero" to 0,
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9
        )
        for ((k, v) in dict) {
            answer = answer.replace(k, v.toString())
        }
        return answer.toInt()
    }

}