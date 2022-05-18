package thisiscote.chapter5

class FreezeDrink {


    private lateinit var visits: Array<IntArray>

    fun solution(array: Array<IntArray>): Int {
        var answer = 0
        val size = array.size
        visits = Array(size) { IntArray(array[0].size) { 0 } }

        for (i in 0 until size) {
            for (j in 0 until array[i].size) {
                if (dfs(array, i, j)) answer++
            }
        }

        return answer
    }

    private fun dfs(array: Array<IntArray>, row: Int, column: Int): Boolean {
        if (row < 0 || column < 0 || row >= array.size || column >= array[0].size) return false

        if (visits[row][column] == 1) return false

        if (array[row][column] == 0) {
            visits[row][column] = 1
            dfs(array, row - 1, column)
            dfs(array, row + 1, column)
            dfs(array, row, column - 1)
            dfs(array, row, column + 1)
            return true
        }

        return false
    }
}