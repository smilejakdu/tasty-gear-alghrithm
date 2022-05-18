package thisiscote.chapter5

import java.util.*

class EscapeMaze {

    private lateinit var visits: Array<IntArray>
    private var rowSize: Int = 0
    private var columnSize: Int = 0
    private var queue = ArrayDeque<IntArray>()

    private val dr = intArrayOf(-1, +1, 0, 0)
    private val dc = intArrayOf(0, 0, -1, +1)

    fun solution(array: Array<IntArray>): Int {
        rowSize = array.size
        columnSize = array[0].size

        visits = Array(rowSize) {
            IntArray(columnSize) { 0 }
        }

        queue.push(intArrayOf(0, 0))
        bfs(array)

        return visits[rowSize - 1][columnSize - 1] + 1
    }

    private fun bfs(array: Array<IntArray>) {
        while (queue.isNotEmpty()) {
            val pop = queue.poll()
            val row = pop[0]
            val column = pop[1]
            dr.forEachIndexed { index, _ ->
                val nr = row + dr[index]
                val nc = column + dc[index]

                if (nr < 0 || nc < 0) return@forEachIndexed
                if (nr >= rowSize || nc >= columnSize) return@forEachIndexed

                if (visits[nr][nc] > 0) return@forEachIndexed

                if (array[nr][nc] == 1) {
                    visits[nr][nc] = visits[row][column] + 1
                    queue.push(intArrayOf(nr, nc))
                }
            }
        }
    }
}