package thisiscote.chapter3

class UntilOne {

    fun solution(n: Int, k: Int): Int {
        var answer = 0
        var result = n
        while (result != 1) {
            if (result % k == 0) {
                result /= k
            } else {
                result--
            }
            answer++
        }

        return answer
    }

    fun secondSolution(n: Int, k: Int): Int {
        var answer = 0
        var result = n
        while (result != 1) {
            val rest = result % k
            if (rest == 0) {
                result /= k
                answer++
            } else {
                result -= rest
                answer += rest
            }
        }
        return answer
    }

    /*
        int result = 0;

        while (true) {
            // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            int target = (n / k) * k;
            result += (n - target);
            n = target;
            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (n < k) break;
            // K로 나누기
            result += 1;
            n /= k;
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        result += (n - 1);
     */

}