package programers

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
        var left = 10
        var right = 12
        numbers.forEach {
            when (handMap[it]) {
                'L' -> {
                    left = it
                    answer = answer.plus("L")
                }
                'R' -> {
                    right = it
                    answer = answer.plus("R")
                }
                else -> {
                    val l = keyPadMap[left]!!
                    val r = keyPadMap[right]!!
                    val i = keyPadMap[it]!!

                    val leftCount = abs(i[0] - l[0]) + abs(i[1] - l[1])
                    val rightCount = abs(i[0] - r[0]) + abs(i[1] - r[1])

                    answer = if (leftCount == rightCount) {
                        if (mainHand == "R") {
                            right = it
                        } else {
                            left = it
                        }
                        answer.plus(mainHand)
                    } else if (leftCount > rightCount) {
                        right = it
                        answer.plus("R")
                    } else {
                        left = it
                        answer.plus("L")
                    }
                }
            }
        }

        return answer
    }
}