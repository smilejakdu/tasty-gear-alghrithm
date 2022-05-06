package thisiscote.chapter3

class BigNumberLaw {

    fun solution(array: IntArray, m: Int, k: Int): Int {
        var answer = 0
        array.max()
        val firstMax = array.maxOf { it }
        val list = array.toMutableList()
        list.remove(firstMax)
        val secondMax = list.maxOf { it }
        var count = 0
        for (i in 0 until m) {
            if (count == k) {
                answer += secondMax
                count = 0
            } else {
                answer += firstMax
            }
            count++
        }
        return answer
    }

    /*
        Arrays.sort(arr); // 입력 받은 수들 정렬하기
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수

        // 가장 큰 수가 더해지는 횟수 계산
        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1);

        int result = 0;
        result += cnt * first; // 가장 큰 수 더하기
        result += (m - cnt) * second; // 두 번째로 큰 수 더하기

        System.out.println(result);
     */
}