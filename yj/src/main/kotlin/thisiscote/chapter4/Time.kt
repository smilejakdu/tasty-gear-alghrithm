package thisiscote.chapter4

class Time {

    fun solution(n: Int): Int {
        // 15(3으로 이뤄진 초) * 45 = 675
        // 15(3으로 이뤄진 분) * 45
        // 15 * 60 = 900 * 2 - (15 * 15) * 5
        // 30
        // 3시 60 * 60
        // 10350

        val second = 15 * 60
        val minute = 15 * 60
        val distinct = 15 * 15

        var answer = (second + minute - distinct)

        if (n >= 3) {
            answer *= n
            answer += 60 * 60
        } else {
            answer *= n + 1
        }

        return answer
    }
}