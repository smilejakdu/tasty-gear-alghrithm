package programers.level1

import kotlin.math.abs

class KeyPad {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        val handMap = hashMapOf(
            1 to 'L',
            4 to 'L',
            7 to 'L',
            3 to 'R',
            6 to 'R',
            9 to 'R',
        )
        val keyPadMap = hashMapOf(
            1 to intArrayOf(0, 0),
            2 to intArrayOf(0, 1),
            3 to intArrayOf(0, 2),
            4 to intArrayOf(1, 0),
            5 to intArrayOf(1, 1),
            6 to intArrayOf(1, 2),
            7 to intArrayOf(2, 0),
            8 to intArrayOf(2, 1),
            9 to intArrayOf(2, 2),
            10 to intArrayOf(3, 0),
            12 to intArrayOf(3, 2),
            0 to intArrayOf(3, 1),
        )

        val mainHand = if (hand == "right") "R" else "L"
        var currentLeft = 10
        var currentRight = 12
        numbers.forEach {
            when (handMap[it]) {
                'L' -> {
                    currentLeft = it
                    answer = answer.plus("L")
                }
                'R' -> {
                    currentRight = it
                    answer = answer.plus("R")
                }
                else -> {
                    val leftPosition = keyPadMap[currentLeft]!!
                    val rightPosition = keyPadMap[currentRight]!!
                    val selectedPosition = keyPadMap[it]!!

                    val leftCount = abs(selectedPosition[0] - leftPosition[0]) + abs(selectedPosition[1] - leftPosition[1])
                    val rightCount = abs(selectedPosition[0] - rightPosition[0]) + abs(selectedPosition[1] - rightPosition[1])

                    answer = if (leftCount == rightCount) {
                        if (mainHand == "R") {
                            currentRight = it
                        } else {
                            currentLeft = it
                        }
                        answer.plus(mainHand)
                    } else if (leftCount > rightCount) {
                        currentRight = it
                        answer.plus("R")
                    } else {
                        currentLeft = it
                        answer.plus("L")
                    }
                }
            }
        }

        return answer
    }
}