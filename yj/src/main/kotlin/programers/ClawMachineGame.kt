package programers

import java.util.*

class ClawMachineGame {

    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val boardMap = hashMapOf<Int, ArrayDeque<Int>>()
        board.forEachIndexed { index, _ ->
            boardMap[index] = ArrayDeque()
        }

        board.map {
            it.mapIndexed { index, i ->
                if (i != 0)
                    boardMap[index]?.add(i)
            }
        }
        var basket = arrayListOf(0)
        moves.forEach {
            val move = it - 1
            if (boardMap[move]?.isEmpty() != true) {
                val pop = boardMap[move]?.poll()
                if (basket.last() == pop) {
                    answer += 2
                    basket.removeLast()
                } else {
                    if (pop != null)
                        basket.add(pop)
                }
            }
        }
        return answer
    }

    fun bestSolution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val stack = Stack<Int>()

        moves.forEach {
            for (i in board.indices) {
                if (board[i][it - 1] != 0) {
                    if (stack.isNotEmpty() && stack.peek() == board[i][it - 1]) {
                        answer += 2
                        stack.pop()
                    } else {
                        stack.push(board[i][it - 1])
                    }
                    board[i][it - 1] = 0

                    break
                }
            }
        }
        return answer
    }
}