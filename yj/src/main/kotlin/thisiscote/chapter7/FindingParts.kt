package thisiscote.chapter7

class FindingParts {

    fun solution(parts: IntArray, wants: IntArray): String {
        val answer = arrayListOf<String>()

        val partList = parts.toMutableList()

        for (want in wants) {
            if (search(partList, want)) {
                answer.add("yes")
            } else {
                answer.add("no")
            }
        }

        return answer.joinToString(" ")
    }

    private fun search(
        partList: MutableList<Int>,
        want: Int,
    ): Boolean {
        var start = 0
        var end = partList.lastIndex

        while (start <= end) {
            val middle = getMiddle(start, end)
            if (partList[middle] == want) {
                partList.removeAt(middle)
                return true
            } else if (partList[middle] < want) {
                start = middle + 1
            } else {
                end = middle - 1
            }
        }

        return false
    }

    private fun getMiddle(start: Int, end: Int) = (start + end) / 2
}