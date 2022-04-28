package programers

class Lotto {

    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val winNumMap = hashMapOf<Int, Int>()
        win_nums.forEach {
            winNumMap[it] = 0
        }

        lottos.forEach {
            if (winNumMap[it] != null) {
                winNumMap[it] = 1
            }
        }

        val matchedCount = winNumMap.count { it.value == 1 }
        val count = lottos.count { it == 0 }

        return intArrayOf(getRank(matchedCount + count), getRank(matchedCount))
    }

    /*
        1	6개 번호가 모두 일치
        2	5개 번호가 일치
        3	4개 번호가 일치
        4	3개 번호가 일치
        5	2개 번호가 일치
        6(낙첨)	그 외
    */
    private fun getRank(matchedCount: Int): Int = when (matchedCount) {
        0 -> 6
        1 -> 6
        2 -> 5
        3 -> 4
        4 -> 3
        5 -> 2
        6 -> 1
        else -> 1
    }
}