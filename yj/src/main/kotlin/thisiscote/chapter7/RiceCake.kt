package thisiscote.chapter7

class RiceCake {

    fun solution(intArray: IntArray, length: Int): Int {
        var start = 0
        var end = intArray.maxOf { it }

        while (start <= end) {
            val middle = getMiddle(start, end)
            val total = intArray.filter { it > middle }
                .sumBy { it - middle }

            if (length == total) {
                return middle
            } else if (total > length) {
                start = middle + 1
            } else {
                end = middle - 1
            }
        }

        return 0
    }

    private fun getMiddle(start: Int, end: Int) = (start + end) / 2

}